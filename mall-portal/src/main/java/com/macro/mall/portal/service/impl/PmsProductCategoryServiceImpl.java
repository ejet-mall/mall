package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.dto.PmsProductCategoryWithChildrenTree;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.model.*;
import com.macro.mall.dao.PmsProductCategoryDao;
import com.macro.mall.portal.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsProductCategoryService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    @Override
    public List<PmsProductCategoryWithChildrenTree> listWithTree() {
        List<PmsProductCategoryWithChildrenTree> resultList = productCategoryDao.listWithArray();
        PmsProductCategoryWithChildrenTree root = new PmsProductCategoryWithChildrenTree();
        root.setId(0L);
        PmsProductCategoryWithChildrenTree tree = toTree(resultList, root);
        return tree.getChildren();
    }

    @Override
    public List<PmsProductCategoryWithChildrenTree> listWithArray() {
        return productCategoryDao.listWithArray();
    }


    public static PmsProductCategoryWithChildrenTree toTree(List<PmsProductCategoryWithChildrenTree> all, PmsProductCategoryWithChildrenTree rootNode) {
        boolean allAppend = false;
        for(PmsProductCategoryWithChildrenTree item : all) {
            boolean temp = appendChild(rootNode, item);
            allAppend = temp && allAppend;
        }
        return rootNode;
    }

    public static <T> boolean appendChild(PmsProductCategoryWithChildrenTree treeNode, PmsProductCategoryWithChildrenTree currentNode) {
        boolean appended = false;
        Object value = treeNode.getId();
        Object pidValue = currentNode.getParentId();
        if( Integer.valueOf(String.valueOf(value)).intValue() ==
                Integer.valueOf(String.valueOf(pidValue)).intValue() ) { //
            treeNode.getChildren().add(currentNode);
            return true;
        } else if( treeNode.getChildren()!=null ) {
            for(PmsProductCategoryWithChildrenTree  item : treeNode.getChildren()) {
                if( appendChild(item, currentNode) ) {
                    appended = true;
                    break;
                }
            }
        }
        return appended;
    }


}
