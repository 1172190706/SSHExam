package org.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer flightID;
	
	@ManyToOne
	@JoinColumn(name="starCityID")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="endCityID")
	private City city1;
	private String starTime;
	
	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", city=" + city + ", city1=" + city1 + ", starTime=" + starTime + "]";
	}

	public Integer getFlightID() {
		return flightID;
	}

	public void setFlightID(Integer flightID) {
		this.flightID = flightID;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public String getStarTime() {
		return starTime;
	}

	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}
	
	


	
	
}
