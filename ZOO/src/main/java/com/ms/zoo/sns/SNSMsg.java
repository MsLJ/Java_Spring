package com.ms.zoo.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSMsg {
	private BigDecimal zs_no;
	private String zs_writer;
	private String zs_txt;
	private Date zs_date;
	private String zs_color;
	private String zm_photo;
	private List<SNSReply>zs_re;
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}
	public SNSMsg(BigDecimal zs_no, String zs_writer, String zs_txt, Date zs_date, String zs_color, String zm_photo,
			List<SNSReply> zs_re) {
		super();
		this.zs_no = zs_no;
		this.zs_writer = zs_writer;
		this.zs_txt = zs_txt;
		this.zs_date = zs_date;
		this.zs_color = zs_color;
		this.zm_photo = zm_photo;
		this.zs_re = zs_re;
	}
	public BigDecimal getZs_no() {
		return zs_no;
	}
	public void setZs_no(BigDecimal zs_no) {
		this.zs_no = zs_no;
	}
	public String getZs_writer() {
		return zs_writer;
	}
	public void setZs_writer(String zs_writer) {
		this.zs_writer = zs_writer;
	}
	public String getZs_txt() {
		return zs_txt;
	}
	public void setZs_txt(String zs_txt) {
		this.zs_txt = zs_txt;
	}
	public Date getZs_date() {
		return zs_date;
	}
	public void setZs_date(Date zs_date) {
		this.zs_date = zs_date;
	}
	public String getZs_color() {
		return zs_color;
	}
	public void setZs_color(String zs_color) {
		this.zs_color = zs_color;
	}
	public String getZm_photo() {
		return zm_photo;
	}
	public void setZm_photo(String zm_photo) {
		this.zm_photo = zm_photo;
	}
	public List<SNSReply> getZs_re() {
		return zs_re;
	}
	public void setZs_re(List<SNSReply> zs_re) {
		this.zs_re = zs_re;
	}
	
	

}
