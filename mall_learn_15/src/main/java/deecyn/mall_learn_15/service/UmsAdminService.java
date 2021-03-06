package deecyn.mall_learn_15.service;


import deecyn.mall_learn_15.common.constant.AccountIntEnum;
import deecyn.mall_learn_15.common.util.JwtTokenUtil;
import deecyn.mall_learn_15.dao.UmsAdminRoleRelationDao;
import deecyn.mall_learn_15.mbg.mapper.UmsAdminMapper;
import deecyn.mall_learn_15.mbg.model.UmsAdmin;
import deecyn.mall_learn_15.mbg.model.UmsAdminExample;
import deecyn.mall_learn_15.mbg.model.UmsPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 后台用户管理 Service
 */
@Service
public class UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminService.class);

    @Value("${jwt.tokenHead")
    private String tokenHead;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenUtil jwtTokenUtil;

    private final UmsAdminMapper umsAdminMapper;

    private final UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Autowired
    public UmsAdminService(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder,
                               JwtTokenUtil jwtTokenUtil, UmsAdminMapper umsAdminMapper,
                               UmsAdminRoleRelationDao umsAdminRoleRelationDao) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.umsAdminMapper = umsAdminMapper;
        this.umsAdminRoleRelationDao = umsAdminRoleRelationDao;
    }

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return 后台管理员 UmsAdmin 对象
     */
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample adminExample = new UmsAdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(adminExample);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }


    /**
     * 注册功能
     * @param umsAdminParam
     * @return 注册成功的后台管理员 UmsAdmin 对象
     */
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        umsAdminParam.setCreateTime(LocalDateTime.now());
        umsAdminParam.setStatus(AccountIntEnum.STATUS_ENABLE.value());

        // 查询是否有相同用户名的用户
        UmsAdminExample adminExample = new UmsAdminExample();
        adminExample.createCriteria().andUsernameEqualTo(umsAdminParam.getUsername());
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(adminExample);
        if (adminList.size() > 0){
            return null;
        }

        // 将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdminParam.getPassword());
        umsAdminParam.setPassword(encodePassword);
        umsAdminMapper.insert(umsAdminParam);
        return umsAdminParam;
    }

    /**
     * 登录功能
     * @param username
     * @param password
     * @return 生成的 JWT 的 token
     */
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 获取用户所有权限（包括角色权限和额外增删的权限）
     * @param adminId
     * @return
     */
    public List<UmsPermission> getPermissionList(Integer adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }

}

