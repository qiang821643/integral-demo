package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mapper.TestMybatis;
import com.mode.SysUser;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author YangTG
 *
 */

@Component
@Slf4j
public class MyUserService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TestMybatis testMybatis;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		log.info("当前登录的用户是："+user);
			SysUser currentUser = testMybatis.findByUserName(user);
		String pass="";
		if(currentUser!=null)
			pass = passwordEncoder.encode(currentUser.getPwd());
		
		return new User(user,pass, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		
	}
	
}
