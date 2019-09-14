package com.macro.mall.portal.auth;

import com.ejet.core.kernel.api.ResultCode;
import com.ejet.core.kernel.exception.CoBusinessException;
import com.ejet.core.kernel.utils.HttpServletResponseUtil;
import com.macro.mall.portal.constant.PortalConstant;
import com.macro.mall.portal.redis.RedisServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Token验证拦截器
 */
public class TokenAuthInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(TokenAuthInterceptor.class);
    @Autowired
	RedisServiceHelper redis;

    private List<String> excludePath = new ArrayList<>();
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

    public String[] excludePathPatterns() {
		excludePath.add("/sso/login");
		excludePath.add("/sso/register");
		excludePath.add("/sso/logout");

        excludePath.add("/home/**");
        excludePath.add("/product/**");
        excludePath.add("/productCategory/**");
        excludePath.add("/flash/**");
        excludePath.add("/brand/**");
        excludePath.add("/subject/**");

        excludePath.add("/productComment/list/**");
        excludePath.add("/productComment/get/**");

		excludePath.add("/*.html");
		excludePath.add("/favicon.ico");
		excludePath.add("/**/*.html");
		excludePath.add("/**/*.css");
		excludePath.add("/**/*.js");
		excludePath.add("/swagger-resources/**");
		excludePath.add("/v2/api-docs/**");
		excludePath.add("/webjars/springfox-swagger-ui/**");

        return excludePath.toArray(new String[excludePath.size()]);
    }

	//拦截请求是否携带token
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		try {
            String authToken = TokenHelper.getToken(request);
			if(null == authToken || "".equals(authToken)){
				HttpServletResponseUtil.responseJson(response, new CoBusinessException(ResultCode.SYS_TOKEN_TIMEOUT));
				return false;
			}
			//从redis中查看token是否存在
			Object obj = redis.get(authToken);
			if(null == obj){
				HttpServletResponseUtil.responseJson(response, new CoBusinessException(ResultCode.SYS_TOKEN_TIMEOUT));
				return false;
			}
			//刷新token
			redis.refresh(authToken, PortalConstant.TOKEN_KEY_TIMEOUT);

		} catch (CoBusinessException e) {
			HttpServletResponseUtil.responseJson(response, new CoBusinessException(ResultCode.SYS_ERROR, e));
			return false;
		}
		return true;
	}

    public void setExcludePath(List<String> excludePath) {
	    if(excludePath !=null && excludePath.size()>0) {
            this.excludePath = excludePath;
        }
    }

}
