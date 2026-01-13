import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PedicateDemo {
    public static void main(String[] args) {
        /* Predicate --> Functional interface (Boolean value function)
         there is an only abstract method is test() that return boolean
        */

        /* Store condition in a variable */
        Predicate<Integer> isEven = x -> x % 2 == 0; // create a predicate for check even number
        System.out.println(isEven.test(2)); // Return true
        System.out.println(isEven.test(5)); // Return false

        // Predicate for Start with check
        Predicate<String> isStart = s -> s.toLowerCase().startsWith("A");
        System.out.println(isStart.test("Atanu")); // Return True
        System.out.println(isStart.test("Punit")); // Return False

        //Predicate for End With
        Predicate<String> isEnd = s -> s.toLowerCase().endsWith("U");
        System.out.println(isStart.test("Atanu")); // Return True
        System.out.println(isStart.test("Punit")); // Return False

        // Combine two predicate and create a new predicate
        Predicate<String> and =  isStart.and(isEnd);
        System.out.println(and.test("Alantu"));

        /* BiPredicate */
        //Its take two argument for boolena check
        BiPredicate<Integer, Integer> biPredicate = (x,y) -> (x + y) % 2 ==0;
        System.out.println(biPredicate.test(5,5));


    }
}
