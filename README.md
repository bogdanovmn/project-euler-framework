
# How to use it

## 1. Get the dependency
```xml
<dependency>
    <groupId>com.github.bogdanovmn.projecteuler.framework</groupId>
    <artifactId>project-euler-framework</artifactId>
    <version>0.4.0</version>
</dependency>

...

<repositories>
    <repository>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <id>my</id>
        <name>bintray</name>
        <url>https://dl.bintray.com/bogdanovmn/maven-repo</url>
    </repository>
</repositories>
```

## 2. Create an entry point for all problems. It will be convenient to play with various input via console
```java
import com.github.bogdanovmn.projecteuler.framework.ProblemDescription;

public class App {
	public static void main(String[] args) {
		new ProblemDescription(args)
			.problem()
				.printAnswer();
	}
}
``` 

## 3. Implement a solution of the problem
```java
import com.github.bogdanovmn.projecteuler.framework.Problem;
import com.github.bogdanovmn.projecteuler.framework.ProblemParameters;
import com.github.bogdanovmn.projecteuler.framework.ProjectEulerProblem;

@ProjectEulerProblem(number = 1)
public class Problem1 extends Problem {
	public Problem1(ProblemParameters parameters) {
		super(parameters);
	}

	@Override
	public long solution() {
		long n = parameters.getLong(1);
		// censored by the site rules
		return 42;
	}
}
```

## 4. Implement tests for the problem
```java
public class Problem1Test {

	@Test
	public void testCase1() {
		assertEquals(
			2L,
			new ProblemDescription("1", "1000").problem().answer()
		);
	}
}
```

## 5. Play with the problem via console
```bash
$ java -jar target/euler.jar 1 100000000
func(100000000) = 2333333316666668
Time: 0s

$ java -jar target/euler.jar 1 1000000000
func(1000000000) = 233333333166666668
Time: 1s

$ java -jar target/euler.jar 1 100000000000
func(100000000000) = 9043580029263163052
Time: 186s
```
As you can guess, the first argument is a problem number. 
Next arguments are any input which could be used for solving a problem.
   