package com.shgbit.hswbservice.app.config;

import com.shgbit.hswbservice.app.service.DoAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xuanrxup
 * @date 2018/12/20  14:59
 */
@Configuration
//扫描@Transactional
//@EnableTransactionManagement
public class AppConfig {
    @Autowired
    DoAllService doAllService;

    public void doALL(){
        doAllService.doAll();
    }
}
