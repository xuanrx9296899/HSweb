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
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@XStreamAlias("row")
@TableName("zxajxx")
public class Zxajxx implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @XStreamAlias("SANH")
    private String sanh;
    @XStreamAlias("SABH")
    private String sabh;
    @XStreamAlias("QSNY")
    private String qsny;
    @XStreamAlias("ZZNY")
    private String zzny;
    @XStreamAlias("FYDM")
    private String fydm;
    @XStreamAlias("FYMC")
    private String fymc;
    @XStreamAlias("AH")
    private String ah;
    @XStreamAlias("KYG")
    private String kyg;
    @XStreamAlias("KYC")
    private String kyc;
    @XStreamAlias("CDSSJ")
    private String cdssj;
    @XStreamAlias("ZXR")
    private String zxr;
    @XStreamAlias("TKDD")
    private String tkdd;
    @XStreamAlias("LXR")
    private String lxr;
    @XStreamAlias("LXDH")
    private String lxdh;
    @XStreamAlias("KYLSJ")
    private String kylsj;
    @XStreamAlias("BDJE")
    private String bdje;
    @XStreamAlias("ZXF")
    private String zxf;
    @XStreamAlias("SPZ")
    private String spz;
    @XStreamAlias("SPY")
    private String spy;
    @XStreamAlias("SJY")
    private String sjy;

    private LocalDateTime updatetime;


}
