package com.Spring.HcE.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Spring.HcE.Model.User_Details;
import com.Spring.HcE.Repository.IUserDetailsRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	public IUserDetailsRepo userdetailRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User_Details user = userdetailRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username+" not found"));	
		return new UserDetailService(user);
	}

}
