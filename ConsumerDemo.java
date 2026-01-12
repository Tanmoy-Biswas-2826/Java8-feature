import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        /*
            Consumer is a functional interface, take one input and returns nothing.
            Its mainly used when you want to perform soe operation on an object.

            void accept(T t);
        */

        // Consumer

        Consumer<Integer> print = x -> System.out.println("Print Input :: "+ x);
        print.accept(10);

        List<Integer> lis = Arrays.asList(1,2,3,4,5);

        // apply consumer for create custom for each loop with list of data
        Consumer<List<Integer>> listConsumer =  x -> {
            for (Integer i : x)
                System.out.println(i);
        };

        listConsumer.accept(lis);

    }
}
