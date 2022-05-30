package com.Spring.HcE.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_details_tab")
@Data
public class User_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(length =30, nullable = false, unique = true)
	private String userName;
	
}
