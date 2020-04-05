package deecyn.mall_learn_01.service;

import deecyn.mall_learn_01.model.PO.PmsBrand;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/4 20:41.
 */
public interface PmsBrandService {
    /**
     * 查询所有品牌的列表
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 插入，添加品牌
     * @param pmsBrand 品牌对象
     * @return
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 更新品牌信息
     * @param id
     * @param brand
     * @return
     */
    int updateBrand(Integer id,PmsBrand brand);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    int deleteBrand(Integer id);

    /**
     * 分页查询品牌列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(int pageNum,int pageSize);

    /**
     * 根据 id 查询品牌信息
     * @param id
     * @return
     */
    PmsBrand getPmsBrand(Integer id);
}
