import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        System.out.println("---------ITERATION-----------");

        // iterating with streams focus on operation logic rather than on iteration over the elements

        boolean exists = arr2.stream().anyMatch(s -> s.equals("A"));
        System.out.println(exists);
        // allMatch() - returns true if all elements in the stream match the predicate
        List<String> arr3 = Arrays.asList("Juaheiu", "1737813A", "Vfahf3", "A3afgh");
        boolean allMatch = arr3.stream().allMatch(s -> s.contains("A"));
        System.out.println(allMatch);
        // noneMatch() - returns true if no elements in the stream match the predicate
        boolean noneMatch = arr3.stream().noneMatch(s -> s.contains("A"));
        System.out.println(noneMatch);

        List<String> arr4 = Arrays.asList("Juaheiu", "1737813A", "Vfahf3", "A3afgh");
        Stream<String> filtered3 = arr4.stream().filter(s -> s.contains("A"));
        filtered3.forEach(System.out::println);

        System.out.println("----------MAP----------");

        // mapping - convert elements of a stream to another object
        List<String> arr5 = Arrays.asList("123123", "321232", "12314335", "3434334");
        Stream<Integer> mapped = arr5.stream().map(s -> Integer.parseInt(s));
        mapped.forEach(System.out::println);
        
        System.out.println("-----------REDUCE---------");

        // reduce() - transform a stream into a single value
        List<Integer> arr6 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = arr6.stream().reduce(100, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("-----------COLLECT---------");

        // collect() - convert a stream into a collection
        List<String> arr7 = Arrays.asList("a", "b", "c", "d");
        List<String> result = arr7.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
        // collect can also use custom collectors
        List<String> arr8 = Arrays.asList("a", "b", "c", "d");
        String result2 = arr8.stream().collect(Collectors.joining(", "));
        System.out.println(result2);
    }
}