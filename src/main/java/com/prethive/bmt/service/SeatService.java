package com.prethive.bmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prethive.bmt.entity.Seat;
import com.prethive.bmt.entity.Seat.Status;

@Service
public class SeatService
{
	private final List<Seat> seats;
	
	public SeatService(List<Seat> seats)
	{
		this.seats = seats;
	}
	
	public List<Seat> getSeats()
	{
		return seats;
	}
	
	public void addSeat(Seat seat)
	{
		seats.add(seat);
	}
	
	public Seat getSeat(Integer id)
	{
		return seats.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}
	
	public List<Seat> getSeats(Status status)
	{
		return seats.stream().filter(s -> s.getStatus().equals(status)).collect(Collectors.toList());
	}
}
