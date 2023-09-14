package com.ms.jun261xmljson.menu;

import java.math.BigDecimal;

public class MenuPage {
	private BigDecimal start;
	private BigDecimal end;
	public MenuPage() {
		// TODO Auto-generated constructor stub
	}
	public MenuPage(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
	
	

}
