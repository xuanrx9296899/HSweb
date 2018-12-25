package com.shgbit.hswbservice.app.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuanrxup
 * @date 2018/12/20  17:40
 */


@XStreamAlias("ZxDsrxx")
public class ZxdsrList {
    @XStreamImplicit(itemFieldName = "row")
    private List<Zxdsr> zxdsrList=new ArrayList<Zxdsr>();

    public List<Zxdsr> getZxdsrList() {
        return zxdsrList;
    }

    public void setZxdsrList(List<Zxdsr> zxdsrList) {
        this.zxdsrList = zxdsrList;
    }
}
