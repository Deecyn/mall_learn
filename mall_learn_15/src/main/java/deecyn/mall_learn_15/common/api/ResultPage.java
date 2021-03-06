package deecyn.mall_learn_15.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 对响应的数据进行分页封装
 */
public class ResultPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将 PageHelper 分页后的 list 转为分页信息
     */
    public static <T> ResultPage<T> restPage(List<T> sourceList) {
        ResultPage<T> resultPage = new ResultPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(sourceList);
        resultPage.setPageNum(pageInfo.getPageNum());
        resultPage.setPageSize(pageInfo.getPageSize());
        resultPage.setTotal(pageInfo.getTotal());
        resultPage.setTotalPage(pageInfo.getPages());
        resultPage.setList(pageInfo.getList());

        return resultPage;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> ResultPage<T> restPage(Page<T> pageInfo) {
        ResultPage<T> result = new ResultPage<>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
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
