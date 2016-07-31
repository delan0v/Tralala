package com.example.init;

/**
 * Created by pkaczmar on 2016-07-15.
 */
public class BaseInitTest {

	private static final String BASE_STATYCZNY_STRING = "BASE STATYCZNY STRING";

	static {
		System.out.println(BASE_STATYCZNY_STRING);
	}

	public BaseInitTest() {
		System.out.println("BaseInitTest");
	}
}
