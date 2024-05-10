package util;

import java.util.function.BiConsumer;

public class PrintResult implements BiConsumer<String, Object>
{

    @Override
    public void accept(String message, Object object)
    {
                System.out.println(message+":"+object);
    }
}
