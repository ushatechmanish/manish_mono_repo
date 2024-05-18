package udemy_course_questions;

import java.util.Arrays;

public class Exercise
{

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(middle(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(middleUsingArrayMethod(new int[]{1,2,3,4,5})));
    }
    public static int[] middle(int[] array)
    {
        if(array==null) return null;
        // edhe case 
        int len= array.length;
        if(len <=2) return null;
        
        int[] result = new int[len-2];
        for(int i=1 ; i<len-1; ++i)
        {
            result[i-1]=array[i];
        }
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

}