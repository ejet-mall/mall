package com.macro.mall.portal.service.impl;


import com.macro.mall.mapper.SysParamMapper;
import com.macro.mall.model.SysParamExample;
import com.macro.mall.portal.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private SysParamMapper sysParamMapper;

    @Override
    public boolean sendSmsOnOrdered() {

        SysParamExample example = new SysParamExample();
        example.createCriteria().andParamKeyEqualTo("");


        return false;
    }

    @Override
    public boolean sendSmsOnRegister() {
        return false;
    }

    @Override
    public boolean sendSmsOnUpdatePassword() {
        return false;
    }



}



