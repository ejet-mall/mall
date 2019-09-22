package com.macro.mall.service;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.CmsSubjectCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品专题Service
 * Created by macro on 2018/6/1.
 */
public interface CmsSubjectService {

    @Transactional
    int create(CmsSubject categoryParam);

    @Transactional
    int update(Long id, CmsSubject categoryParam);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    int delete(Long id);

    CmsSubject getItem(Long id);


    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);



}
