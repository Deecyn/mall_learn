package deecyn.mall_learn_02.controller;

import deecyn.mall_learn_02.common.api.ResPage;
import deecyn.mall_learn_02.common.api.ResponseMsg;
import deecyn.mall_learn_02.mbg.model.PmsBrand;
import deecyn.mall_learn_02.service.PmsBrandService;
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
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * 查询所有品牌
     */
    @GetMapping("/listAll")
    public ResponseMsg<List<PmsBrand>> getPmsBrandList() {
        return ResponseMsg.success(brandService.listAllBrand());
    }

    /**
     * 添加品牌
     */
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

    /**
     * 删除品牌
     */
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

    /**
     * 分页查询品牌列表
     */
    @GetMapping("/list")
    public ResponseMsg<ResPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return ResponseMsg.success(ResPage.restPage(brandList));
    }

    /**
     * 根据 id 查询品牌信息
     */
    @GetMapping("/{id}")
    public ResponseMsg<PmsBrand> brand(@PathVariable("id") Integer id) {
        return ResponseMsg.success(brandService.getBrand(id));
    }
}
