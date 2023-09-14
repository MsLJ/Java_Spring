package com.ms.web2.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
//	create table sns_re(
//			sre_no number(4) primary key,
//			sre_sns_no number(3) not null,
//			sre_writer varchar2(10 char)not null,
//			sre_txt varchar2 (150 char)not null,
//			sre_date date not null,
//			constraint sns_reply
//			foreign key(sre_sns_no)references sns(sns_no)
//			on delete cascade,
//			constraint sns_reply_writer
//			foreign key(sre_writer) references web2_member(webm_id)
//			on delete cascade
//			);
private BigDecimal sre_no;
private BigDecimal sre_sns_no;
private String sre_writer;
private String sre_txt;
private Date sre_date;
public SNSReply() {
	// TODO Auto-generated constructor stub
}
public SNSReply(BigDecimal sre_no, BigDecimal sre_sns_no, String sre_writer, String sre_txt, Date sre_date) {
	super();
	this.sre_no = sre_no;
	this.sre_sns_no = sre_sns_no;
	this.sre_writer = sre_writer;
	this.sre_txt = sre_txt;
	this.sre_date = sre_date;
}
public BigDecimal getSre_no() {
	return sre_no;
}
public void setSre_no(BigDecimal sre_no) {
	this.sre_no = sre_no;
}
public BigDecimal getSre_sns_no() {
	return sre_sns_no;
}
public void setSre_sns_no(BigDecimal sre_sns_no) {
	this.sre_sns_no = sre_sns_no;
}
public String getSre_writer() {
	return sre_writer;
}
public void setSre_writer(String sre_writer) {
	this.sre_writer = sre_writer;
}
public String getSre_txt() {
	return sre_txt;
}
public void setSre_txt(String sre_txt) {
	this.sre_txt = sre_txt;
}
public Date getSre_date() {
	return sre_date;
}
public void setSre_date(Date sre_date) {
	this.sre_date = sre_date;
}


	
	
}
