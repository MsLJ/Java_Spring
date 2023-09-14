package com.ms.web2.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSMsg {
	
//	create table sns(
//			sns_no number(3) primary key,
//			sns_writer varchar2(10 char)not null,
//			sns_txt varchar2(500 char) not null,
//			sns_date date not null,
//			constraint snss_writer
//			foreign key (sns_writer) references web2_member(webm_id)
//			on delete cascade
//			);
	
	private BigDecimal sns_no;
	private String sns_writer;
	private String sns_txt;
	private Date sns_date;
	private String webm_photo;
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}
	public SNSMsg(BigDecimal sns_no, String sns_writer, String sns_txt, Date sns_date, String webm_photo) {
		super();
		this.sns_no = sns_no;
		this.sns_writer = sns_writer;
		this.sns_txt = sns_txt;
		this.sns_date = sns_date;
		this.webm_photo = webm_photo;
	}
	public BigDecimal getSns_no() {
		return sns_no;
	}
	public void setSns_no(BigDecimal sns_no) {
		this.sns_no = sns_no;
	}
	public String getSns_writer() {
		return sns_writer;
	}
	public void setSns_writer(String sns_writer) {
		this.sns_writer = sns_writer;
	}
	public String getSns_txt() {
		return sns_txt;
	}
	public void setSns_txt(String sns_txt) {
		this.sns_txt = sns_txt;
	}
	public Date getSns_date() {
		return sns_date;
	}
	public void setSns_date(Date sns_date) {
		this.sns_date = sns_date;
	}
	public String getWebm_photo() {
		return webm_photo;
	}
	public void setWebm_photo(String webm_photo) {
		this.webm_photo = webm_photo;
	}
	
	

}
