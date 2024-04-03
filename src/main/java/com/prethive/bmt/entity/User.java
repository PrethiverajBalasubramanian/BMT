package com.prethive.bmt.entity;

import com.prethive.bmt.util.BMTUtil;

public class User 
{
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	public User(String first_name, String last_name, String email)
	{
		BMTUtil.nullCheck(first_name, last_name, email);
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	
	public void setFirst_name(String firstName)
	{
		BMTUtil.nullCheck(firstName);
		this.first_name = firstName;
	}
	
	public void setLast_name(String lastName)
	{
		BMTUtil.nullCheck(lastName);
		this.last_name = lastName;
	}
	
	public void setEmail(String email)
	{
		BMTUtil.nullCheck(email);
		this.email = email;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public String getFirst_name() 
	{
		return first_name;
	}
	
	public String getLast_name()
	{
		return last_name;
	}
}
