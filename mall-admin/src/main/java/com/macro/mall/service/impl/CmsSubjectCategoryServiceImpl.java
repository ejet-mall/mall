package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.constant.CommConstant;
import com.macro.mall.dao.PmsProductCategoryAttributeRelationDao;
import com.macro.mall.dao.PmsProductCategoryDao;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.dto.PmsProductCategoryWithChildrenTree;
import com.macro.mall.mapper.CmsSubjectCategoryMapper;
import com.macro.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.model.*;
import com.macro.mall.service.CmsSubjectCategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PmsProductCategoryService实现类
 */
@Service
public class CmsSubjectCategoryServiceImpl implements CmsSubjectCategoryService {
    @Autowired
    private CmsSubjectCategoryMapper categoryMapper;

    @Override
    public int create(CmsSubjectCategory subjectCategoryParam) {
        subjectCategoryParam.setSubjectCount(subjectCategoryParam.getSubjectCount()==null ? 0 :subjectCategoryParam.getSubjectCount());
        int count = categoryMapper.insertSelective(subjectCategoryParam);
        return count;
    }

    @Override
    public int update(Long id, CmsSubjectCategory subjectCategoryParam) {
        subjectCategoryParam.setId(id);
        return categoryMapper.updateByPrimaryKeySelective(subjectCategoryParam);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        CmsSubjectCategory productCategory = new CmsSubjectCategory();
        productCategory.setShowStatus(showStatus);
        CmsSubjectCategoryExample example = new CmsSubjectCategoryExample();
        example.createCriteria().andIdIn(ids);
        return categoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public List<CmsSubjectCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectCategoryExample example = new CmsSubjectCategoryExample();
        //example.createCriteria().andShowStatusEqualTo(CommConstant.SHOW_STATUS_ON);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CmsSubjectCategory getItem(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

}
