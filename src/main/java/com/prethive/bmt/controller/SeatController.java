package com.prethive.bmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prethive.bmt.entity.Seat;
import com.prethive.bmt.entity.Seat.Status;
import com.prethive.bmt.service.SeatService;

@RestController
@RequestMapping("/seats")
public class SeatController
{
	@Autowired
	SeatService seatService;
	
	@GetMapping
	public ResponseEntity<?> getSeats(@RequestParam(name = "status", required = false) String status) 
	{
		List<Seat> seats = status == null || status.isBlank() ? seatService.getSeats() : seatService.getSeats(Status.parse(status));
		
		return seats == null || seats.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(Map.of("seats", seats));
	}
}
