package com.hxh.sinochem.catalogtree.Controller;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
import com.hxh.sinochem.catalogtree.https.enums.ResultEnums;
import com.hxh.sinochem.catalogtree.https.httpResponse;
import com.hxh.sinochem.catalogtree.service.IcataLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/22 10:13
 * @Description:
 */
@RestController
@RequestMapping("/catalog")
public class cataLogController {

    @Autowired
    private IcataLogService icataLogService;

    //异步加载（适合层次结构多的情况）
    @GetMapping("/query")
    public httpResponse<List<CatalogTree>> ListCataLog(Integer pId){
        List<CatalogTree>list = icataLogService.listCataLogByParentId(pId);
        return httpResponse.success(list);
    }

    //同步加载（适合级别层次少的情况）
    @PostMapping("/listpage")
    public httpResponse<List<CatalogTree>> ListAllCatalog(@RequestHeader("TID") Integer tId){
        List<CatalogTree> list = icataLogService.listCatalogMap(tId);
        return httpResponse.success(list);
    }

    @GetMapping("/delete")
    public httpResponse deleteCataLog( Integer pId){
        icataLogService.deleteCataLog(pId);
        return httpResponse.success();
    }

    @GetMapping("/add")
    public httpResponse addCataLog( Integer pId,
                                    Integer tId,
                                    String catalogName){
        int symbol = icataLogService.addCataLog(catalogName,pId,tId);
        if (symbol == 1){
            return httpResponse.success();
        }
        return httpResponse.error(ResultEnums.PARAMS_ERROR.getCode(),ResultEnums.PARAMS_ERROR.getMsg());
    }
}
