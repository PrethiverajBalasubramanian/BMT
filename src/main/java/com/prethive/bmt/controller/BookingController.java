package com.prethive.bmt.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prethive.bmt.entity.Booking;
import com.prethive.bmt.entity.Seat.Status;
import com.prethive.bmt.service.BookingService;
import com.prethive.bmt.service.SeatService;

@RestController
@RequestMapping("/train/book")
public class BookingController
{
	@Autowired
	BookingService bookingService;
	
	@Autowired
	SeatService seatService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createBooking(@RequestBody Booking booking)
	{
		if(seatService.getSeat(booking.getSeat()).getStatus().equals(Status.TAKEN))
		{
			throw new IllegalArgumentException();
		}
		
		seatService.getSeat(booking.getSeat()).setStatus(Status.TAKEN);
		
		bookingService.createBooking(booking);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateBooking(@PathVariable int id,@RequestBody Map<String, Object> booking)
	{
		Booking bookin = bookingService.getBooking(id);
		
		if(bookin == null)
		{
			return ResponseEntity.internalServerError().body(null);
		}
		
		Map<String, String> user = (Map<String, String>) booking.get("user");
		
		if(user != null)
		{
			for(Entry<String, String> entry : user.entrySet())
			{
				switch (entry.getKey()) 
				{
					case "last_name":
						bookin.getUser().setLast_name(entry.getValue());
						break;
					case "first_name":
						bookin.getUser().setFirst_name(entry.getValue());
						break;
					case "email":
						bookin.getUser().setEmail(entry.getValue());
						break;
				}
			}
		}
		
		return ResponseEntity.ok(null);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBookings()
	{
		List<Booking> bookings = bookingService.getBookings();
		
		return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(Map.of("bookings", bookings));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBooking(@PathVariable int id)
	{
		Booking booking = bookingService.getBooking(id);
		
		return booking == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(Map.of("bookings", List.of(booking)));
	}
	
	public ResponseEntity<?> cancelBooking(@PathVariable int id) 
	{
		Booking booking = bookingService.getBooking(id);
		
		if(booking == null)
		{
			return ResponseEntity.internalServerError().body(null);
		}
		
		seatService.getSeat(booking.getSeat()).setStatus(Status.AVAILABLE);
		
		return ResponseEntity.ok(null);
	}
}
