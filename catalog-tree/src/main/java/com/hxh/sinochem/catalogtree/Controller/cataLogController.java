package com.hxh.sinochem.catalogtree.Controller;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
import com.hxh.sinochem.catalogtree.service.IcataLogService;
import com.hxh.sinochem.catalogtree.service.ValueObject.AllTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
//TODO: 另写查询方式，以list中放入map的形式返回给前端
        List<CatalogTree>list = icataLogService.listCataLogByParentId(pId);
//        for (CatalogTree catalogTree: list) {
//            if (icataLogService.ifExistSubCataLog(list,catalogTree.getParentId())){
//                return icataLogService.listCataLogByParentId(catalogTree.getTierId());
//            }
//        }
        return list;
    }
    @PostMapping("/listpage")
    public List<AllTree> ListAllCatalog(@RequestHeader("PID") Integer pId){
        return icataLogService.listCatalogMap(pId);
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
