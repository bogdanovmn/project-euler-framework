package com.github.bogdanovmn.projecteuler.framework;

abstract class Problem {
	protected final ProblemParameters parameters;

	public Problem(ProblemParameters parameters) {
		this.parameters = parameters;
	}

	public abstract String answer();
}
