package com.star.sud.zip.dto;

import java.util.LinkedHashMap;

public class UserMapUtil {

	private static LinkedHashMap<String, UserDetail> userMap = new LinkedHashMap<String, UserDetail>();

	/**
	 * @return the userMap
	 */
	public LinkedHashMap<String, UserDetail> getUserMap() {
		return userMap;
	}

	/**
	 * @param userMap the userMap to set
	 */
	public void setUserMap(LinkedHashMap<String, UserDetail> userMap) {
		UserMapUtil.userMap = userMap;
	}

	public static void setMapDetails(UserDetail userDetail) {
		userMap.put(String.valueOf(System.nanoTime()), userDetail);
	}

	public static LinkedHashMap<String, UserDetail> getMapDetails() {
		return userMap;
	}

}
