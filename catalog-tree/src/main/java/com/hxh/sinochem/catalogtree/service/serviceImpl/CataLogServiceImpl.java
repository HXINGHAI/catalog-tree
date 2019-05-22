package com.hxh.sinochem.catalogtree.service.serviceImpl;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
import com.hxh.sinochem.catalogtree.reporsitory.CataLogReporsity;
import com.hxh.sinochem.catalogtree.service.IcataLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/22 10:38
 * @Description:
 */
@Service
public class CataLogServiceImpl implements IcataLogService {

    @Autowired
    private CataLogReporsity cataLogReporsity;

    /**
     * @Author: H_xinghai on 2019/5/22 \
     * @param:
     * @return:
     * @Description:根据Id查询目录
     */
    @Override
    public List<CatalogTree> listCataLogByParentId(Integer pId) {
        List<CatalogTree> list =  cataLogReporsity.findAllByParentId(pId);
        return list;
    }
    /**
     * @Author: H_xinghai on 2019/5/22 10:58
     * @param:
     * @return:
     * @Description:判断是否存在子集目录
     */
    @Override
    public boolean ifExistSubCataLog(List<CatalogTree> list, Integer pId) {
        boolean symbol = false;
        for (CatalogTree catalogTree : list) {
            if (catalogTree.getParentId() == pId){
                symbol = true;
                break;
            }
        }
        return symbol;
    }
    /**
     * @Author: H_xinghai on 2019/5/22 10:59
     * @param:
     * @return:
     * @Description:根据当前所在的目录新增目录
     */
    @Override
    public int addCataLog(String catalogName,Integer pId,Integer tierId) {

        if (!StringUtils.isEmpty(catalogName)){
            if (pId == null && tierId == null){
                cataLogReporsity.insertCatalog(catalogName,0,1);
                return 1;
            }else{
                CatalogTree result = cataLogReporsity.findAllByParentIdAndTierId(pId,tierId); //先获取当前父目录的信息
                cataLogReporsity.insertCatalog(catalogName,tierId,result.getLevel()+1);//在父级目录下要添加的子目录
                return 1;
            }
        }
        return 0;
    }

    /**
     * @Author: H_xinghai on 2019/5/22 11:21
     * @param:
     * @return:
     * @Description:根据目录Id删除目录
     */
    @Override
    public void deleteCataLog(Integer pId) {
        //判断该目录下是否有子目录
        List<CatalogTree> list = cataLogReporsity.findAllByParentId(pId);
        if (list.size() == 0){
            cataLogReporsity.deleteCataLogByParentId(pId);
        }else{//如果有子目录，继续判断删除
            for (CatalogTree catalogTree:list) {
                if (catalogTree.getParentId() == pId){
                    this.deleteCataLog(catalogTree.getParentId());
                }else {
                    continue;
                }
            }
        }
    }
}
