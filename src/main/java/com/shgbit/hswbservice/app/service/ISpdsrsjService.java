package com.shgbit.hswbservice.app.service;

import com.shgbit.hswbservice.app.entity.Spdsrsj;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-19
 */
@Service
public interface ISpdsrsjService extends IService<Spdsrsj> {

    public int deleteAndInsert();

    public int insetSpdsr();

    public int deletSpdsr();
}
