package com.shgbit.hswbservice.app.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuanrxup
 * @date 2018/12/20  17:41
 */
@Data
@XStreamAlias("ZxKycxx")
public class ZxkyczList {
    @XStreamImplicit(itemFieldName = "row")
    private List<Zxkycz>zxkyczList=new ArrayList<>();

}
