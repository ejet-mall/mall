package com.macro.mall.portal.service;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.portal.domain.BuCoreCommentParam;
import com.macro.mall.portal.domain.BuCoreCommentResult;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 评论管理Service
 * Created by ejet on 2018/4/26.
 */
public interface BuCoreCommentService {
    /**
     * 创建评论
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(BuCoreCommentParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    BuCoreCommentResult getUpdateInfo(Long id);


    BuCoreCommentResult getItem(Long id);

    int delete(Long id);

    /**
     * 更新评论
     */
    @Transactional
    int update(Long id, BuCoreCommentParam productParam);

    /**
     * 分页查询商品
     */
    List<BuCoreCommentResult> list(BuCoreCommentParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);
}
