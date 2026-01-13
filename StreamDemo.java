import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        /*
            - a sequence of elements supporting functional and declarative programing
            -> Source, Intermediate, operations and terminal operations.
        */

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        System.out.println(numbers.stream().filter(x-> x%2 ==0).collect(Collectors.toList()));

        /* Creating Stream */
            //1. From Collection
                List<Integer> list =  Arrays.asList(1,2,3,4,5);
                Stream<Integer> stream = list.stream();
            //2. From Arrays
                String[] array =  {"a","b","c"};
                Stream<String>  stream1 = Arrays.stream(array);
            //3. Using Stream.of()
                Stream<String> stream2 = Stream.of("a","b");
            //4. Infinite streams
                Stream<Integer> generate = Stream.generate(()->1);
                Stream.iterate(1,x -> x + 1).limit(100).collect(Collectors.toList());


        /* Intermediate Operation */
                //Intermediate operations transform a stream into another stream

                // 1. Filter
                    List<String> list1 = Arrays.asList("Akshit","Ram","Shyam","Ghanshyam","Ram");
                    Stream<String> filterStream = list1.stream().filter(x -> x.startsWith("A")); // no filtering at this point
                    long res = list1.stream().filter(x->x.startsWith("A")).count(); // After apply terminal operation here is count then i got filtered value
                    System.out.println(res);

                // 2. Map
                    Stream<String> stringStream = list1.stream().map(x->x.toUpperCase());
                    stringStream.forEach(System.out::println);

                // 3. Sorted
                    Stream<String> sortedStream =  list1.stream().sorted();
                    Stream<String> sortedUsingComparator = list1.stream().sorted((a,b)-> a.length()-b.length());
                    System.out.println(sortedUsingComparator.collect(Collectors.toList()));

                // 4. Distinct
                System.out.println(list1.stream().filter(x -> x.startsWith("R")).distinct().collect(Collectors.toList()));

                // 5. Limit
                System.out.println(Stream.iterate(1, x->x+1).limit(10).collect(Collectors.toList()));

                //6. Skip
                System.out.println(Stream.iterate(1, x->x+1).skip(5).limit(10).toList());


        /* Terminal Operation */

            List<Integer> li = Arrays.asList(1,2,3,4,5);

            // 1. Collect
                System.out.println(li.stream().skip(1).collect(Collectors.toList()));

            // 2. forEach
                li.stream().forEach(System.out::println);

            // 3. reduce : Combines elements to produce a single result
              Optional<Integer> reducer =  list.stream().reduce((a, b)-> a+b);
//              Optional<Integer> reducer =  list.stream().reduce(Integer::sum); // Use Method reference but work same thing
              System.out.println(reducer.get());

            // 4. Count

            // 5. anyMatch, allMatch, noneMatch
                boolean b = li.stream().allMatch( x ->x % 2 == 0); // allmatch
                System.out.println(b);

                boolean b1 = list.stream().allMatch(x ->x >0);
                System.out.println(b1);

                boolean b2 =  li.stream().noneMatch(x-> x<0);
                System.out.println(b2);

            // 6. findMatch, findAny
                System.out.println(li.stream().findFirst().get());
                System.out.println(li.stream().findAny().get());

                //Example :: Filtering and Collecting Names
                List<String> names = Arrays.asList("Anna","Bob","Charlie","David");
                System.out.println(names.stream().filter(x -> x.length() > 3).collect(Collectors.toList()));

                // Example:: Squring and Sorting Numbers
                List<Integer> number  = Arrays.asList(5,2,9,1,6);
                System.out.println(number.stream().map(x -> x * x).sorted((x,y)-> x - y).collect(Collectors.toList()));

                // Example :: Summing Value
                List<Integer> num = Arrays.asList(1,2,3,4,5);
                System.out.println(num.stream().reduce(Integer::sum).get());

                //Example :: Counting Occurrences of a Character
                String sentence = "Hello World";
                System.out.println(sentence.chars().filter(x -> x == 'l').count());



    }
}
