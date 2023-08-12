package com.flight.controller;
import java.util.ArrayList;
//import java.util.*;
//import java.util.List;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.error.NullException;
import com.flight.error.ResourceNotFound;
import com.flight.model.Flight;
import com.flight.service.FlightService;
import com.flight.service.IFlightService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")


@RestController
public class FlightController {
	
	@Autowired
	IFlightService flightService;
	
	


	@GetMapping("/fly")
	@ResponseBody
	ResponseEntity<List<Flight>> showAll() {
		List<Flight> flightList = flightService.findAllflights();
		System.out.println(flightList);
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}

	@GetMapping("/")
	String flightMessage() {
		return ("List of flights added");
	}
	
	ArrayList<Flight> arr=new ArrayList<Flight>();
	@GetMapping(path= "/flights", produces= {MediaType.APPLICATION_JSON_VALUE})
	List<Flight> flights() {
		return flightService.findAllflights();
	}
	
	@GetMapping("/flight/{id}")
	Flight findByflightId(@PathVariable int id) throws ResourceNotFound, NullException
	{return flightService.getFlightById(id);}
	
	@GetMapping("/flight")
	public Flight getflight(@RequestParam(defaultValue="1") int id) {
		return flightService.getflight(id);
	}
		
	@DeleteMapping("/flight/{id}")
	Optional<Flight> deleteByflightId(@PathVariable int id)
	{return flightService.deleteFlight(id);}
	
	@PostMapping ("/flight")
	public Flight createFlight (@RequestBody Flight newflight) {
		flightService.createFlight(newflight);
		return newflight;
	}
	@PutMapping("/flight/{id}")
	public Flight updateFlight(@RequestBody Flight nf,@PathVariable int id) {
		
		flightService.update(nf,id);
		return nf;
	}
}
