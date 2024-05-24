package udemy_course_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise
{

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(middle(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(middleUsingArrayMethod(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1,1,3,1,5})));
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sum = calculateArrayDiagonalElementsSum(matrix);
        System.out.println("Sum of diagonal elements: " + sum); // Output should be 25

    }
    public static int[] middle(int[] array)
    {
        if(array==null) return null;
        // edhe case 
        int len= array.length;
        if(len <=2) return null;
        
        int[] result = new int[len-2];
        System.arraycopy(array, 1, result, 0, len - 1 - 1);
        return result;
    }
    public static int[] middleUsingArrayMethod(int[] array)
    {
        if(array==null) return null;
        // edhe case
        int len= array.length;
        if(len <=2) return null;
        return Arrays.copyOfRange(array,1,len-1);
    }
    public static int[] removeDuplicates(int[] arr)
    {
        Set<Integer> set = new HashSet<>();

        for(int num : arr)
        {
            set.add(num);
        }
        int[] result = new int[set.size()];

        var iterator = set.iterator();
        int index=0;
        while (iterator.hasNext())
        {
            result[index]= iterator.next();
            ++index;
        }
        return result;
    }

    public static int calculateArrayDiagonalElementsSum(int[][] arr)
    {
        if(arr==null || arr.length==0) return 0;
        if(arr.length==1) return arr[0][0];
        int result=0;
        for (int i = 0; i < arr.length; i++)
        {
            result+=arr[i][i];
            if(i!= arr.length-1-i)
            {
                result+=arr[i][arr.length-1-i];
            }
        }
        return result;
    }


}