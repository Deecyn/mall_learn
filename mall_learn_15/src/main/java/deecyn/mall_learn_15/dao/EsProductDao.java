package deecyn.mall_learn_15.dao;

import deecyn.mall_learn_15.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 搜索系统中的商品管理自定义 Dao
 */
public interface EsProductDao {

    /**
     * 根据 id 查询商品信息；当 id 为 null 时，返回所有商品信息
     */
    List<EsProduct> getAllEsProductList(@Param("id") Integer id);

}
