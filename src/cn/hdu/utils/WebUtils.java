package cn.hdu.utils;

import java.util.UUID;

public class WebUtils {
	
	public static String makeId(){
		return UUID.randomUUID().toString();
	}
	
}
