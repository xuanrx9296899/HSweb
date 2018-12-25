package com.shgbit.hswbservice.app.mapper;

import com.shgbit.hswbservice.app.entity.Zxajxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-20
 */
@Repository
public interface ZxajxxMapper extends BaseMapper<Zxajxx> {
    @Insert("insert into [dbo].[zxajxxLog] select * from [dbo].[zxajxx]")
    int insertZxajxxLog();
}
