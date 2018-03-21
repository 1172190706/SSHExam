package org.services;

import java.util.List;

import javax.annotation.Resource;

import org.dao.FlightDao;
import org.pojo.Flight;
import org.pojo.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightService {
	
	@Resource
	private FlightDao fd;
	
	public List<Flight> selectAllFlight(String flightSql) {
		return fd.selectAllFlight(flightSql);
	}

	public void add(Flight flight) {
		fd.add(flight);
	}

	public void del(Integer flightID) {
		fd.del(flightID);
	}

}
