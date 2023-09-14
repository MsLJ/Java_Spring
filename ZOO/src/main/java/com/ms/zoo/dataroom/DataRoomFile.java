package com.ms.zoo.dataroom;

import java.math.BigDecimal;
import java.util.Date;

public class DataRoomFile {
	private BigDecimal zd_no;
	private String zd_uploader;
	private String zd_title;
	private String zd_file;
	private String zd_category;
	private Date zd_date;

	public DataRoomFile() {
		// TODO Auto-generated constructor stub
	}

	public DataRoomFile(BigDecimal zd_no, String zd_uploader, String zd_title, String zd_file, String zd_category,
			Date zd_date) {
		super();
		this.zd_no = zd_no;
		this.zd_uploader = zd_uploader;
		this.zd_title = zd_title;
		this.zd_file = zd_file;
		this.zd_category = zd_category;
		this.zd_date = zd_date;
	}

	public BigDecimal getZd_no() {
		return zd_no;
	}

	public void setZd_no(BigDecimal zd_no) {
		this.zd_no = zd_no;
	}

	public String getZd_uploader() {
		return zd_uploader;
	}

	public void setZd_uploader(String zd_uploader) {
		this.zd_uploader = zd_uploader;
	}

	public String getZd_title() {
		return zd_title;
	}

	public void setZd_title(String zd_title) {
		this.zd_title = zd_title;
	}

	public String getZd_file() {
		return zd_file;
	}

	public void setZd_file(String zd_file) {
		this.zd_file = zd_file;
	}

	public String getZd_category() {
		return zd_category;
	}

	public void setZd_category(String zd_category) {
		this.zd_category = zd_category;
	}

	public Date getZd_date() {
		return zd_date;
	}

	public void setZd_date(Date zd_date) {
		this.zd_date = zd_date;
	}

}
