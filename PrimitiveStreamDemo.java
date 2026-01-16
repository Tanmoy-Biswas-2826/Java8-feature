import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamDemo {
    public static void main(String[] args) {
        /*
        Primitive Streams are a Java 8 Stream API feature designed to work directly
        with primitive types to avoid boxing/unboxing overhead.

        Primitive: int, long, double
        StreamType : IntStream, LongStream, DoubleStream

        There is no FloatStream, ByteStream, etc.

        Normal stream use wrapper classes: Stream<Integer>
        Primitive streams avoid this : IntStream

        */

        IntStream.of(1, 2, 3, 4);
        LongStream.of(10L, 20L);
        DoubleStream.of(1.5, 2.5);

        IntStream.range(1, 5);        // 1 2 3 4
        IntStream.rangeClosed(1, 5);  // 1 2 3 4 5


        List<Integer> list = List.of(1, 2, 3);

        IntStream intStream = list.stream()
                .mapToInt(Integer::intValue);

        /* OPERATIONS */
        int sum = IntStream.of(1, 2, 3).sum();
        OptionalDouble avg = IntStream.of(1, 2, 3).average();
        int min = IntStream.of(3, 1, 2).min().getAsInt();
        int max = IntStream.of(3, 1, 2).max().getAsInt();
        long count = IntStream.of(1, 2, 3).count();


        //Convert Primitive to Normal Stream
        Stream<Integer> boxed = IntStream.of(1, 2, 3).boxed(); //must use box() for convert

        int sum1 = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .sum();

    /*Autoboxing is a Java feature (introduced in Java 5) where the
      compiler automatically converts a primitive type into its corresponding wrapper class.

    int a = 10;
    Integer obj = a;   // autoboxing

    Integer obj = Integer.valueOf(a);



      */

    }
}
