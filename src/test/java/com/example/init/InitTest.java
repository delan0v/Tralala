package com.example.init;

import org.junit.Test;

/**
 * Created by pkaczmar on 2016-07-15.
 */
public class InitTest extends BaseInitTest {

	private static final String STATYCZNY_STRING = "STATYCZNY STRING";

	private int licznik = 0;

	static {
		System.out.println(STATYCZNY_STRING);
	}

	{
		System.out.println("Wywołanie poza konstruktorem i inicjalizacją statyczną");
	}

	public InitTest() {
		super();
		licznik++;
		System.out.println(licznik);
		System.out.println("InitTest konstruktor");
		initMethod();
	}

	private void initMethod() {
		System.out.println("initMethod");
	}

	@Test
	public void initTest() {
		System.out.println("################### Rozpoczynam test ###################");
		InitTest initTest = new InitTest();
	}

}
