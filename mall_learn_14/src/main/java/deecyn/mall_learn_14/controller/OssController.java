package deecyn.mall_learn_14.controller;

import deecyn.mall_learn_14.common.api.ResponseMsg;
import deecyn.mall_learn_14.dto.OssCallbackResult;
import deecyn.mall_learn_14.dto.OssPolicyResult;
import deecyn.mall_learn_14.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Deecyn
 * @version 0.14
 * Description: Oss 相关操作接口
 */
@Controller
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return ResponseMsg.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg<OssCallbackResult> callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return ResponseMsg.success(ossCallbackResult);
    }

}
