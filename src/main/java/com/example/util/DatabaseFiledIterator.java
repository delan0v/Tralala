package com.example.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

			Method method = clazz.getMethod("");
			// wyśwetlamy wszystkie pola tej klasy
			method.setAccessible(true);
			method.invoke(fields);
			for (Field f : fields) {
				System.out.println(f.toString());
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return fields;
	}
}
