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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@XStreamAlias("row")
@TableName("zxkycz")
public class Zxkycz implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @XStreamAlias("SANH")
    private String sanh;
    @XStreamAlias("SABH")
    private String sabh;
    @XStreamAlias("KYC")
    private String kyc;

    private LocalDateTime updatetime;


}
