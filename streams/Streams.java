import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

        // parallel stream allows multiple threads to process the stream
        Stream<String> parallelStream = stream.parallel();
        parallelStream.forEach(System.out::println);

        System.out.println("--------------------");

        // forEachOrdered() forces the order of the stream
        Stream<String> stream2 = Stream.of("a", "b", "c");
        stream2.parallel().forEachOrdered(System.out::println);

        System.out.println("--------------------");

        // intermediate operations (return Stream<T>)
        // terminal operations (return a result of definite type)
        List<String> arr2 = Arrays.asList("J", "A", "V", "A");
        // distinct() returns a stream with distinct elements - intermediate
        // count() returns the number of elements in the stream - terminal
        long count = arr2.stream().distinct().count();
        System.out.println(count);

        System.out.println("--------------------");

        // iterating with streams focus on operation logic rather than on iteration over the elements

        boolean exists = arr2.stream().anyMatch(s -> s.equals("A"));
        System.out.println(exists);

        List<String> arr3 = Arrays.asList("Juaheiu", "1737813A", "Vfahf3", "A3afgh");
        Stream<String> filtered3 = arr3.stream().filter(s -> s.contains("A"));
        filtered3.forEach(System.out::println);

    }
}