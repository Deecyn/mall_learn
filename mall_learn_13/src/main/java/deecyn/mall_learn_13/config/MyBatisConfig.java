package deecyn.mall_learn_13.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Configuration
@MapperScan({"deecyn.mall_learn_13.dao", "deecyn.mall_learn_13.mbg.mapper"})
public class MyBatisConfig {
}
