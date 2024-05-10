package recursion;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursionQuestionsTest {

    private RecursionQuestions recursionQuestions;

    @BeforeEach
    void setUp() {
        recursionQuestions = new RecursionQuestions();
    }

    @Test
    void factorialUsingIteration() {
        assertEquals(1, recursionQuestions.factorialUsingIteration(0));
        assertEquals(1, recursionQuestions.factorialUsingIteration(1));
        assertEquals(120, recursionQuestions.factorialUsingIteration(5));
        assertEquals(3628800, recursionQuestions.factorialUsingIteration(10));
    }

    @Test
    void factorialUsingMemoization() {
        assertEquals(1, recursionQuestions.factorialUsingMemoization(0));
        assertEquals(1, recursionQuestions.factorialUsingMemoization(1));
        assertEquals(120, recursionQuestions.factorialUsingMemoization(5));
        assertEquals(3628800, recursionQuestions.factorialUsingMemoization(10));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void factorialUsingArray(int num) {
        double expected = num == 0 || num == 1 ? 1 : num * factorial(num - 1);
        assertEquals(expected, recursionQuestions.factorialUsingArray(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void simpleRecursiveFactorial(int num) {
        double expected = num == 0 || num == 1 ? 1 : num * factorial(num - 1);
        assertEquals(expected, recursionQuestions.simpleRecursiveFactorial(num));
    }

    private double factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

}
