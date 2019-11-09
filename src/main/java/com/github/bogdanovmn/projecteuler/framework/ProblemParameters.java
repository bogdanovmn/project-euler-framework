package com.github.bogdanovmn.projecteuler.framework;

public class ProblemParameters {
	private final String[] rawParameters;

	public ProblemParameters(String[] rawParameters) {
		this.rawParameters = rawParameters;
	}

	public long getLong(int index) {
		if (rawParameters.length < index) {
			throw new IllegalArgumentException(
				String.format(
					"Can't find any parameter with index %d. There are only %d parameters: [%s]",
						index, rawParameters.length, toString()
				)
			);
		}
		return Long.parseLong(
			rawParameters[index - 1]
		);
	}

	@Override
	public String toString() {
		return String.join(",", rawParameters);
	}
}
