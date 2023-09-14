package com.ms.zoo.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class Gallery {
	private BigDecimal zg_no;
	private String zg_uploader;
	private String zg_title;
	private String zg_photo;
	private Date zg_date;
	public Gallery() {
		// TODO Auto-generated constructor stub
	}
	public Gallery(BigDecimal zg_no, String zg_uploader, String zg_title, String zg_photo, Date zg_date) {
		super();
		this.zg_no = zg_no;
		this.zg_uploader = zg_uploader;
		this.zg_title = zg_title;
		this.zg_photo = zg_photo;
		this.zg_date = zg_date;
	}
	public BigDecimal getZg_no() {
		return zg_no;
	}
	public void setZg_no(BigDecimal zg_no) {
		this.zg_no = zg_no;
	}
	public String getZg_uploader() {
		return zg_uploader;
	}
	public void setZg_uploader(String zg_uploader) {
		this.zg_uploader = zg_uploader;
	}
	public String getZg_title() {
		return zg_title;
	}
	public void setZg_title(String zg_title) {
		this.zg_title = zg_title;
	}
	public String getZg_photo() {
		return zg_photo;
	}
	public void setZg_photo(String zg_photo) {
		this.zg_photo = zg_photo;
	}
	public Date getZg_date() {
		return zg_date;
	}
	public void setZg_date(Date zg_date) {
		this.zg_date = zg_date;
	}
	
	
	
	
//	create table zoo_gallery(
//			zg_no number(3) primary key,
//			zg_uploader varchar2(10 char)not null,
//			zg_title varchar2 (300 char)not null,
//			zg_photo varchar2(100 char)not null,
//			zg_date date not null,
//			constraint gallery_uploader
//			foreign key (zg_uploader) references zoo_member(zm_id)
//			on delete cascade
//
//			);

}
