package com.shgbit.hswbservice.app.mapper;

import com.shgbit.hswbservice.app.entity.Spajxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;
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
public interface SpajxxMapper extends BaseMapper<Spajxx> {
    @Insert("insert into [dbo].[spajxxLog] select * from [dbo].[spajxx]")
    int insertSpajxxLog();

}
