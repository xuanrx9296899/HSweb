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
@XStreamAlias("SpDsrxx")

public class SpdsrsjList {
    @XStreamImplicit(itemFieldName = "row")
    private List<Spdsrsj> spdsrsjList=new ArrayList<Spdsrsj>();

    public List<Spdsrsj> getSpdsrsjList() {
        return spdsrsjList;
    }

    public void setSpdsrsjList(List<Spdsrsj> spdsrsjList) {
        this.spdsrsjList = spdsrsjList;
    }
}
