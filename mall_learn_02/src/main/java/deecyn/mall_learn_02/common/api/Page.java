package deecyn.mall_learn_02.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: PageHelper 分页 -- 数据封装类
 */
public class Page<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将 PageHelper 分页后的 list 转为分页信息
     * @param list 数据列表
     * @param <T> 数据类型
     * @return
     */
    public static <T> Page<T> restPage(List<T> list) {
        Page<T> result = new Page<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);

        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setList(list);
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
