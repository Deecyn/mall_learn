package deecyn.mall_learn_15.controller;

import deecyn.mall_learn_15.common.api.ResponseMsg;
import deecyn.mall_learn_15.common.api.ResultPage;
import deecyn.mall_learn_15.elasticsearch.document.EsProduct;
import deecyn.mall_learn_15.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 搜索商品管理 Controller
 */
@RestController
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {
    private final EsProductService esProductService;

    @Autowired
    public EsProductController(EsProductService esProductService) {
        this.esProductService = esProductService;
    }

    @ApiOperation("从数据库导入所有商品的信息到 ES 中")
    @PostMapping("/importAll")
    public ResponseMsg<Integer> importAllList() {
        int count = esProductService.importAll();
        return ResponseMsg.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @PostMapping("/delete/{id}")
    public ResponseMsg<Object> delete(@PathVariable Integer id) {
        esProductService.delete(id);
        return ResponseMsg.success(null);
    }

    @ApiOperation(value = "根据多个id批量删除商品")
    @PostMapping("/delete/batch")
    public ResponseMsg<Object> delete(@RequestParam("ids") List<Integer> ids) {
        esProductService.delete(ids);
        return ResponseMsg.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping("/create/{id}")
    public ResponseMsg<EsProduct> create(@PathVariable Integer id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return ResponseMsg.success(esProduct);
        } else {
            return ResponseMsg.failed("创建失败");
        }
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping(value = "/search/simple")
    public ResponseMsg<ResultPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                     @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                     @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return ResponseMsg.success(ResultPage.restPage(esProductPage));
    }


}
