package deecyn.mall_learn_02.controller;

import deecyn.mall_learn_02.common.api.ResPage;
import deecyn.mall_learn_02.common.api.ResponseMsg;
import deecyn.mall_learn_02.mbg.model.PmsBrand;
import deecyn.mall_learn_02.service.PmsBrandService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /** 查询所有品牌 */
    @ApiOperation("查询所有品牌")
    @GetMapping("/listAll")
    public ResponseMsg<List<PmsBrand>> getPmsBrandList() {
        return ResponseMsg.success(brandService.listAllBrand());
    }

    /** 添加品牌 */
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    public ResponseMsg<PmsBrand> createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            LOGGER.debug("createBrand success:{}", pmsBrand);
            return ResponseMsg.success(pmsBrand);
        } else {
            LOGGER.warn("createBrand failed:{}", pmsBrand);
            return ResponseMsg.failed("服务器错误");
        }
    }

    /**
     * 更新品牌信息
     */
    @ApiOperation("更新品牌信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新品牌信息操作成功", response = PmsBrand.class),
            @ApiResponse(code = 500, message = "操作失败，服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "品牌的 id", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "body", name = "pmsBrand", value = "品牌对象", dataType = "PmsBrand.class", required = true)
    })
    @PostMapping("/update/{id}")
    public ResponseMsg<PmsBrand> updateBrand(@PathVariable("id") Integer id, @RequestBody PmsBrand pmsBrand,
                                             BindingResult result) {
        int count = brandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            LOGGER.debug("updateBrand success:{}", pmsBrand);
            return ResponseMsg.success(pmsBrand);
        } else {
            LOGGER.warn("updateBrand failed:{}", pmsBrand);
            return ResponseMsg.failed("服务器错误");
        }
    }

    /** 删除品牌 */
    @ApiOperation("删除品牌")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除品牌操作成功", response = PmsBrand.class),
            @ApiResponse(code = 500, message = "操作失败，服务器错误")
    })
    @ApiImplicitParam(paramType = "path", name = "id", value = "品牌的 id", dataType = "int", required = true)
    @PostMapping("/delete/{id}")
    public ResponseMsg<Object> deleteBrand(@PathVariable("id") Integer id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return ResponseMsg.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return ResponseMsg.failed("服务器错误");
        }
    }

    /** 分页查询品牌列表 */
    @ApiOperation("分页查询品牌列表")
    @ApiResponse(code = 200, message = "分页查询成功", response = ResPage.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页的编号，第几页", dataType = "int",
                    required = false, defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示多少条数据", dataType = "int",
                    required = false, defaultValue = "5")
    })
    @GetMapping("/list")
    public ResponseMsg<ResPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return ResponseMsg.success(ResPage.restPage(brandList));
    }

    /** 根据 id 查询品牌信息 */
    @ApiOperation("根据 id 查询品牌信息")
    @GetMapping("/{id}")
    public ResponseMsg<PmsBrand> brand(@PathVariable("id") Integer id) {
        return ResponseMsg.success(brandService.getBrand(id));
    }
}
