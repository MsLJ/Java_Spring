package com.ms.zoo.member;

import java.util.List;



//굳이 하지않아도 될 작업 그냥 return을 zoomember로 받아도 잘됌.
public class zooMembers {
	private List<ZooMember>zoomember;
	public zooMembers() {
		// TODO Auto-generated constructor stub
	}
	public zooMembers(List<ZooMember> zoomember) {
		super();
		this.zoomember = zoomember;
	}
	public List<ZooMember> getZoomember() {
		return zoomember;
	}
	public void setZoomember(List<ZooMember> zoomember) {
		this.zoomember = zoomember;
	}
	
	

}
