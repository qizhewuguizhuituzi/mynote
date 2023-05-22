package com.zcb;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;

public class ShiroTest {
    public static void main(String[] args) {
        //获取SecurityManage
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        //后去Subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "123456");
        try {
            //登录认证
            subject.login(token);
            System.out.println("登录成功");
            //判断用户是否拥有某些角色
            boolean b = subject.hasRole("role1");
            System.out.println("当前用户拥有role1=" + b);
            //判断当前用户是否拥有默写全写
            boolean b1 = subject.isPermitted("user:select");
            System.out.println("当前用户拥有user:select权限=" + b1);
        } catch (UnknownAccountException e) {
            System.out.println("不存在当前用户异常");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        } catch (LockedAccountException e) {
            System.out.println("用户被锁定");
        } catch (AuthenticationException e) {
            System.out.println("用户认证失败");
        }
        Assert.isTrue(subject.isAuthenticated());
    }
}
