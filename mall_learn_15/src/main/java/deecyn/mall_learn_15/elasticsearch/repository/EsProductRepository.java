package deecyn.mall_learn_15.elasticsearch.repository;

import deecyn.mall_learn_15.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 商品的 ES 操作类，继承的 ElasticsearchRepository 接口默认定义了一些基本的数据操作方法
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Integer> {

    /**
     * 商品信息的搜索查询接口
     *
     * @param name 商品名称
     * @param subTitle 商品标题
     * @param keywords 关键字
     * @param pageable 分页信息
     * @return 商品的 ES 文档对象，这里为何要用 Spring 框架中的 Page 接口？
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable pageable);
}
