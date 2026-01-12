import java.lang.invoke.CallSite;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        /*
            (parameters) -> { body }
            () -> System.out.println("Hello");
            (a, b) -> a + b;
            x -> x * x;
        */

        //Before java 8
        Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running...");
                }
        };

        //Java 8 use
        Runnable r = ()-> System.out.println("Running...");

        //Lambda with parameter
        Calc c = (a,b) -> a+b;
        System.out.println(c.add(5,3));

        //Lambda with Collection
        List<String> list = List.of("Java", "Spring", "Angular");
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println); //Use Method reference

    }
}

@FunctionalInterface
interface Calc{
    int add (int a, int b);
}
