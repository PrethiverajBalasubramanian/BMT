package com.prethive.bmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prethive.bmt.entity.Booking;

@Service
public class BookingService
{
	private final List<Booking> bookings = new ArrayList<Booking>();
	
	public List<Booking> getBookings()
	{
		return bookings;
	}
	
	public void createBooking(Booking booking)
	{
		bookings.add(booking);
	}
	
	public Booking getBooking(int id)
	{
		return bookings.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
	}
}
