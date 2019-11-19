package com.github.bogdanovmn.projecteuler.framework.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NumberFactorization {
	private Map<Long, Integer> components;

	public NumberFactorization(Map<Long, Integer> components) {
		this.components = components;
	}

	public static NumberFactorization of(long number) {
		Map<Long, Integer> components = new HashMap<>();

		long currentNumber = number;
		long numberSqrt =(long) Math.ceil(Math.sqrt(number)) + 1;
		for (long i = 2; i <= numberSqrt; i++) {
			boolean sameNumber = true;
			int power = 0;

			while (sameNumber) {
				long devider = (long) Math.pow(i, ++power);
				if (currentNumber % devider != 0) {
					sameNumber = false;
					if (devider > i) {
						currentNumber = currentNumber / (long) Math.pow(i, power - 1);
						components.put(i, power - 1);
					}
				}
			}
		}
		components.put(currentNumber, 1);
		components.remove(1L);

		return new NumberFactorization(components);
	}

	public Collection<Integer> powers() {
		return components.values();
	}

	public NumberFactorization div(NumberFactorization devider) {
		Map<Long, Integer> result = new HashMap<>(components);
		for (Map.Entry<Long, Integer> entry : devider.components.entrySet()) {
			if (null == result.computeIfPresent(entry.getKey(), (k, v) -> v - entry.getValue())) {
				throw new ArithmeticException("fractional result");
			}
		}
		return new NumberFactorization(result);
	}

	public NumberFactorization mul(NumberFactorization multiplier) {
		Map<Long, Integer> result = new HashMap<>(components);
		for (Map.Entry<Long, Integer> entry : multiplier.components.entrySet()) {
			result.compute(entry.getKey(), (k, v) -> v == null ? entry.getValue() : v + entry.getValue());
		}
		return new NumberFactorization(result);
	}

	public NumberFactorization pow(int powValue) {
		Map<Long, Integer> result = new HashMap<>(components);
		for (Long key : result.keySet()) {
			result.compute(key, (k, v) -> v * powValue);
		}
		return new NumberFactorization(result);
	}

	public boolean isSqrtable() {
		return isRootableOf(2);
	}

	public boolean isRootableOf(int power) {
		return components.values().stream()
			.noneMatch(x -> x % power != 0);
	}

	public HashMap<Long, Integer> components() {
		return new HashMap<>(components);
	}

	public long number() {
		double result = 1;
		for (Map.Entry<Long, Integer> entry : components.entrySet()) {
			result *= Math.pow(entry.getKey(), entry.getValue());
		}
		return (long)result;
	}

	public boolean isPrime() {
		return components.size() == 1 && components.values().stream().mapToInt(x -> x).sum() == 1;
	}
}
