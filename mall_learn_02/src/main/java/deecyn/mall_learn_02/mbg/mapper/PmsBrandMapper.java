package deecyn.mall_learn_02.mbg.mapper;

import deecyn.mall_learn_02.mbg.model.PmsBrand;

public interface PmsBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}