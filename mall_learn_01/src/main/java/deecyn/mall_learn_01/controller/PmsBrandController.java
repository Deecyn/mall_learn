package deecyn.mall_learn_01.controller;

import deecyn.mall_learn_01.common.Page;
import deecyn.mall_learn_01.common.ResponseMsg;
import deecyn.mall_learn_01.model.PO.PmsBrand;
import deecyn.mall_learn_01.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 商品的品牌管理
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    private static  final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @GetMapping(value = "/listAll")
    public ResponseMsg<List<PmsBrand>> getPmsBrandList(){
        return ResponseMsg.success(brandService.listAllBrand());
    }

    /**
     * 添加品牌
     * @param pmsBrand
     * @return
     */
    @PostMapping("/create")
    public ResponseMsg createBrand(@RequestBody PmsBrand pmsBrand){
        ResponseMsg responseMsg;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1){
            responseMsg = ResponseMsg.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        }else {
            responseMsg = ResponseMsg.failed("操作失败");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return responseMsg;
    }

    /**
     * 更新品牌信息
     * @param id
     * @param pmsBrandDto
     * @param result
     * @return
     */
    @PostMapping(value = "/update/{id}")
    public ResponseMsg updateBrand(@PathVariable("id") Integer id, @RequestBody PmsBrand pmsBrandDto,
                                   BindingResult result) {
        ResponseMsg responseMsg;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            responseMsg = ResponseMsg.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            responseMsg = ResponseMsg.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return responseMsg;
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseMsg deleteBrand(@PathVariable("id") Integer id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return ResponseMsg.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return ResponseMsg.failed("操作失败");
        }
    }

    /**
     * 分页查询品牌列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/list")
    public ResponseMsg<Page<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return ResponseMsg.success(Page.restPage(brandList,pageNum,pageSize));
    }

    /**
     * 根据id查询品牌信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseMsg<PmsBrand> brand(@PathVariable("id")Integer id) {
        return ResponseMsg.success(brandService.getPmsBrand(id));
    }
}
