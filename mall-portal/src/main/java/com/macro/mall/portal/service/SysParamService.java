package com.macro.mall.portal.service;


/**
 * 获取系统参数接口
 */
public interface SysParamService {

    /** 订单完成后，是否发送短信 */
    public boolean sendSmsOnOrdered();

    /**  注册，是否发送短信 */
    public boolean sendSmsOnRegister();

    /**  修改密码，是否发送短信 */
    public boolean sendSmsOnUpdatePassword();

}
