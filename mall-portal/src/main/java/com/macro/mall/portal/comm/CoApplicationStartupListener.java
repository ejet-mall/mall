package com.macro.mall.portal.comm;

import com.ejet.core.kernel.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;


@Component
public class CoApplicationStartupListener implements ApplicationListener {
    Logger logger = LoggerFactory.getLogger(CoApplicationStartupListener.class);
    private static boolean hasReady = false;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            if (event instanceof ContextRefreshedEvent) {
                this.logger.error(" === 全局[ContextRefreshedEvent]回调 ===");
            } else if (event instanceof ApplicationReadyEvent && !hasReady) {
                hasReady = true;
                logger.error(" === 全局[ApplicationReadyEvent]回调 ===");
            } else if (event instanceof ContextStoppedEvent) {
                logger.error(" === 全局[ContextStoppedEvent]回调 ===");
            } else if (event instanceof ContextClosedEvent) {
                logger.error(" === 全局[ContextClosedEvent]回调 ===");
            }
        } catch (Exception var9) {
            this.logger.error("onApplicationEvent", var9);
        }

    }

}
