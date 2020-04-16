package deecyn.mall_learn_13.service;

import deecyn.mall_learn_13.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Integer id, PmsBrand pmsBrand);

    int deleteBrand(Integer id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Integer id);

}
