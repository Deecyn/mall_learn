package deecyn.mall_learn_15.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Deecyn
 * @version 0.15
 * Description: JWT token 的工具类
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /** JWT 加密、解密使用的密钥  */
    @Value("${jwt.secret}")
    private String secret;

    /** token 的过期时间，毫秒数  */
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息生成 token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }


    /**
     * 从 token 中获取登录用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
     * 验证客户端的 token 是否还有效
     * @param token 客户端传入的 token
     * @param userDetails 从数据库查询出来的用户信息
     */
    public boolean validateClientToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername());
    }

    /**
     * 判断 token 是否可以被刷新
     * @param token 待刷新的 token
     * @return true -> 已过期，可以被刷新；false -> 不可以被刷新
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新 token
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 判断 token 是否已经失效
     * @param token 待判断的 token
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getClaimsFromToken(token).getExpiration();
        return expireDate.before(new Date());
    }

    /**
     * 从 token 中获取 JWT 的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            LOGGER.info("JWT 格式验证失败：{}", token);
        }

        return claims;
    }

    /**
     * 根据 JWT 中 payload 中的声明（claim），来生成 token。
     * @param claims JWT token 中的一些「声明」，键值对。（payload 的别称）
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                // 需要先调用 setClaims() 方法以创建一个 Claims 对象；
                .setClaims(claims)
                // 设置过期时间
                .setExpiration(generateExpirationDate())
                // 设置签名算法和加密密钥
                .signWith(SignatureAlgorithm.HS512, secret)
                // 将生成的 JWT 序列为一个字符串
                .compact();
    }

    /**
     * 生成 token 的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

}

