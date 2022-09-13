package com.example.common;
import java.util.UUID;

public class UUIDStringUtils {
    // 生成唯一激活码
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        String uuid_test1;

        String uuid_test = uuid.toString().replace("-", "").toUpperCase().substring(0,20);
        String regex = "(.{5})";
        uuid_test = uuid_test.replaceAll(regex,"$1-");
        uuid_test1 = uuid_test.substring(0,uuid_test.length()-1);
        return uuid_test1;
    }
}
