package com.macro.mall.portal.util;

import com.ejet.api.sms.alibaba.SmsFactory;
import com.ejet.api.sms.alibaba.SmsRequest;
import com.ejet.api.sms.alibaba.SmsResponse;
import com.macro.mall.model.SysParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SmsUtil {

    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    public static boolean sendRegister(String phone, String code) {
        Map<String,String> param = new HashMap<>();
        param.put("code", code);
        SmsRequest req = new SmsRequest();
        req.setPhone(phone);
        req.setSignName("北京艾科怀曼生物");
        req.setTemplateCode("SMS_172881750"); //注册模板
        req.setTemplateParam(param);
        SmsResponse response = SmsFactory.sendSms(req);
        return response!=null && "OK".equalsIgnoreCase(response.getCode());
    }

    public static boolean sendUpdatepassword(String phone, String code) {
        Map<String,String> param = new HashMap<>();
        param.put("code", code);
        SmsRequest req = new SmsRequest();
        req.setPhone(phone);
        req.setSignName("北京艾科怀曼生物");
        req.setTemplateCode("SMS_172881750"); //修改密码模板
        req.setTemplateParam(param);
        SmsResponse response = SmsFactory.sendSms(req);
        return response!=null && "OK".equalsIgnoreCase(response.getCode());
    }

    public static boolean sendOrder(SysParam sysParam, String fee, String orderId, String orderUser) {
        if(sysParam==null) return false;
        try {
            boolean isSend = "true".equalsIgnoreCase(sysParam.getParamValue());
            if(!isSend) {
                return false;
            }
            String phone = sysParam.getExt();
            Map<String,String> param = new HashMap<>();
            param.put("fee", fee);
            param.put("orderId", orderId);
            param.put("orderUser", orderUser);
            SmsRequest req = new SmsRequest();
            req.setPhone(phone);
            req.setSignName("北京艾科怀曼生物");
            req.setTemplateCode("SMS_174028711"); //短信通知模板
            req.setTemplateParam(param);
            SmsResponse response = SmsFactory.sendSms(req);
            logger.warn("发送短信结果:" + response.toString());
            return response!=null && "OK".equalsIgnoreCase(response.getCode());
        } catch (Exception e) {
            logger.error("", e);
        }
        return false;
    }


}
