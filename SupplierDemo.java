import javax.naming.ServiceUnavailableException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        /* Supplier only return not take anything this is a
            Functional interface and have get() abstract method
         */

        Supplier<String> sup = () -> "Hello World";
        System.out.println(sup.get()); // only return string that i try to return in supplier

        /*Combine use of pedicate,function, consumer, supplier */

        Predicate<Integer> predicate =  x -> x % 2 == 0 ;
        Function<Integer, Integer> function =  x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }
    }
}
