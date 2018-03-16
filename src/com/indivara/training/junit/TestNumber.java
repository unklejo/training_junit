package com.indivara.training.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNumber {
	@Test
	public void testNumber() {
	JUnitExcercise test = new JUnitExcercise();
		assertEquals("10 is an even number", true, test.jUnitExercise(10));
	}
}
