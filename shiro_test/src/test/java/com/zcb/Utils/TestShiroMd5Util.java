package com.zcb.Utils;

public class TestShiroMd5Util {
    public static void main(String[] args) {
        String s = ShiroMd5Util.md5Encryption("123456", ShiroMd5Util.SALT, 3);
        System.out.println(s);
    }
}
