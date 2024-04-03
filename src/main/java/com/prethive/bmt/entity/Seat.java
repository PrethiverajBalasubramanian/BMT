package com.prethive.bmt.entity;

public class Seat
{	
	public enum Status
	{
		TAKEN, AVAILABLE;
		
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
	
	private Integer id;
	
	private String section;
	
	private int row;
	
	private int column;
	
	private Status status = Status.AVAILABLE;
	
	public Seat(String section, int row, int column)
	{	
		this.id = idGenerator++;
		
		this.section = section;
		
		this.row = row;
		
		this.column = column;
	}
	
	public String getSection()
	{
		return section;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public Integer getId() 
	{
		return id;
	}
}
