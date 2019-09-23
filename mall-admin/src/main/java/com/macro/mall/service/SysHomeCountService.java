package com.macro.mall.service;

import com.macro.mall.dto.SysHomeCountResult;
import com.macro.mall.model.CmsSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 统计Service
 */
public interface SysHomeCountService {

    /**
     * 首页商品和订单统计
     */
    SysHomeCountResult homeProductOrderCount();



}
