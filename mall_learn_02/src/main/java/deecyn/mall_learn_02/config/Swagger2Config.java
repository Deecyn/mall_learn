package deecyn.mall_learn_02.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                // 为 basePackage 包下的 Controller 生成 API 文档
                .apis(RequestHandlerSelectors.basePackage("deecyn.mall_learn_02.controller"))

                // 为有 @Api 注解的 Controller 生成 API 文档
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))

                // 为有 @ApiOperation 注解的方法生成 API 文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger API 文档")
                .description("mall-learn-02")
                .version("1.02")
                .build();
    }
}
