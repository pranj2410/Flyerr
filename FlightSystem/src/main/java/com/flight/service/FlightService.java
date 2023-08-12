package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.error.NullException;
import com.flight.error.ResourceNotFound;
import com.flight.model.Flight;
import com.flight.repo.FlightDAO;
@Service
public class FlightService implements IFlightService{
	ArrayList<Flight> flights = new ArrayList<Flight>();
	@Autowired

	FlightDAO flightDAO;
	
	@Override
	public List<Flight> findAllflights() {
		// TODO Auto-generated method stub
		return flightDAO.getAllFlights();
	}

	@Override
	public Flight getflight(int flightNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Flight> deleteFlight(int flightNo) {
		// TODO Auto-generated method stub
		Optional<Flight> deletedFlight = null;
		try {
			deletedFlight = flightDAO.deleteByflightId(flightNo);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return deletedFlight;
	}

	@Override
	public int createFlight(Flight newFlight) {
		// TODO Auto-generated method stub
		return flightDAO.saveFlight(newFlight);
	}

	@Override
	public Flight getFlightById(int id) throws ResourceNotFound, NullException {
		Flight updatedflight = flightDAO.findbyId(id).orElseThrow(()-> new ResourceNotFound ("flight is not available:"+id));
		return updatedflight;
	}
	public int update(Flight f,int id) {
		return flightDAO.updateFlight(f, id);
	}
			
	

	


}
