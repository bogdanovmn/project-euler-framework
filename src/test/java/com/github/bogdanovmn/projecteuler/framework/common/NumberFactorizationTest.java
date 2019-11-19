package com.github.bogdanovmn.projecteuler.framework.common;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class NumberFactorizationTest {
	@Test
	public void factorization() {
		assertEquals(
			"Case 1",
			new HashMap<Long, Integer>() {{
				put((long) 2, 1);
				put((long) 3, 1);
			}},
			NumberFactorization.of(2 * 3).components()
		);

		assertEquals(
			"Case 2",
			new HashMap<Long, Integer>() {{
				put((long) 2, 2);
				put((long) 3, 3);
			}},
			NumberFactorization.of(2*2 * 3*3*3).components()
		);

		assertEquals(
			"Case 3",
			new HashMap<Long, Integer>() {{
				put((long) 2, 1);
			}},
			NumberFactorization.of(2).components()
		);

		assertEquals(
			"Case 4",
			new HashMap<Long, Integer>() {{
				put((long) 3, 1);
			}},
			NumberFactorization.of(3).components()
		);
	}

	@Test
	public void number() {
		assertEquals(
			28,
			NumberFactorization.of(28).number()
		);
	}

	@Test
	public void isSqrtable() {
		assertTrue(
			NumberFactorization.of(2*2 * 3*3).isSqrtable()
		);

		assertFalse(
			NumberFactorization.of(2*2 * 3*3 * 5).isSqrtable()
		);
	}

	@Test
	public void isRootableOf() {
		assertTrue(
			NumberFactorization.of(2*2*2*2*2*2 * 3*3*3).isRootableOf(3)
		);

		assertFalse(
			NumberFactorization.of(2*2 * 3*3 * 5).isRootableOf(3)
		);
	}

	@Test
	public void power() {
		assertEquals(
			"20^3 is 8000",
			8000,
			NumberFactorization.of(5*4).pow(3).number()
		);
	}

	@Test
	public void div() {
		assertEquals(
			"150/5 is 30",
			30,
			NumberFactorization.of(150)
				.div(
					NumberFactorization.of(5)
				).number()
		);
	}

	@Test
	public void mul() {
		assertEquals(
			"36*6 is 216",
			216,
			NumberFactorization.of(36)
				.mul(NumberFactorization.of(6))
				.number()
		);
	}

	@Test
	public void isPrime_2() {
		assertTrue(
			"2 is prime",
			NumberFactorization.of(2).isPrime()
		);
	}
	@Test
	public void isPrime_3() {
		assertTrue(
			"3 is prime",
			NumberFactorization.of(3).isPrime()
		);
	}
	@Test
	public void isPrime_941() {
		assertTrue(
			"941 is prime",
			NumberFactorization.of(941).isPrime()
		);
	}
	@Test
	public void isPrime_15() {
		assertFalse(
			"15 is not prime",
			NumberFactorization.of(15).isPrime()
		);
	}
	@Test
	public void isPrime_16() {
		assertFalse(
			"16 is not prime",
			NumberFactorization.of(16).isPrime()
		);
	}
}