import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo{
    public static void main(String[] args) {

        // 1. Collecting to a List
        List<String > names =  Arrays.asList("Ram","Shyam","Jam");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        // 2. Collecting to a Set
        List<Integer> nums = Arrays.asList(1,2,2,3,4,4,5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);// because its return set so its return unique value.

        // 3. Collecting to a specific Collection
        ArrayDeque<String> collect =  names.stream().collect(Collectors.toCollection(()-> new ArrayDeque<>()));

        // 4. Joining Strings
        // Concatenates Stream elements into a single String
        String concatenatedName = names.stream().map(String :: toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedName);

        // 5. Summarizing Data
        //Generates Statistical summary(count, sum, min, average,max)

        List<Integer> numbers =  Arrays.asList(2,3,5,7,11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x ->x));
        System.out.println("Count :: "+ stats.getCount());
        System.out.println("Sum :: "+ stats.getSum());
        System.out.println("Min :: "+ stats.getMin());
        System.out.println("Average :: "+ stats.getAverage());
        System.out.println("Max :: "+ stats.getMax());

        // 6. Calculating Average
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average :: "+ average);

        // 7. Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count :: "+ count);

        // 8. Grouping Elements
        List<String> words = Arrays.asList("hello", "world","java","Streams","collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String :: length, Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String :: length, Collectors.counting())));

        TreeMap<Integer, Long> treemap = words.stream().collect(Collectors.groupingBy(String :: length,TreeMap::new, Collectors.counting()));
        System.out.println(treemap);

        // 9. Partitioning Elements
        // partitions element into two group(true and false) based on a predicates.
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        // 10. Mapping and Collecting
        //Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        // 11. ToMap Use .
        List<String> fruit = Arrays.asList("Apple","Banana", "Cherry");
        System.out.println(fruit.stream().collect(Collectors.toMap(x->x.toUpperCase(), x->x.length()))); // create map with key value pair with word length

        List<String> words2 = Arrays.asList("apple","banana","apple","orange","banana","apple");
        words2.stream().collect(Collectors.toMap(k->k, v ->1, (x,y) -> x+y));

        //Example 1 :: Collecting name by length
        List<String> l1 = Arrays.asList("Anna","Bob","Alexander","Brain","Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        //Example 2 :: Counting Word Occurrences
        String sentence = "Hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //Example 3 :: Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));


    }
}
