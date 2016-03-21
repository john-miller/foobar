package com.miller.google.foobar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZombitAntidoteTest {
	
	@Test
	public void case1() {
		int[][] meetings = new int[][] {
			new int[] {0,1},
			new int[] {1,2},
			new int[] {2,3},
			new int[] {3,5},
			new int[] {4,5}
		};
		assertEquals(4, ZombitAntidote.answer(meetings));
	}
	
	@Test
	public void case2() {
		int[][] meetings = new int[][] {
			new int[] {0,1000000},
			new int[] {42,43},
			new int[] {0,1000000},
			new int[] {42,43},
		};
		assertEquals(1, ZombitAntidote.answer(meetings));
	}

}
