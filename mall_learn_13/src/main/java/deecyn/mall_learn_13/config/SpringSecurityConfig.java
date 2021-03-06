package deecyn.mall_learn_13.config;

import deecyn.mall_learn_13.component.JwtAuthenticationTokenFilter;
import deecyn.mall_learn_13.component.RestAuthenticationEntryPoint;
import deecyn.mall_learn_13.component.RestfulAccessDeniedHandler;
import deecyn.mall_learn_13.dto.AdminUserDetails;
import deecyn.mall_learn_13.mbg.model.UmsAdmin;
import deecyn.mall_learn_13.mbg.model.UmsPermission;
import deecyn.mall_learn_13.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Spring Security 的配置类
 */
@Configuration
@EnableWebSecurity // 启用 Spring Security 的 Web 安全支持
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /** 对 HttpSecurity 进行配置，配置路径及资源的访问权限  */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 由于使用的是 JWT，所以这里不需要 CSRF
                .csrf().disable()
                // 配置会话管理，基于 token，所以不需要 session 。
                .sessionManagement()
                .and()
                // 允许基于使用 HttpServletRequest 限制访问：
                .authorizeRequests()
                    // 下面的配置都是基于 authorizeRequests() 方法的：
                    // 允许对网站静态资源的无授权访问
                    .antMatchers(HttpMethod.GET,
                            "/", "/*.html", "/favicon.ico", "/**/*.html",
                            "/**/*.css", "/**/*.js", "/swagger-resources/**",
                            "/v2/api-docs/**").permitAll()
                    // 对登录和注册要允许匿名访问
                    .antMatchers("/admin/login", "/admin/register").permitAll()
                    // 跨域请求会先进行一次 options 请求
                    .antMatchers(HttpMethod.OPTIONS).permitAll()
    //                .antMatchers("/**").permitAll() // 测试时全部允许访问
                    // 除开上面的配置外，其它的所有请求全部需要鉴权认证
                    .anyRequest()
                    .authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加 JWT 过滤器
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        // 添加自定义的未登录或者未授权时的返回结果
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 用于配置 AuthenticationManagerBuilder 创建的 AuthenticationManager 对象；
     * AuthenticationManager 对象用于实现内存验证、LADP 验证、基于 JDBC 的验证等。
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /** 设置对密码加密的编码器  */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义 UserDetailsService 中的 loadUserByUsername() 方法的逻辑
     */
    @Bean
    public UserDetailsService userDetailsService(){
        // 这里使用 Lambda 表达式实现
        return username -> {
            UmsAdmin admin = umsAdminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList =
                        umsAdminService.getPermissionList(admin.getId());
                return new AdminUserDetails(admin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
