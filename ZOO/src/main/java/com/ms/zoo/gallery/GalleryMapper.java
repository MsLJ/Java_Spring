package com.ms.zoo.gallery;

import java.util.List;

public interface GalleryMapper {
	public abstract int upload(Gallery gr);
	public abstract List<Gallery>get(Gallery gr);

}
