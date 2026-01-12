import java.util.function.Function;

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
    }
}
