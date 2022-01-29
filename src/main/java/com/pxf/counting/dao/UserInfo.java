package com.pxf.counting.dao;

import lombok.Data;



import java.util.Date;

/**
 * @className: UserInfo
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/27 11:25
 * @version: 1.0
 */
@Data
public class UserInfo {
    /**
     * id
     */
    private String id;

    /**
     * nickname
     */
    private String nickname;

    /**
     * 身份证
     */
    private String idCar;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    private Date crateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     *页数
     */
    private Integer page;

    /**
     *数据条数
     */
    private Integer size;


}
