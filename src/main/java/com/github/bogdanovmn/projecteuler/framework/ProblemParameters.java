package com.github.bogdanovmn.projecteuler.framework;

public class ProblemParameters {
	private final String[] rawParameters;

	public ProblemParameters(String[] rawParameters) {
		this.rawParameters = rawParameters;
	}

	public Integer getInt(int index) {
		return Integer.parseInt(
			rawParameters[index - 1]
		);
	}
}
