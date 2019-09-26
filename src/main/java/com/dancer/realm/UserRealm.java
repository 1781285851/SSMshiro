package com.dancer.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.dancer.crud.dao.PermissionDao;
import com.dancer.crud.dao.RoleDao;
import com.dancer.crud.entity.Administrator;
import com.dancer.crud.service.AdministratorService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PermissionDao permissionDao;
	
	//重写的名字
	@Override
	public String getName() {
		return "UserRealm";
	}
	
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//传入参数：	principals：用户认证凭证信息	
		//SimpleAuthorizationInfo：认证方法返回封装认证信息中的第一个参数：用户信息username
		
		//当前登录的用户信息，（用户凭证）----------------------------获取到的是当前登陆成功的名字
		String nameString = (String)principals.getPrimaryPrincipal();
		System.out.println("AuthorizationInfo当前登录的用户：:"+nameString);
		//权限集合
        List<String> permissions = new ArrayList<String>();
        //角色
        String role = null;
        //查询到的角色
        role = roleDao.selectRoleByName(nameString);
        //查询到的权限集合
        permissions = permissionDao.selectPermissionByName(nameString);
        //返回用户在数据库中的权限与角色
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加权限
        info.addStringPermissions(permissions);
        //添加角色
        info.addRole(role);
        System.out.println("role==================="+role);
        for(String a:permissions){
        	System.out.println("permissions==================="+a);
        }
        return info;
	}
	
	
	//认证登录֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //参数token：表示登录时包装的UsernamePasswordToken
		//通过用户名查询数据库的信息，封装成一个AuthenticationInfo对象返回，方便认证器进行对比
		//获取token中的用户名
        String username = (String) token.getPrincipal();
        //查询数据库
        Administrator administrator = administratorService.selectAdministrator(username);
        //判断查询的数据库是否为null(找到)
        if(administrator == null){
            return null;
        }
        //info表示对象realm登录比对信息
        //参数1：用户信息（真实登录中是登录对象的user对象---------token中获取的登录名）  
        //参数2：密码  （从查询到的数据中心获取密码）
        //参数3：UUID加密的盐（如果注册时未经加密可以不写）
        //参数4：当前realm名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, administrator.getPassword(),
                ByteSource.Util.bytes(administrator.getUuid()),
                getName());
        System.out.println("AuthenticationInfo======================="+administrator.getName());
        return info;
	}
	
}
