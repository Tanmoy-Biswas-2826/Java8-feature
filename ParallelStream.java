import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {

        /* A Parallel Stream is used to process data using multiple thread instead of one
            it splits the data into parts and processes them simultaneously using the ForkJoinPool

            - Parallel streams must use stateless operations means not dippend on prev record independence work
            done in parallel stream if we work on stateful operation then its return wrong data
            - list.parallelStream() or list.stream.parallel()

            - Parallel stream are most effective for CPU-intensive or large datasets where tasks are independent
            - They may add overhead for simple tasks or small datasets.
        */

       long startTime = System.currentTimeMillis();
       List<Integer> li =  Stream.iterate(1, x->x+1).limit(2000).toList();
       List<Long> factorialList = li.stream().map(ParallelStream::factorial).toList();
       long endTime = System.currentTimeMillis();

        System.out.println("Time taken with stream ::" +(endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        factorialList = li.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream ::" +(endTime-startTime) + "ms");
    }

    private static long factorial(int n){
        long result =1;
        for(int i=0; i<=n; i++){
            result*=i;
        }
        return  result;
    }
}
