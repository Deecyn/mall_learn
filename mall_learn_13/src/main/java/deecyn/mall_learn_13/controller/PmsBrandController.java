package deecyn.mall_learn_13.controller;

import deecyn.mall_learn_13.common.api.ResponseMsg;
import deecyn.mall_learn_13.common.api.ResultPage;
import deecyn.mall_learn_13.mbg.model.PmsBrand;
import deecyn.mall_learn_13.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Api(tags = "PmsBrandController", value = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Resource
    private PmsBrandService pmsBrandService;

    private static Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("查询所有品牌")
    @GetMapping("/listAll")
    public ResponseMsg<List<PmsBrand>> getPmsBrandList() {
        return ResponseMsg.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @PostMapping("/create")
    public ResponseMsg<PmsBrand> createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            LOGGER.debug("create PmsBrand success:{}", pmsBrand);
            return ResponseMsg.success(pmsBrand);
        } else {
            LOGGER.warn("create PmsBrand failed:{}", pmsBrand);
            return ResponseMsg.failed("服务器错误");
        }
    }

    @ApiOperation("更新品牌信息")
    @PostMapping("/update/{id}")
    public ResponseMsg<PmsBrand> updateBrand(@PathVariable Integer id, @RequestBody PmsBrand pmsBrand,
                                             BindResult bindResult) {
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            LOGGER.debug("update PmsBrand success:{}", pmsBrand);
            return ResponseMsg.success(pmsBrand);
        } else {
            LOGGER.warn("update PmsBrand failed:{}", pmsBrand);
            return ResponseMsg.failed("服务器错误");
        }
    }

    @ApiOperation("删除品牌")
    @PostMapping("/delete/{id}")
    public ResponseMsg<Integer> deleteBrand(@PathVariable("id") Integer id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("delete PmsBrand success, id={}", id);
            return ResponseMsg.success(id);
        } else {
            LOGGER.warn("delete PmsBrand failed, id={}", id);
            return ResponseMsg.failed("服务器错误");
        }
    }

    @ApiOperation("根据 id 查询品牌信息")
    @GetMapping("/{id}")
    public ResponseMsg<PmsBrand> getBrand(@PathVariable("id") Integer id) {
         return ResponseMsg.success(pmsBrandService.getBrand(id));
    }

    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    public ResponseMsg<ResultPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsBrand> pmsBrandList = pmsBrandService.listBrand(pageNum, pageSize);
        return ResponseMsg.success(ResultPage.restPage(pmsBrandList));
    }
}
