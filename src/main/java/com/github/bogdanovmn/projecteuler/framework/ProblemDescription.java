package com.github.bogdanovmn.projecteuler.framework;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ProblemDescription {
	private final String[] inputArgs;

	public ProblemDescription(String[] inputArgs) {
		this.inputArgs = inputArgs;
	}

	private int number() {
		return Integer.parseInt(inputArgs[0]);
	}

	private String[] parameters() {
		return inputArgs;
	}

	public Problem problem() {
		Set<Class<?>> annotated = new Reflections("com.github").getTypesAnnotatedWith(ProjectEulerProblem.class);
		Class<?> aClass = annotated.stream()
			.filter(cl ->
				cl.getAnnotation(ProjectEulerProblem.class).number() == number()
			)
			.filter(
				cl -> cl.getSuperclass().equals(Problem.class)
			)
			.findFirst().orElseThrow(
				() -> new IllegalArgumentException(
					String.format("Can't find any class for the problem #%d", number())
				)
			);
		try {
			return (Problem) aClass.getConstructor(ProblemParameters.class).newInstance(new ProblemParameters(inputArgs));
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			throw new IllegalStateException(
				String.format(
					"Can't invoke a constructor with '%s' arg",
					ProblemParameters.class.getName()
				)
			);
		}
	}
}
