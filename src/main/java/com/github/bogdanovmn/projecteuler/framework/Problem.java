package com.github.bogdanovmn.projecteuler.framework;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class Problem {
	protected final ProblemParameters parameters;
	private Long solution;
	private long solutionCalculationTimeInSeconds;

	public Problem(ProblemParameters parameters) {
		this.parameters = parameters;
	}

	public final long answer() {
		calulateSolution();
		return solution;
	}

	public final void printAnswer() {
		calulateSolution();
		System.out.printf("func(%s) = %s%n", parameters, solution);
		System.out.printf("Time: %d", solutionCalculationTimeInSeconds);
	}

	private synchronized void calulateSolution() {
		if (solution == null) {
			LocalTime now = LocalTime.now();
			solution = solution();
			solutionCalculationTimeInSeconds = ChronoUnit.SECONDS.between(now, LocalTime.now());
		}
	}

	protected abstract long solution();
}
