package com.miller.google.foobar;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuardEscapeTest {
	
	@Test
	public void case1() {
		assertEquals(9, GuardEscape.answer(4554));
	}
	
	@Test
	public void case2() {
		assertEquals(1, GuardEscape.answer(1234));
	}

}
