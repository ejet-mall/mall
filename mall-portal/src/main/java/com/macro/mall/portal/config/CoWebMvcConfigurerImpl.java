package com.macro.mall.portal.config;

import com.ejet.core.kernel.utils.SpringUtil;
import com.macro.mall.portal.auth.TokenAuthInterceptor;
import com.macro.mall.portal.filter.CoCorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 过滤器、拦截器相关配置
 * 过滤器：spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
 *
 * @author Ejet
 *
 */
@Configuration
public class CoWebMvcConfigurerImpl implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(CoWebMvcConfigurerImpl.class);
	/**
	 * 拦截器链条配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        logger.info("##########  add Interceptors ##########");
        TokenAuthInterceptor authInterceptor = getTokenAuthInterceptor();
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns(authInterceptor.excludePathPatterns());
	}


	 /**
     * 跨域过滤器配置
     * @return
     */
    @Bean
    public FilterRegistrationBean<CoCorsFilter> crosFilterRegistration() {
        FilterRegistrationBean<CoCorsFilter> registration = new FilterRegistrationBean<CoCorsFilter>();
        registration.setFilter(new CoCorsFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(Integer.MAX_VALUE-1); //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
        registration.setName("CROS");
        return registration;
    }

    /**
     * Spring上下文缓存
     *
     * @return SpringUtil
     */
    @Bean
    public SpringUtil springUtils() {
        return new SpringUtil();
    }

    @Bean
    public TokenAuthInterceptor getTokenAuthInterceptor() {
        return new TokenAuthInterceptor();
    }



}
