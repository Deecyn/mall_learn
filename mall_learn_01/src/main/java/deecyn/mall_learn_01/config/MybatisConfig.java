package deecyn.mall_learn_01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/4 20:37.
 */
@Configuration
@MapperScan("deecyn.mall_learn_01.dao")
public class MybatisConfig {
}
