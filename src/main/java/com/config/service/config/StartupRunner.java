package com.config.service.config;

import com.config.service.repository.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author liuxun
 * @apiNote 启动之前做一些操作
 */
@Component
public class StartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    private GeneralService generalService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("<<<<<<<<<<<< 启动初始化操作开始 <<<<<<<<<<<<<<<");
        logger.info("<<<<<<<<<<<< 启动初始化操作结束 <<<<<<<<<<<<<<<");
    }

    @PreDestroy
    public void destory() {
        logger.info("<<<<<<<<<<<< 关闭时操作开始 <<<<<<<<<<<<<<<");
        logger.info("<<<<<<<<<<<< 关闭时操作结束 <<<<<<<<<<<<<<<");
    }
}
