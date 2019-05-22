package com.hxh.sinochem.catalogtree.Controller;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
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


    @GetMapping("/query")
    public List<CatalogTree> ListCataLog(Integer pId){

        List<CatalogTree>list = icataLogService.listCataLogByParentId(pId);
        for (CatalogTree catalogTree: list) {
            if (icataLogService.ifExistSubCataLog(list,catalogTree.getParentId())){
                return icataLogService.listCataLogByParentId(catalogTree.getTierId());
            }
        }
        return null;
    }

    @GetMapping("/delete")
    public void deleteCataLog( Integer pId){
        icataLogService.deleteCataLog(pId);
    }

    @GetMapping("/add")
    public String addCataLog( Integer pId,
                              Integer tId,
                              String catalogName){
        int symbol = icataLogService.addCataLog(catalogName,pId,tId);
        if (symbol == 1){
            return "add success!";
        }
        return "add failed!";
    }
}
