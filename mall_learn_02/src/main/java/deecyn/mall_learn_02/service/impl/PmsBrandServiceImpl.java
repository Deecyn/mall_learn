package deecyn.mall_learn_02.service.impl;

import com.github.pagehelper.PageHelper;
import deecyn.mall_learn_02.mbg.mapper.PmsBrandMapper;
import deecyn.mall_learn_02.mbg.model.PmsBrand;
import deecyn.mall_learn_02.mbg.model.PmsBrandExample;
import deecyn.mall_learn_02.service.PmsBrandService;
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
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Integer id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Integer id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Integer id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
