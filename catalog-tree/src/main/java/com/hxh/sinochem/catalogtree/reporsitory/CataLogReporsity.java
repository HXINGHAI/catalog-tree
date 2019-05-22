package com.hxh.sinochem.catalogtree.reporsitory;

import com.hxh.sinochem.catalogtree.entity.CatalogTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/22 10:24
 * @Description:
 */

public interface CataLogReporsity extends JpaRepository<CatalogTree,Integer> {

    /**
    * @Author: H_xinghai on 2019/5/22 14:54
    * @param:
    * @return:
    * @Description:查询实体类（根据parentId和level级别）
    */
    @Query(nativeQuery = true,value = "select * from catalog_tree where parent_id = ?1 and tier_id = ?2")
    CatalogTree findAllByParentIdAndTierId(Integer pId,Integer tierId);
    /**
     * @Author: H_xinghai on 2019/5/22 13:22
     * @param:
     * @return:
     * @Description:根据父级Id查询目录
     */

    @Query(nativeQuery = true,value = "select * from catalog_tree where parent_id =(:pid)")
    List<CatalogTree> findAllByParentId(@Param("pid") Integer pId);

    /**
     * @Author: H_xinghai on 2019/5/22 13:23
     * @param:
     * @return:
     * @Description:新增目录
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "insert into catalog_tree(catalog_name,parent_id,level) values(?1,?2,?3)")
    int insertCatalog(String cataLogName,Integer parentId,Integer level);

    /**
     * @Author: H_xinghai on 2019/5/22 13:23
     * @param:
     * @return:
     * @Description:删除目录
     */
    @Query(nativeQuery = true,value = "delete from catalog_tree where parent_id = ?")
    void deleteCataLogByParentId(Integer pId);
}
