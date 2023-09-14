package com.ms.jun191spmvcmybatis.menu;

import java.util.List;

public interface MenuMapper {
	// insert,update,delete:int
	// select :resultType
	public abstract int reg(Menu m);
	public abstract List<Menu>get();
}
