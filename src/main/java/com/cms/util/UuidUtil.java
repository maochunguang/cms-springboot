package com.cms.util;

import java.util.UUID;

/**
 * @author maocg
 * description: uuid生产工具类
 */
public class UuidUtil {

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(get32UUID());
    }
}

