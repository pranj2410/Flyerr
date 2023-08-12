package com.flight.service;
import java.util.*;

import com.flight.error.NullException;
import com.flight.error.ResourceNotFound;
import com.flight.model.*;
public interface IFlightService {
	
	List<Flight> findAllflights();
	Flight getflight(int flightNo);
	Optional<Flight> deleteFlight(int flightNo);
	int createFlight(Flight newFlight);
	Flight getFlightById(int id) throws ResourceNotFound, NullException;
	int update(Flight nf, int id);
}
