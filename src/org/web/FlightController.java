package org.web;

import java.sql.ResultSet;

import javax.annotation.Resource;

import org.pojo.City;
import org.pojo.Flight;
import org.pojo.Page;
import org.services.CityService;
import org.services.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Resource
	private FlightService fs;
	
	@Resource
	private CityService cs;
	
	public boolean isN(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		}
		return false;

	}
	
	
	@RequestMapping("/list")
	public String List(ModelMap map,Flight flight,String curSize,String curPage) {
		Page page = new Page();
	    System.out.println("controller:list");	
	    System.out.println("curSize:"+curSize);
	    System.out.println("curPage:"+curPage);
	    System.out.println("page"+page);
		// 判断 赋值
		if (!isN(curPage)) {
			page.setCurPage(Integer.parseInt(curPage));
		}
		if (!isN(curSize)) {
			page.setCurSize(Integer.parseInt(curSize));
		}
	    
		String flightSql="select * from flight where 1=1 ";
	
	
		if(flight!=null&&flight.getCity()!=null&&flight.getCity().getCityID()!=null){
			flightSql+=" and starCityID = "+flight.getCity().getCityID();
		}
		
		if(flight!=null&&flight.getCity1()!=null&&flight.getCity1().getCityID()!=null){
			flightSql+=" and endCityID = "+flight.getCity1().getCityID();
		}
		
		if(flight!=null&&flight.getStarTime()!=null&&!"".equals(flight.getStarTime())){
			flightSql+=" and starTime like '%"+flight.getStarTime()+"%'";
		}
		
		flightSql+="  ORDER BY flightID desc ";
		
			// limit 第一个参数
			int start = (page.getCurPage() - 1) * page.getCurSize();
			// 拼接好的分页查询sql
			flightSql += " limit " + start + " , " + page.getCurSize();
		
		System.out.println("list:"+flightSql);
		
		java.util.List<Flight> ff = fs.selectAllFlight(flightSql);
		System.out.println("list:ff:"+ff);
		page.setfArr(ff);
		
		String flightSqlCount = "select * from flight";
		java.util.List<Flight> ffc = fs.selectAllFlight(flightSqlCount);
		page.setTotalSize(ffc.size());
        page.setTotalPage((int)Math.ceil(page.getTotalSize()*1.0/page.getCurSize()));	
		System.out.println("totalsize:"+page.getTotalSize());
		System.out.println("totalpage:"+page.getTotalPage());
        
		String citySql="select * from city";
		java.util.List<City> cl =cs.selectAllCIty(citySql);
		page.setcArr(cl);
		
		map.put("page", page);

		return "list";
	}
	
	@RequestMapping("/addController")
	public String addController(ModelMap map) {
		
		String citySql="select * from city";
		java.util.List<City> cl =cs.selectAllCIty(citySql);
		map.put("cl", cl);
		return "addJsp";
	}
	
	@RequestMapping("/add")
	public String add(Flight flight) {
		fs.add(flight);
		return "redirect:list";
	}

	@RequestMapping("/del")
	public String del(Integer flightID) {
		fs.del(flightID);
		return "redirect:list";
	}
	
	/**
	 * 批量删除
	 * @param checkedId
	 * @return
	 */
	@RequestMapping("/delAll")
	public String delAll(String checkedId) {
		System.out.println("delAll");
		System.out.println(checkedId);
		String[] split = checkedId.split(",");
		for (String string : split) {
			System.out.println(string);
			if(!"".equals(string)){
				fs.del(Integer.parseInt(string));
			}
			
		}
		return "redirect:list";
	}
	
	
}
