package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pojo.Flight;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDao {
	
	@Resource
	private SessionFactory sf;

	public List<Flight> selectAllFlight(String flightSql) {
		Session session = sf.getCurrentSession();
		return session.createSQLQuery(flightSql).addEntity(Flight.class).list();
	}

	public void add(Flight flight) {
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(flight);
	}

	public void del(Integer flightID) {
		Session session = sf.getCurrentSession();
		Flight flight = session.get(Flight.class, flightID);
		session.delete(flight);
	}

}
