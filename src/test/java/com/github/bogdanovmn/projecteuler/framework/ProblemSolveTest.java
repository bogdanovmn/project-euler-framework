package com.github.bogdanovmn.projecteuler.framework;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProblemSolveTest {

	@Test
	public void solution() {
		ProblemDescription problemDescription = new ProblemDescription("123", "10_000");
		assertThat(
			problemDescription.problem().answer(),
			is(90000L)
		);
	}
}
