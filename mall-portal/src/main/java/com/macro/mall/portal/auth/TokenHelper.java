package com.macro.mall.portal.auth;

import com.ejet.core.kernel.exception.CoBusinessException;
import com.ejet.core.kernel.utils.SpringUtil;
import com.ejet.core.kernel.utils.StringUtil;
import com.ejet.core.kernel.utils.UuidUtil;
import com.macro.mall.portal.redis.RedisServiceHelper;
import com.macro.mall.portal.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

import static com.ejet.core.kernel.api.ResultCode.SYS_TOKEN_TIMEOUT;
import static com.macro.mall.portal.constant.PortalConstant.ACCESS_TOKEN_KEY;


/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: TokenHelper
 * Author:   Ejet
 * Description: token信息
 * History:
 * Version: 1.0
 */
public class TokenHelper {
    private static final Logger logger = LoggerFactory.getLogger(TokenHelper.class);
    @Autowired
    private static RedisServiceHelper redis;
    static {
        if(redis==null) {
            redis = SpringUtil.getBean(RedisServiceHelper.class);
        }
    }
    /**
     * 解析请求的token信息，并从redis或者本地返回用户信息
     */
    public static String getToken(HttpServletRequest request) throws CoBusinessException {

        String authToken = request.getHeader(ACCESS_TOKEN_KEY);
        if(null == authToken || "".equals(authToken)) {
            authToken = request.getParameter(ACCESS_TOKEN_KEY);
        }
        if(StringUtil.isBlank(authToken)){
            Object token = request.getAttribute(ACCESS_TOKEN_KEY);
            if (token != null)
                authToken = token.toString();
        }
        if(StringUtil.isBlank(authToken)) {
            authToken = CookieUtil.getCookieValue(request, ACCESS_TOKEN_KEY);
        }
        //throw new CoBusinessException(ExceptionCode.SYS_HINT, "Token认证失败!");
        return authToken;
    }

    /**
     * 校验token
     *
     * @return
     */
    public static <T> T getCurrentUser(HttpServletRequest request, Class clazz) throws CoBusinessException {
        T object = null;
        String authToken = getToken(request);
        object = redis.get(authToken, clazz);
        if(null == object){
            throw new CoBusinessException(SYS_TOKEN_TIMEOUT);
        }
        return object;
    }
    /**
     * 校验token
     *
     * @return
     */
    public static <T> T getCurrentUser(Class clazz) throws CoBusinessException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return getCurrentUser(request, clazz);
    }

    /**
     *  生成Token信息
     *
     * @return
     */
    public static String createToken() {
        String token = UuidUtil.getUUID();
        return token;
    }

    /**
     * 缓存token信息
     */
    public static void cacheToken(String tokenKey, Object value, int timeOut) {
        redis.put(tokenKey,  value, timeOut, TimeUnit.SECONDS);
    }

    public static void delToken(String tokenKey) {
        redis.delete(tokenKey);
    }


    public static String getToken() throws CoBusinessException {
        String token = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        token = getToken(request);
        return token;
    }
}
