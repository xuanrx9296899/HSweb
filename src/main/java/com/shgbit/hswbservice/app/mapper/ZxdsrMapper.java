package com.shgbit.hswbservice.app.mapper;

import com.shgbit.hswbservice.app.entity.Zxdsr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-19
 */
@Repository
public interface ZxdsrMapper extends BaseMapper<Zxdsr> {
    @Insert("insert into [dbo].[zxdsrLog] select * from [dbo].[zxdsr]")
    int insertZxdsrLog();
}
