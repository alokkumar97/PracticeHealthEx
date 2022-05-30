package com.Spring.HcE.Service;

import com.Spring.HcE.Model.User_Details;
import com.Spring.HcE.Repository.IUserDetailsRepo;

public class UserServiceIMPL implements IUserService {

	public IUserDetailsRepo userRepo;

	/*
	 * @Override public Integer saveUserDetails(UserDetails user) { return
	 * userRepo.save(user).getId(); }
	 */
	@Override
	public Integer saveUserDetails(User_Details user) {
		// TODO Auto-generated method stub
		return null;
	}

}
