package com.ms.zoo.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {

	private BigDecimal zsr_no;
	private BigDecimal zsr_zs_no;
	private String zsr_writer;
	private String zsr_txt;
	private Date zsr_date;

	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(BigDecimal zsr_no, BigDecimal zsr_zs_no, String zsr_writer, String zsr_txt, Date zsr_date) {
		super();
		this.zsr_no = zsr_no;
		this.zsr_zs_no = zsr_zs_no;
		this.zsr_writer = zsr_writer;
		this.zsr_txt = zsr_txt;
		this.zsr_date = zsr_date;
	}

	public BigDecimal getZsr_no() {
		return zsr_no;
	}

	public void setZsr_no(BigDecimal zsr_no) {
		this.zsr_no = zsr_no;
	}

	public BigDecimal getZsr_zs_no() {
		return zsr_zs_no;
	}

	public void setZsr_zs_no(BigDecimal zsr_zs_no) {
		this.zsr_zs_no = zsr_zs_no;
	}

	public String getZsr_writer() {
		return zsr_writer;
	}

	public void setZsr_writer(String zsr_writer) {
		this.zsr_writer = zsr_writer;
	}

	public String getZsr_txt() {
		return zsr_txt;
	}

	public void setZsr_txt(String zsr_txt) {
		this.zsr_txt = zsr_txt;
	}

	public Date getZsr_date() {
		return zsr_date;
	}

	public void setZsr_date(Date zsr_date) {
		this.zsr_date = zsr_date;
	}

}
