package com.zcb.Utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

//通过使用ShiroMd5进行加密
public class ShiroMd5Util {
    public final static String SALT = "salt";

    //普通加密
    public static String md5Encryption(String password){
        Md5Hash md5Hash = new Md5Hash(password);
        return md5Hash.toHex();
    }
    //带盐加密
    public static String md5Encryption(String password, String salt){
        Md5Hash md5Hash = new Md5Hash(password, salt);
        return md5Hash.toHex();
    }
    //带盐多次加密
    public static String md5Encryption(String password,String salt,int time){
        Md5Hash md5Hash = new Md5Hash(password, salt, time);
        return md5Hash.toHex();
    }
    //父类加密,使用Md5Hash的父类进行加密 一般加密类型还是使用的MD5
    public static String fatherEncryption(String EncryptionType,String password,String salt,int time){
        SimpleHash simpleHash = new SimpleHash(EncryptionType, password, salt, time);
        return simpleHash.toHex();
    }

}
