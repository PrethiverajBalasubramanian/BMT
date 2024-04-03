package com.prethive.bmt.entity;

import com.prethive.bmt.util.BMTUtil;

public class Booking
{
	public enum Status
	{
		BOOKED, CANCELLED;
		
		public static Status parse(String status) 
		{
			for(Status s : Status.values())
			{
				if(s.name().equalsIgnoreCase(status))
				{
					return s;
				}
			}
			
			throw new IllegalArgumentException("Invalid status passed");
		}
	}
	private static int idGenerator = 0;
	
	private int id;
	
	private String from;
	
	private String to;
	
	private Double fare;
	
	private User user;
	
	private Integer seat;
	
	private Status status = Status.BOOKED;
	
	public Booking(String from, String to, Double fare, Integer seat, User user) throws Exception 
	{	
		BMTUtil.nullCheck(from, to, fare, seat, user);
		this.id = idGenerator++;
		this.from = from;
		this.to = to;
		this.fare = fare;
		this.seat = seat;
		this.user = user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Integer getSeat()
	{
		return seat;
	}
	
	public Double getFare()
	{
		return fare;
	}
	
	public String getFrom()
	{
		return from;
	}
	
	public String getTo()
	{
		return to;
	}
}
