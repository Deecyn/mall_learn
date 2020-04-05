package deecyn.mall_learn_01.service.impl;

import deecyn.mall_learn_01.dao.PmsBrandMapper;
import deecyn.mall_learn_01.model.PO.PmsBrand;
import deecyn.mall_learn_01.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/4 21:57.
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectAll();
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int updateBrand(Integer id, PmsBrand brand) {
        return pmsBrandMapper.updatePmsBrand(id, brand);
    }

    @Override
    public int deleteBrand(Integer id) {
        return pmsBrandMapper.deletePmsBrand(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = pageNum * pageSize;
        return pmsBrandMapper.selectAllPage(startIndex,endIndex);
    }

    @Override
    public PmsBrand getPmsBrand(Integer id) {
        return pmsBrandMapper.selectById(id);
    }
}
