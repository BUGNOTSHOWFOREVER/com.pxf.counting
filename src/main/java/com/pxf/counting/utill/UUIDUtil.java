package com.pxf.counting.utill;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

/**
 * @className: UUIDUtil
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/28 15:16
 * @version: 1.0
 */
public class UUIDUtil {
    public static String getUuid(){
       UUID uuid1 = Generators.timeBasedGenerator().generate();
       return uuid1.toString();
    }
}
