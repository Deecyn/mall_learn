package deecyn.mall_learn_02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 全局跨域配置
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        // 允许所有域名进行跨域调用
        corsConfig.addAllowedOrigin("*");
        // 允许跨域发送 cookie
        corsConfig.setAllowCredentials(true);
        // 放行所有请求头字段
        corsConfig.addAllowedHeader("*");
        // 允许所有请求方法跨域调用
        corsConfig.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsFilter(source);
    }
}
