package deecyn.mall_learn_15.service;

import deecyn.mall_learn_15.dao.EsProductDao;
import deecyn.mall_learn_15.elasticsearch.document.EsProduct;
import deecyn.mall_learn_15.elasticsearch.repository.EsProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 商品 ES 搜索管理 Service
 */
@Service
public class EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductService.class);

    private final EsProductDao esProductDao;
    private final EsProductRepository esProductRepository;

    @Autowired
    public EsProductService(EsProductDao esProductDao, EsProductRepository esProductRepository) {
        this.esProductDao = esProductDao;
        this.esProductRepository = esProductRepository;
    }

    /**
     * 从数据库导入所有商品的信息到 ES 中
     * @return 商品信息的数量
     */
    public int importAll(){
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(null);
        Iterator<EsProduct> iterator = esProductRepository.saveAll(esProductList).iterator();
        int countResult = 0;
        while (iterator.hasNext()) {
            countResult++;
            iterator.next();
        }
        return countResult;
    }

    /**  根据 id 删除商品  */
    public void delete(Integer id){
        esProductRepository.deleteById(id);
    }

    /** 根据多个 id 批量删除商品 */
    public void delete(List<Integer> ids){
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>(ids.size());
            for (Integer id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            // ？为何要先生成一个 List 对象，再删除这个 List ？
            esProductRepository.deleteAll(esProductList);
        }
    }

    /** 根据 id 创建商品 */
    public EsProduct create(Integer id) {
        EsProduct result = null;
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = esProductRepository.save(esProduct);
        }
        return result;
    }

    /**
     * 根据关键字搜索名称或标题
     */
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        // 这里的关键字，可以是商品名称，也可以是商品的标题
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }


}
