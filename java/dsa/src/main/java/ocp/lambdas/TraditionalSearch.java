package ocp.lambdas;

import java.util.Arrays;
import java.util.List;

public class TraditionalSearch
{
    public static void main(String[] args)
    {
        var animals = Arrays.asList(
          new Animal("fish",false,true),
          new Animal("kangaroo",true,false),
          new Animal("rabbit",true,false),
          new Animal("turtle",false,true)
        );
        print(animals,new CheckIfHopper());
    }

    private static void print(List<Animal> animals, CheckTrait checkIfHopper)
    {
        for (var animal : animals)
        {
            if(checkIfHopper.test(animal))
            {
                System.out.println(animal);
            }
        }
    }
}
