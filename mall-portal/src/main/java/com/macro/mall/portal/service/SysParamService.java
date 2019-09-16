package com.macro.mall.portal.service;


import com.macro.mall.model.SysParam;

/**
 * 获取系统参数接口
 */
public interface SysParamService {

    SysParam getParamByKey(final String key);

    /** 订单完成后，是否发送短信 */
    SysParam getOnOrdered();

    /**  注册，是否发送短信 */
    boolean sendSmsOnRegister();

    /**  修改密码，是否发送短信 */
    boolean sendSmsOnUpdatePassword();

}
