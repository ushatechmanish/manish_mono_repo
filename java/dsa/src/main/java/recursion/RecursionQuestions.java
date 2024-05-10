package recursion;

import util.PrintResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class RecursionQuestions implements IRecursion
{
    private static final BiConsumer<String, Object> printResult = new PrintResult();

    public static void main(String[] args) throws IllegalArgumentException
    {
        var obj = new RecursionQuestions();
        printResult.accept("Factorial of 5 by simple recursion is ", obj.simpleRecursiveFactorial(5));
        printResult.accept("Factorial of 10 by array method is ", obj.factorialUsingArray(10));
        printResult.accept("Factorial of 10 by Memoization using Map ", obj.factorialUsingMemoization(10));
        printResult.accept("Factorial of 11 by  iteration  ", obj.factorialUsingIteration(11));

    }

    @Override
    public Long factorialUsingIteration(int num)
    {
        if (num <= 1) return 1L;
        long result = 1L;
        for (int index = 2; index <= num; ++index)
        {
            result *= index;
        }
        return result;
    }

    @Override
    public Long factorialUsingMemoization(int i)
    {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        map.put(1, 1L);
        return helperFactorialMethod(i, map);
    }

    @Override
    public Long helperFactorialMethod(int i, Map<Integer, Long> map)
    {
        if (map.containsKey(i)) return map.get(i);
        Long result = i * helperFactorialMethod(i - 1, map);
        printResult.accept("The factorial of " + i, result);
        map.put(i, result);
        return result;
    }

    @Override
    public Double factorialUsingArray(int i)
    {
        double[] factorialArr = new double[i + 1];
        if (i >= 0) factorialArr[0] = 1;
        if (i >= 1) factorialArr[1] = 1;
        for (int index = 2; index <= i; ++index)
        {
            factorialArr[index] = index * factorialArr[index - 1];
        }
        printResult.accept("The factorial array is ", Arrays.toString(factorialArr));
        return factorialArr[i];
    }

    @Override
    public Double simpleRecursiveFactorial(int i) throws IllegalArgumentException
    {
        // base cases
        if (i < 0) throw new IllegalArgumentException("The number can not be less than 0 for factorial");

        if (i <= 1) return 1.0;

        return i * simpleRecursiveFactorial(i - 1);
    }

}
