package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.constant.CommConstant;
import com.macro.mall.mapper.CmsSubjectMapper;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.CmsSubjectCategory;
import com.macro.mall.model.CmsSubjectCategoryExample;
import com.macro.mall.model.CmsSubjectExample;
import com.macro.mall.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品专题Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public int create(CmsSubject subjectParam) {
        subjectParam.setShowStatus(subjectParam.getShowStatus()==null ? CommConstant.SHOW_STATUS_ON :subjectParam.getShowStatus());
        subjectParam.setRecommendStatus(subjectParam.getRecommendStatus()==null ? CommConstant.RECOMMAND_STATUS_ON :subjectParam.getRecommendStatus());
        int count = subjectMapper.insertSelective(subjectParam);
        return count;
    }

    @Override
    public int update(Long id, CmsSubject subjectParam) {
        subjectParam.setId(id);
        return subjectMapper.updateByPrimaryKeySelective(subjectParam);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        CmsSubject subject = new CmsSubject();
        subject.setShowStatus(showStatus);
        CmsSubjectExample example = new CmsSubjectExample();
        example.createCriteria().andIdIn(ids);
        return subjectMapper.updateByExampleSelective(subject, example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommentStatus) {
        CmsSubject subject = new CmsSubject();
        subject.setRecommendStatus(recommentStatus);
        CmsSubjectExample example = new CmsSubjectExample();
        example.createCriteria().andIdIn(ids);
        return subjectMapper.updateByExampleSelective(subject, example);
    }

    @Override
    public int delete(Long id) {
        return subjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CmsSubject getItem(Long id) {
        return subjectMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }
}
