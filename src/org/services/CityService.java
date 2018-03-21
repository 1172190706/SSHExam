package org.services;

import javax.annotation.Resource;

import org.dao.CityDao;
import org.pojo.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {
	
	@Resource
	private CityDao cd;

	public java.util.List<City> selectAllCIty(String citySql) {
		return cd.selectAllCity(citySql);
	}
	
	

}
