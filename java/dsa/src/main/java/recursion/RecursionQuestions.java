package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class RecursionQuestions
{
    private static final BiConsumer<String,Object> printResult = (String message, Object object)->
            System.out.println(message+":"+object);
    public static void main(String[] args) throws Exception
    {
            printResult.accept("Factorial of 5 by simple recursion is ", simpleRecursiveFactorial(5));
            printResult.accept("Factorial of 10 by array method is ", factorialUsingArray(10));
            printResult.accept("Factorial of 10 by Memoization using Map ", factorialUsingMemoization(10));
            printResult.accept("Factorial of 11 by  iteration  ", factorialUsingIteration(11));

    }

    private static Long factorialUsingIteration(int num)
    {
        if(num<=1) return 1L;
        long result = 1L;
        for(int index=2;index<=num;++index )
        {
            result*=index;
        }
        return result;
    }

    private static Long factorialUsingMemoization(int i)
    {
        Map<Integer,Long> map = new HashMap<>();
        map.put(0,1L);
        map.put(1,1L);
        return helperFactorialMethod(i,map);
    }

    private static Long helperFactorialMethod(int i, Map<Integer, Long> map)
    {
        if(map.containsKey(i)) return map.get(i);
        Long result= i*helperFactorialMethod(i-1,map);
        printResult.accept("The factorial of "+i,result);
        map.put(i,result);
        return result;
    }


    private static Double factorialUsingArray(int i)
    {
        double [] factorialArr = new double [i+1];
        factorialArr[0]=1;factorialArr[1]=1;
        for(int index=2;index<=i;++index)
        {
            factorialArr[index]=index*factorialArr[index-1];
        }
        printResult.accept("The factorial array is ", Arrays.toString(factorialArr));
        return factorialArr[i];
    }

    private static Double simpleRecursiveFactorial(int i) throws IllegalArgumentException
    {
        // base cases
        if(i<0) throw new IllegalArgumentException("The number can not be less than 0 for factorial");

        if(i<=1) return 1.0;

        return i* simpleRecursiveFactorial(i-1);
    }

}
