package com.macro.mall.portal.service.impl;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.BuCoreCommentParam;
import com.macro.mall.portal.domain.BuCoreCommentResult;
import com.macro.mall.portal.service.BuCoreCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuCoreCommentServiceImpl implements BuCoreCommentService {
    @Override
    public int create(BuCoreCommentParam productParam) {
        return 0;
    }

    @Override
    public BuCoreCommentResult getUpdateInfo(Long id) {
        return null;
    }

    @Override
    public BuCoreCommentResult getItem(Long id) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Long id, BuCoreCommentParam productParam) {
        return 0;
    }

    @Override
    public List<BuCoreCommentResult> list(BuCoreCommentParam queryParam, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return 0;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return 0;
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return 0;
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return 0;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return 0;
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        return null;
    }
}
