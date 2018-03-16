package com.indivara.training.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertionTestOnJUnit {
	@Test
	public void assertionTestOnJUnit() {
		// data
		String satu = new String("JERU");
		String dua = new String("JERU");
		String tiga = null;
		String empat = "JERU";
		String lima = "JERU";
		String enam = null;
		int numb1 = 23;
		int numb2 = 12;
		String[] expectedArray = { "Java", "Enterprise", "University" };
		String[] result = { "Java", "Enterprise", "University" };
		// Testing
		// Checking two Objects are equals
		assertEquals(satu, dua);
		// Checking a condition is true
		assertTrue(numb1 > numb2);
		// Checking a condition is false
		assertFalse(numb1 < numb2);
		// Checking an Object is not null
		assertNotNull(satu);
		// Checking an Objecy is null
		assertNull(tiga);
		// Checking two Objects references point to the same Object
		assertSame(empat, lima);
		assertSame(enam, tiga);
		// Checking two Objects references not point to the same Object
		assertNotSame(satu, tiga);
		// Checking two arrays are equals
		assertArrayEquals(expectedArray, result);
	}
}
