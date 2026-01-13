import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.function.*;

public class FunctionDemo {
    public static void main(String[] args) {
        /* Function a functional Inter face there have one abstract method that call apply()
            -> Take one input and Return one output
            -- Syntax
                Function<InputType, ReturnType>
        */

        Function<Integer, Integer> doubleet = x -> 2 * x;
        System.out.println("Apply function :: "+ doubleet.apply(10));

        //Use multiple function use andThen

        Function<Integer, Integer> thriplet = x -> x * 3;

        /* at first apply doublet means 10 * 2 = 20 and then apply tripelet on that mens 20 * 3 = 60*/
        System.out.println(doubleet.andThen(thriplet).apply(10));

        /* Use "COMPOSE" so at first apply insider and apply outsider function means
        * at first apply triplet  10 * 3 =30 and then apply doublet on that means 30 * 2 =60 */
        System.out.println(doubleet.compose(thriplet).apply(10));

        /* Use identity that return same thing that i pass */
        Function<Integer, Integer> identity = Function.identity();
        Integer res2 = identity.apply(5);
        System.out.println(res2); // Return same thing that i pass

        /* BiFunction */

        BiFunction<String,String,Integer> biFunction = (x,y) -> (x+y).length();
        System.out.println(biFunction.apply("Hello","World")); // return combine lenght of this two string.

        /* UnaryOperator and BinaryOperator */
        UnaryOperator<Integer> a = x -> 2 * x; // use replace of function
        BinaryOperator<Integer> b = (x,y) -> x + y; // use replace of biFunction

        /* Method Reference */
        List<String > li = Arrays.asList("Ram","Shyam","Jam");
        li.forEach(System.out::println);

        /* Constructor Reference
            instead of : () -> new Employee()
            write : Employee :: new
         */

//        Supplier<Employee> emp = Employee :: new;
//        Employee e = emp.get();





    }
}
