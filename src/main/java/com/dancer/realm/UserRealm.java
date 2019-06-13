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
	
	
	//��Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Administrator administrator = (Administrator)principals.getPrimaryPrincipal();
		System.out.println("++++++++++++++ִ����Ȩ:"+administrator.getName());
        List<String> permissions = new ArrayList<String>();
        String role = null;
        //�����û�����ѯ���û������еĽ�ɫ
        role = roleDao.selectRoleByName(administrator.getName());
        //�����û�����ѯ���û������е�Ȩ��
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
	
	
	//��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //��token�л�ȡ��¼���û����� ��ѯ���ݿⷵ���û���Ϣ
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
