package com.macro.mall.portal.service;

import com.ejet.core.kernel.exception.CoBusinessException;
import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartProduct;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车管理Service
 * Created by macro on 2018/8/2.
 */
public interface OmsCartItemService {
    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     */
    @Transactional(rollbackFor = {Throwable.class, Exception.class, RuntimeException.class}, timeout = 60000)
    int add(OmsCartItem cartItem) ;

    /**
     * 根据会员编号获取购物车列表
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * 获取包含促销活动信息的购物车列表
     */
    List<CartPromotionItem> listPromotion(Long memberId);

    /**
     * 获取包含促销活动信息的购物车列表
     */
    List<CartPromotionItem> listCustomPromotion(Long memberId, OrderParam orderParam);

    /**
     * 修改某个购物车商品的数量
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * 批量修改购物车中的商品
     */
    int updateBatch(Long memberId,List<Long> ids);

    /**
     * 批量修改购物车中的商品
     */
    int deleteBatch(Long memberId,List<Long> ids);

    /**
     *获取购物车中用于选择商品规格的商品信息
     */
    CartProduct getCartProduct(Long productId);

    /**
     * 修改购物车中商品的规格
     */
    @Transactional(rollbackFor = {Throwable.class, Exception.class, RuntimeException.class}, timeout = 60000)
    int updateAttr(OmsCartItem cartItem) ;

    /**
     * 清空购物车
     */
    int clear(Long memberId);
}
