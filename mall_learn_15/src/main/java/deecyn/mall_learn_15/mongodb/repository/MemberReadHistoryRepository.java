package deecyn.mall_learn_15.mongodb.repository;

import deecyn.mall_learn_15.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 会员商品浏览历史 Repository
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    /**
     * 根据会员 id 按时间倒序获取浏览记录
     * @param memberId 会员 id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Integer memberId);

}
