package deecyn.mall_learn_13.service.impl;

import deecyn.mall_learn_13.common.util.JwtTokenUtil;
import deecyn.mall_learn_13.mbg.mapper.UmsAdminMapper;
import deecyn.mall_learn_13.mbg.model.UmsAdmin;
import deecyn.mall_learn_13.mbg.model.UmsPermission;
import deecyn.mall_learn_13.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 后台用户管理 Service 的实现类
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Resource
    private UserDetailsService userDetailsService;


    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead")
    private String tokenHead;

    @Resource
    private UmsAdminMapper umsAdminMapper;






    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Integer adminId) {
        return null;
    }

}
