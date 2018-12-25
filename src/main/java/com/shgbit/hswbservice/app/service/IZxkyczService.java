package com.shgbit.hswbservice.app.service;

import com.shgbit.hswbservice.app.entity.Zxkycz;
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
public interface IZxkyczService extends IService<Zxkycz> {
    public int deleteAndInsert();

    public int insetZxkyc();

    public int deleteZxkyc();
}
