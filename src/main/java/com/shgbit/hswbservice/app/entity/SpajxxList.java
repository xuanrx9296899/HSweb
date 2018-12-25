package com.shgbit.hswbservice.app.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuanrxup
 * @date 2018/12/19  17:31
 */
//对应SpAjxx元素
@XStreamAlias("SpAjxx")
public class SpajxxList {
    @XStreamImplicit(itemFieldName = "row")
    private List<Spajxx> spajxxList=new ArrayList<Spajxx>();

    public List<Spajxx> getSpajxxList() {
        return spajxxList;
    }

    public void setSpajxxList(List<Spajxx> spajxxList) {
        this.spajxxList = spajxxList;
    }
}
