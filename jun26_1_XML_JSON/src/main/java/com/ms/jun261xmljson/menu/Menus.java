package com.ms.jun261xmljson.menu;

import java.util.List;


public class Menus {
	//데이터들(테이블)
private List<Menu>menus;
public Menus() {
	// TODO Auto-generated constructor stub
}
public Menus(List<Menu> menus) {
	super();
	this.menus = menus;
}
public List<Menu> getMenus() {
	return menus;
}
public void setMenus(List<Menu> menus) {
	this.menus = menus;
}



}
