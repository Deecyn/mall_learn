package deecyn.mall_learn_02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Configuration
@MapperScan("deecyn.mall_learn_02.dao")
public class MyBatisConfig {
}
