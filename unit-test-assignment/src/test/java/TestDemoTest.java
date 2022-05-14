import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

	private TestDemo testDemo;

	/*
	 * Set up of the TestDemo class object before each test.
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/*
	 * JUnit test to test parameters, or multiple possible scenarios of the add
	 * positive from the TestDemo class. feedback tells if the tests pass by the
	 * expected outcome occurring.
	 */
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	/*
	 * Arguments for the simulated tests and their expected outcomes.
	 */
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(0, 0, 0, true), 
				arguments(1, 1, 2, false), 
				arguments(1, -1, 0, true),
				arguments(-1, 1, 0, true), 
				arguments(-1, -1, -2, true), 
				arguments(3, 3, 6, false));

	}
/*
 * JUnit test for the squaring random int method, but must be done in 
 * a mock result because we can't make an expectation of the result without knowing 
 * what the number will be. the mock allows control of seeing the method works.
 */
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
