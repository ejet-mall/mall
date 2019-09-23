package com.macro.mall.service.impl;

import com.macro.mall.dao.SysHomeCountDao;
import com.macro.mall.dto.SysHomeCountResult;
import com.macro.mall.service.SysHomeCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 首页统计信息
 */
@Service
public class SysHomeCountServiceImpl implements SysHomeCountService {

    @Autowired
    private SysHomeCountDao homeCountDao;

    @Override
    public SysHomeCountResult homeProductOrderCount() {
        return homeCountDao.homeProductOrderCount();
    }



}
