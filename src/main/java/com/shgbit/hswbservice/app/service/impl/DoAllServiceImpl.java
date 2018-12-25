package com.shgbit.hswbservice.app.service.impl;

import com.shgbit.hswbservice.app.service.DoAllService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author xuanrxup
 * @date 2018/12/20  19:34
 */
@Service
@Slf4j

public class DoAllServiceImpl implements DoAllService {
    @Autowired
    SpajxxServiceImpl spajxxService;
    @Autowired
    SpdsrsjServiceImpl spdsrsjService;
    @Autowired
    ZxajxxServiceImpl zxajxxService;
    @Autowired
    ZxdsrServiceImpl zxdsrService;
    @Autowired
    ZxkyczServiceImpl zxkyczService;
    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void doAll() {
        log.info("doAll开始执行。。。。");
        log.info("spajxxService开始执行。。。。。。。。。。。。");
        spajxxService.deleteAndInsert();
        log.info("spdsrsjService开始执行。。。。。。。。。。。。");
        spdsrsjService.deleteAndInsert();
        log.info("zxajxxService开始执行。。。。。。。。。。。。");
        zxajxxService.deleteAndInsert();
        log.info("zxdsrService开始执行。。。。。。。。。。。。");
        zxdsrService.deleteAndInsert();
        log.info("zxkyczService开始执行。。。。。。。。。。。。");
        zxkyczService.deleteAndInsert();
        log.info("doAll执行完毕。。。。。。。。。。。。");
    }


}
