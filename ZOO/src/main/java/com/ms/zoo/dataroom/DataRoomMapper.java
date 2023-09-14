package com.ms.zoo.dataroom;

import java.util.List;


public interface DataRoomMapper {
	public abstract int delete(DataRoomFile drf);
	
	public abstract String getfile(DataRoomFile drf);
	
	public abstract List<DataRoomFile> getdata(DataRoomFile drf);

	public abstract int upload(DataRoomFile drf);

}
