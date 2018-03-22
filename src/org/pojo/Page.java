package org.pojo;

import java.util.ArrayList;
import java.util.List;

public class Page {
	
	private Integer curPage;
	private Integer totalPage;
	private Integer curSize;
	private Integer totalSize;
	
	private List<Flight> fArr = new ArrayList<Flight>();
	private List<City> cArr = new ArrayList<City>();
	
	public Page() {
		curPage=1;
		curSize=10;
	}

	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", totalPage=" + totalPage + ", curSize=" + curSize + ", totalSize="
				+ totalSize + ", fArr=" + fArr + ", cArr=" + cArr + "]";
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurSize() {
		return curSize;
	}

	public void setCurSize(Integer curSize) {
		this.curSize = curSize;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public List<Flight> getfArr() {
		return fArr;
	}

	public void setfArr(List<Flight> fArr) {
		this.fArr = fArr;
	}

	public List<City> getcArr() {
		return cArr;
	}

	public void setcArr(List<City> cArr) {
		this.cArr = cArr;
	}
	
	

}
