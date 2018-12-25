package com.shgbit.hswbservice.app.service;

import com.shgbit.hswbservice.app.entity.Spajxx;
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
public interface ISpajxxService extends IService<Spajxx> {

    public int deleteAndInsert();

    public int insetSpajxx();

    public int deleteSpajxx();


}
