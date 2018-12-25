package com.shgbit.hswbservice.app.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-19
 */
//lombok 简化get/set
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//对应row元素
@XStreamAlias("row")
@TableName("spajxx")
public class Spajxx implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @XStreamAlias("NDH")
    private String ndh;
    @XStreamAlias("SAXH")
    private String saxh;
    @XStreamAlias("QSNY")
    private String qsny;
    @XStreamAlias("ZZNY")
    private String zzny;
    @XStreamAlias("JBFY")
    private String jbfy;
    @XStreamAlias("FYMC")
    private String fymc;
    @XStreamAlias("AH")
    private String ah;
    @XStreamAlias("SQRQ")
    private String sqrq;
    @XStreamAlias("SQJE")
    private String sqje;
    @XStreamAlias("SPZ")
    private String spz;
    @XStreamAlias("SPY")
    private String spy;
    @XStreamAlias("DLSPY")
    private String dlspy;
    @XStreamAlias("CDSSJ")
    private String cdssj;
    @XStreamAlias("KYLSJ")
    private String kylsj;
    @XStreamAlias("SJY")
    private String sjy;
    @XStreamAlias("CDJE")
    private String cdje;
    @XStreamAlias("KYG")
    private String kyg;
    @XStreamAlias("KYC")
    private String kyc;
    @XStreamAlias("CZFLFG")
    private String czflfg;
    @XStreamAlias("LXR")
    private String lxr;
    @XStreamAlias("LXDH")
    private String lxdh;

    private LocalDateTime updatetime;


}
