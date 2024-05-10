package recursion;

import java.util.Map;

public interface IRecursion
{
    Long factorialUsingIteration(int num);

    Long factorialUsingMemoization(int i);

    Long helperFactorialMethod(int i, Map<Integer, Long> map);

    Double factorialUsingArray(int i);

    Double simpleRecursiveFactorial(int i) throws IllegalArgumentException;
}
