package deecyn.mall_learn_13.service.impl;

import com.github.pagehelper.PageHelper;
import deecyn.mall_learn_13.mbg.mapper.PmsBrandMapper;
import deecyn.mall_learn_13.mbg.model.PmsBrand;
import deecyn.mall_learn_13.mbg.model.PmsBrandExample;
import deecyn.mall_learn_13.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Integer id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
