package deecyn.mall_learn_01.dao;

import deecyn.mall_learn_01.model.PO.PmsBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/4 19:59.
 */
@Mapper
public interface PmsBrandMapper {

    /**
     * 查询所有品牌信息的列表
     * @return
     */
    List<PmsBrand> selectAll();

    /**
     * 分页查询所有品牌信息的列表
     * @param startIndex 从第几条数据开始
     * @param endIndex 到第几条数据结束
     * @return
     */
    List<PmsBrand> selectAllPage(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     * 插入品牌
     * @param pmsBrand
     * @return
     */
    int insert(PmsBrand pmsBrand);

    /**
     * 更新品牌信息
     * @param id
     * @param brand
     * @return
     */
    int updatePmsBrand(@Param("id") Integer id,@Param("brand") PmsBrand brand);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    int deletePmsBrand(@Param("id") Integer id);

    /**
     * 根据 id 查询品牌信息
     * @param id
     * @return
     */
    PmsBrand selectById(@Param("id") Integer id);

}
