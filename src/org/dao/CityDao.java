package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pojo.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	
	@Resource
	private SessionFactory sf;

	public List<City> selectAllCity(String citySql) {
		Session session = sf.getCurrentSession();
		return session.createSQLQuery(citySql).addEntity(City.class).list();
	}

}
