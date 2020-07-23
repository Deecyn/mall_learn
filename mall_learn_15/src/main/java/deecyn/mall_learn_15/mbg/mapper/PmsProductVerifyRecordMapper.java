package deecyn.mall_learn_15.mbg.mapper;

import deecyn.mall_learn_15.mbg.model.PmsProductVerifyRecord;
import deecyn.mall_learn_15.mbg.model.PmsProductVerifyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductVerifyRecordMapper {
    long countByExample(PmsProductVerifyRecordExample example);

    int deleteByExample(PmsProductVerifyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsProductVerifyRecord record);

    int insertSelective(PmsProductVerifyRecord record);

    List<PmsProductVerifyRecord> selectByExample(PmsProductVerifyRecordExample example);

    PmsProductVerifyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsProductVerifyRecord record, @Param("example") PmsProductVerifyRecordExample example);

    int updateByExample(@Param("record") PmsProductVerifyRecord record, @Param("example") PmsProductVerifyRecordExample example);

    int updateByPrimaryKeySelective(PmsProductVerifyRecord record);

    int updateByPrimaryKey(PmsProductVerifyRecord record);
}