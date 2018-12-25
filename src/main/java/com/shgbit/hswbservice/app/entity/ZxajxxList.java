package com.shgbit.hswbservice.app.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuanrxup
 * @date 2018/12/20  19:10
 */

@XStreamAlias("ZxAjxx")
public class ZxajxxList {
    @XStreamImplicit(itemFieldName = "row")
    private List<Zxajxx> zxajxxList=new ArrayList<Zxajxx>();

    public List<Zxajxx> getZxajxxList() {
        return zxajxxList;
    }

    public void setZxajxxList(List<Zxajxx> zxajxxList) {
        this.zxajxxList = zxajxxList;
    }
}
