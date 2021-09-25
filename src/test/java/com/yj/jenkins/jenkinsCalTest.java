package com.yj.jenkins;

import static org.junit.Assert.*;

import org.junit.Test;

public class jenkinsCalTest {

	@Test
	public void addtest() {
		jenkinsCalculator mycalc=new jenkinsCalculator();
		assertEquals(10,mycalc.addNumbers(5, 5));
	}
	@Test
	public void subtracttest() {
		jenkinsCalculator mycalc=new jenkinsCalculator();
		assertEquals(5,mycalc.subtractNumbers(10, 5));
	}
}
