package deecyn.mall_learn_15.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
@Configuration
@MapperScan({"deecyn.mall_learn_15.dao", "deecyn.mall_learn_15.mbg.mapper"})
public class MyBatisConfig {

}
