package deecyn.mall_learn_15.service;

import com.github.pagehelper.PageHelper;
import deecyn.mall_learn_15.mbg.mapper.PmsBrandMapper;
import deecyn.mall_learn_15.mbg.model.PmsBrand;
import deecyn.mall_learn_15.mbg.model.PmsBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 商品品牌管理 Service
 */
@Service
public class PmsBrandService {

    private final PmsBrandMapper brandMapper;

    @Autowired
    public PmsBrandService(PmsBrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    public int createBrand(PmsBrand pmsBrand) {
        return brandMapper.insertSelective(pmsBrand);
    }

    public int updateBrand(Integer id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    public int deleteBrand(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    public PmsBrand getBrand(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
