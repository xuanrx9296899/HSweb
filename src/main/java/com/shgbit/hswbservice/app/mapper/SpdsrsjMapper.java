package com.shgbit.hswbservice.app.mapper;

import com.shgbit.hswbservice.app.entity.Spdsrsj;
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
public interface SpdsrsjMapper extends BaseMapper<Spdsrsj> {
    @Insert("insert into [dbo].[spdsrsjLog] select * from [dbo].[spdsrsj]")
    int insertSpdsrsjLog();
}
