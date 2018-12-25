package com.shgbit.hswbservice.app.service;

import com.shgbit.hswbservice.app.entity.Zxdsr;
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
public interface IZxdsrService extends IService<Zxdsr> {
    public int deleteAndInsert();

    public int insetZxdsr();

    public int deleteZxdsr();
}
