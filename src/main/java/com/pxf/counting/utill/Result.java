package com.pxf.counting.utill;

import lombok.Data;

import java.util.List;

/**
 * @className: Result
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/28 11:12
 * @version: 1.0
 */
@Data
public class Result {
    /**
     * 响应信息
     */
    private String massage;

    /**
     * 返回的数据
     */
    private List<? extends Object> results;

    /**
     * 数量
     */
    private int totalcount;

}
