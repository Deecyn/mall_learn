package deecyn.mall_learn_14.service;

import deecyn.mall_learn_14.mbg.model.PmsBrand;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
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

