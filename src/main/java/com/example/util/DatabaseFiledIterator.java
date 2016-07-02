package com.example.util;

import java.lang.reflect.Field;

/**
 * Created by pkaczmar on 2016-07-02.
 */
public class DatabaseFiledIterator {

	// 1. podajemy nazwę klasy
	public Field[] dajListePol(String nazwaKlasy) throws ClassNotFoundException {
		Field[] fields = null;
		try {
			// pobieramy tę klasę po jej nazie
			Class clazz = Class.forName(nazwaKlasy);
			// pobieramy pola tej klasy
			fields = clazz.getDeclaredFields();
			// wyśwetlamy wszystkie pola tej klasy
			for (Field f : fields) {
				System.out.println(f.toString());
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
		return fields;
	}
}
