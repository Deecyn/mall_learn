package deecyn.mall_learn_14.component;


import deecyn.mall_learn_14.common.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Deecyn
 * @version 0.14
 * Description: JWT 登录授权的过滤器
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /** http 请求的 Authorization 请求头 */
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /** Authorization 请求头中的身份验证方案，这里为 Bearer。  */
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 在用户名和密码校验前添加的过滤器，如果请求中有 jwt 的 token 且有效，会取出 token 中的用户名，
     * 然后调用SpringSecurity的API进行登录操作。
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 获取 http 请求的 Authorization 请求头信息
        String authHeader = request.getHeader(this.tokenHeader);
        // 如果 Authorization 请求头不为空，且身份验证方案为 tokenHead (Bearer) ，则表示此 HTTP 请求包含 JWT 的信息。
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            // 截取掉前面的 tokenHead 字符串 "Bearer"，获取 JWT 的 token 字符串
            String authToken = authHeader.substring(this.tokenHead.length());
            // 从 token 字符串解析出用户名
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            LOGGER.info("checking username:{}", username);

            // 校验该用户的身份
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateClientToken(authToken, userDetails)) {

                    // 根据 username 和 password 生成 UsernamePasswordAuthenticationToken 对象，
                    //   用于 AuthenticationManager 的验证。
                    UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user: {}", username);
                    SecurityContextHolder.getContext().setAuthentication(userAuthToken);
                }
            }
        }
        // 继续调用 Filter 链的其它 Filter 。
        filterChain.doFilter(request, response);
    }
}

