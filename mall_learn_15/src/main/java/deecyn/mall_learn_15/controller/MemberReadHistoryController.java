package deecyn.mall_learn_15.controller;

import deecyn.mall_learn_15.common.api.ResponseMsg;
import deecyn.mall_learn_15.mongodb.document.MemberReadHistory;
import deecyn.mall_learn_15.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 会员商品浏览记录管理 Controller
 */
@RestController
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    private final MemberReadHistoryService memberReadHistoryService;

    @Autowired
    public MemberReadHistoryController(MemberReadHistoryService memberReadHistoryService) {
        this.memberReadHistoryService = memberReadHistoryService;
    }

    @ApiOperation("创建浏览记录")
    @PostMapping("/create")
    public ResponseMsg<Object> create(@RequestBody MemberReadHistory memberReadHistory) {
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0) {
            return ResponseMsg.success(count);
        } else {
            return ResponseMsg.failed("创建失败");
        }
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    public ResponseMsg<Object> delete(@RequestParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) {
            return ResponseMsg.success(count);
        } else {
            return ResponseMsg.failed("删除失败");
        }
    }

    @ApiOperation("展示浏览记录")
    @GetMapping("/list")
    public ResponseMsg<List<MemberReadHistory>> list(Integer memberId) {
        List<MemberReadHistory> historyList = memberReadHistoryService.list(memberId);
        return ResponseMsg.success(historyList);
    }
}
