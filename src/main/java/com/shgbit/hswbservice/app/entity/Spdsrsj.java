package com.shgbit.hswbservice.app.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("spdsrsj")
//对应row元素
@XStreamAlias("row")
public class Spdsrsj implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @XStreamAlias("NDH")
    private String ndh;
    @XStreamAlias("SAXH")
    private String saxh;
    @XStreamAlias("DSRMC")
    private String dsrmc;
    @XStreamAlias("DSRLX")
    private String dsrlx;
    @XStreamAlias("XB")
    private String xb;
    @XStreamAlias("MZ")
    private String mz;
    @XStreamAlias("SR")
    private String sr;
    @XStreamAlias("DZ")
    private String dz;
    @XStreamAlias("WTDLRXM1")
    private String wtdlrxm1;
    @XStreamAlias("WTDLRSWS1")
    private String wtdlrsws1;
    @XStreamAlias("WTDLRZW1")
    private String wtdlrzw1;
    @XStreamAlias("WTDLRXM2")
    private String wtdlrxm2;
    @XStreamAlias("FDDLRXM")
    private String fddlrxm;
    @XStreamAlias("FDDLRZW")
    private String fddlrzw;
    @XStreamAlias("FDDLRXB")
    private String fddlrxb;
    @XStreamAlias("FDDLRMZ")
    private String fddlrmz;
    @XStreamAlias("FDDLRSR")
    private String fddlrsr;
    @XStreamAlias("YSQRGX")
    private String ysqrgx;
    @XStreamAlias("SFZ")
    private String sfz;
    @XStreamAlias("WTDLRSWS2")
    private String wtdlrsws2;
    @XStreamAlias("WTDLRZW2")
    private String wtdlrzw2;
    @XStreamAlias("FDDLRZZ")
    private String fddlrzz;
    @XStreamAlias("FDDLRSFZ")
    private String fddlrsfz;

    @TableField("updateTime")
    private LocalDateTime updateTime;


}
