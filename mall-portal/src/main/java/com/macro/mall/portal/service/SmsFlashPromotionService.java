package com.macro.mall.portal.service;

import com.macro.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * 限时购活动管理Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionService {
    /**
     * 获取详细信息
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * 分页查询活动
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);
}
