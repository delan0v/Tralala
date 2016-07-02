package com.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by pkaczmar on 2016-07-02.
 */
public class DatabaseFiledIteratorTest {

	@Test
	public void dajListePolTest() throws ClassNotFoundException {
		DatabaseFiledIterator databaseFiledIterator = new DatabaseFiledIterator();

		Field[] fields = databaseFiledIterator.dajListePol("com.example.database.model.Clients");
		Assert.assertNotNull(fields);

		Field[] fields2 = databaseFiledIterator.dajListePol("com.example.vaadin.indyvidual.IndividualAccount");
		Assert.assertNotNull(fields2);
	}

	// Testuje czy rzuca taki wyjątek w określonej sytuacji
	@Test(expected = ClassNotFoundException.class)
	public void dajListePolRzucWyjatkiemTest() throws ClassNotFoundException {
		DatabaseFiledIterator databaseFiledIterator = new DatabaseFiledIterator();
		Field[] fields = databaseFiledIterator.dajListePol("");

		Assert.assertNull(fields);
	}
}
