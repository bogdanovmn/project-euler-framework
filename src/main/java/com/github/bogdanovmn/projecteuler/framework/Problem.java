package com.github.bogdanovmn.projecteuler.framework;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public abstract class Problem {
	protected final ProblemParameters parameters;
	private Long solution;
	private long solutionCalculationTimeInSeconds;
	private long iterations;

	public Problem(ProblemParameters parameters) {
		this.parameters = parameters;
	}

	public final long answer() {
		calculateSolution();
		return solution;
	}

	public final void printAnswer() {
		calculateSolution();
		System.out.printf("Func(%s) = %s%n", parameters, solution);
		System.out.printf("Time: %.3fs%n", solutionCalculationTimeInSeconds / 1000.0);
		if (iterations > 0) {
			System.out.printf(
				"Iterations: %s%n",
					NumberFormat.getNumberInstance(Locale.GERMAN)
						.format(iterations)
			);
		}
	}

	private synchronized void calculateSolution() {
		if (solution == null) {
			LocalTime now = LocalTime.now();
			solution = solution();
			solutionCalculationTimeInSeconds = ChronoUnit.MILLIS.between(now, LocalTime.now());
		}
	}

	protected abstract long solution();

	protected void incIterations() {
		iterations++;
	}
}
