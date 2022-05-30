package com.Spring.HcE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.HcE.Model.User_Details;


public interface IUserDetailsRepo extends JpaRepository<User_Details, Integer> {

	public Optional<User_Details> findByEmail(String email) ;
}
