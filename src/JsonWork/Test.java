package JsonWork;

import com.google.gson.Gson;

public class Test
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        System.out.println(gson.toJson("Hello World!") );
    }
}