package com.prethive.bmt.util;

public class BMTUtil 
{
	public static <T> void nullCheck(T t)
	{
		if(t == null)
		{
			throw new NullPointerException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void nullCheck(T... args)
	{
		for(T t : args)
		{
			nullCheck(t);
		}
	}
}
