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
	
	@Override
	public String getName() {
		return "UserRealm";
	}
	
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Administrator administrator = (Administrator)principals.getPrimaryPrincipal();
		System.out.println("++++++++++++++执行授权:"+administrator.getName());
        List<String> permissions = new ArrayList<String>();
        String role = null;
        //根据用户名查询该用户所具有的角色
        role = roleDao.selectRoleByName(administrator.getName());
        //根据用户名查询该用户所具有的权限
        permissions = permissionDao.selectPermissionByName(administrator.getName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRole(role);
        System.out.println("role==================="+role);
        for(String a:permissions){
        	System.out.println("permissions==================="+a);
        }
        return info;
	}
	
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从token中获取登录的用户名， 查询数据库返回用户信息
        String username = (String) token.getPrincipal();
        Administrator administrator = administratorService.selectAdministrator(username);

        if(administrator == null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(administrator, administrator.getPassword(),
                ByteSource.Util.bytes(administrator.getUuid()),
                getName());
        System.out.println("======================="+administrator.getName());
        return info;
	}
	
}
