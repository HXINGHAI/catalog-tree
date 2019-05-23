package com.hxh.sinochem.catalogtree.service;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
import com.hxh.sinochem.catalogtree.service.ValueObject.AllTree;

import java.util.List;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/22 10:14
 * @Description:
 */

public interface IcataLogService {
    /**
     * @Author: H_xinghai on 2019/5/22 10:27
     * @param:
     * @return:
     * @Description:根据Id查询目录
     */
    List<CatalogTree> listCataLogByParentId(Integer pId);

    List<AllTree> listCatalogMap(Integer tId);
    /**
     * @Author: H_xinghai on 2019/5/22 10:31
     * @param:
     * @return:
     * @Description:判断该目录下是否还有子目录
     */
    boolean ifExistSubCataLog(List<CatalogTree> list,Integer pId);

    /**
     * @Author: H_xinghai on 2019/5/22 10:34
     * @param:
     * @return:
     * @Description:增加目录
     */
    int addCataLog(String catalogName,Integer pId,Integer tireId);

    /**
     * @Author: H_xinghai on 2019/5/22 10:36
     * @param:
     * @return:
     * @Description:删除目录
     */
    void deleteCataLog(Integer pId);
}
