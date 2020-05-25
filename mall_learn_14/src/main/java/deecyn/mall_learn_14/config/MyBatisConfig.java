package deecyn.mall_learn_14.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
@Configuration
@MapperScan({"deecyn.mall_learn_14.dao", "deecyn.mall_learn_14.mbg.mapper"})
public class MyBatisConfig {

}
