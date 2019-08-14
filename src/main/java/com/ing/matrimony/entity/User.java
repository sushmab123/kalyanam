package com.ing.matrimony.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private int age;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String address;
	private String education;
	private String maritalStatus;
	private String gender;
	private String motherTongue;
	private String membershipType;

}
