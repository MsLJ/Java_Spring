package com.ms.jun261xmljson.menu;

import java.util.List;

public interface MenuMapper {
	public abstract List<Menu>get(MenuPage mp);
	public abstract int getpage();

}
