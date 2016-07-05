package com.example.util;

/**
 * Created by pkaczmar on 2016-07-02.
 */
// TODO Zastosować Pattern - wzorzec projektowy - Singletone
public class SessionUtil {

	private static Integer loggedUserId;
	private static String loggedUserName;

	public static void setLoggedUser(Integer id, String username) {
		loggedUserId = id;
		loggedUserName = username;
	}

	public static Integer getLoggedUserId() {
		return loggedUserId;
	}

	public static String getLoggedUserName() {
		return loggedUserName;
	}
}
