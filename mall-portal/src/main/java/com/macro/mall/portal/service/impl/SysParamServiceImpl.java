package com.macro.mall.portal.service.impl;


import com.macro.mall.mapper.SysParamMapper;
import com.macro.mall.model.SysParam;
import com.macro.mall.model.SysParamExample;
import com.macro.mall.portal.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private SysParamMapper sysParamMapper;

    private final String  smsOnOrder = "sms_on_order";
    private final String  smsOnRegister = "sms_on_register";
    private final String  smsOnUpdateUser = "sms_on_update_user";

    @Override
    public SysParam getParamByKey(final String key) {
        SysParamExample example = new SysParamExample();
        example.createCriteria().andParamKeyEqualTo(key);
        List<SysParam> result = sysParamMapper.selectByExample(example);
        if(result!=null && result.size()>0) {
            return result.get(0);
        }
        return null;
    }


    @Override
    public SysParam getOnOrdered() {
        return getParamByKey(smsOnOrder);
    }

    @Override
    public boolean sendSmsOnRegister() {
        SysParam result = getParamByKey(smsOnRegister);
        return result!=null && "true".equalsIgnoreCase(result.getParamValue());
    }

    @Override
    public boolean sendSmsOnUpdatePassword() {
        SysParam result = getParamByKey(smsOnUpdateUser);
        return result!=null && "true".equalsIgnoreCase(result.getParamValue());
    }



}



