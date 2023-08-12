package com.flight.repo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;

@Repository
public class FlightDAO {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	private org.springframework.jdbc.core.RowMapper<Flight> rowMapper=(ResultSet rs, int rowNum)->{
		Flight flight=new Flight();
		flight.setId(rs.getInt(1));
		flight.setFlightName(rs.getString(2));
		flight.setSource(rs.getString(3));
		flight.setDestination(rs.getString(4));
		flight.setPrice(rs.getInt(5));
		return flight;
	};
	public List<Flight> getAllFlights(){
		return jdbcTemplate.query("select * from Flight", rowMapper);
	}
	
	public Optional<Flight> findbyId(int id) {
		String sql="select * from Flight where id='"+id+"' ";
		return jdbcTemplate.query(sql, rowMapper)
				.stream()
				.findFirst();
	}
	
	
	public Optional<Flight> deleteByflightId(int id) {
		Optional<Flight> deletedFlight = findbyId(id);
		
		String sql=" delete from Flight where id='"+id+"' ";
		 jdbcTemplate.execute(sql);
		 return deletedFlight;
	}
	
	public int saveFlight(Flight e) {
		System.out.println(e.toString());
		String query="insert into Flight(flight_name, Source, Destination, Price) values( '" + e.getFlightName()+"','"+e.getSource()+"','"+e.getDestination()+"','"+(int)e.getPrice()+"')";
		return jdbcTemplate.update(query);
	}
	public int updateFlight(Flight fl,int i)
	{
		String query="Update Flight set flight_name='"+fl.getFlightName()+"',source='"+fl.getSource() + "',destination='"+fl.getDestination() + "',price='"+(int)fl.getPrice() + "' where id ='" + i +"'";
		return jdbcTemplate.update(query);
	}
}