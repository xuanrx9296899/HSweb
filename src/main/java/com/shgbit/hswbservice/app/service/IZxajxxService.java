package com.shgbit.hswbservice.app.service;

import com.shgbit.hswbservice.app.entity.Zxajxx;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-20
 */
@Service
public interface IZxajxxService extends IService<Zxajxx> {
    public int deleteAndInsert();

    public int insetZxajxx();

    public int deletZxajxx();

}
