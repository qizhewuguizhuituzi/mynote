package com.zcb.realm;

import com.zcb.Utils.ShiroMd5Util;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取身份信息 其实就是账户
        String principal = authenticationToken.getPrincipal().toString();
        System.out.println("获取到的要认证身份信息是:" + principal);
        //获取凭证信息 其实就是密码
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("获取到的认证凭证信息是:" + password);
        //从数据库中查询账户跟密码确认
        if ("zhangsan".equals(principal)) {
            //假装从数据库中获取到 md5 加盐3次加密的密码
            String  pwdInfo = "d1b129656359e35e95ebd56a63d7b9e0";
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    pwdInfo,
                    ByteSource.Util.bytes(ShiroMd5Util.SALT),
                    principal);
            return simpleAuthenticationInfo;
        }
        //封装认证信息返回
        return null;
    }
}
