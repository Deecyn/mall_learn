package deecyn.mall_learn_15.service;

import deecyn.mall_learn_15.mongodb.document.MemberReadHistory;
import deecyn.mall_learn_15.mongodb.repository.MemberReadHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 会员浏览记录管理 Service
 */
@Service
public class MemberReadHistoryService {

    private final MemberReadHistoryRepository memberReadHistoryRepository;

    @Autowired
    public MemberReadHistoryService(MemberReadHistoryRepository memberReadHistoryRepository) {
        this.memberReadHistoryRepository = memberReadHistoryRepository;
    }

    /**
     * 生成浏览记录
     */
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);

        return 1;
    }

    /**
     * 根据 id 批量删除浏览记录
     */
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>(ids.size());

        for (String id : ids) {
            MemberReadHistory history = new MemberReadHistory();
            history.setId(id);
            deleteList.add(history);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    /**
     * 获取用户的浏览历史记录
     */
    public List<MemberReadHistory> list(Integer memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }

}
