package com.github.bogdanovmn.projecteuler.framework;

@ProjectEulerProblem(number = 123)
class Problem123 extends Problem {
	public Problem123(ProblemParameters parameters) {
		super(parameters);
	}

	@Override
	public String answer() {
		return String.valueOf(
			parameters.getInt(1) * 10
		);
	}
}
