import java.lang.String;
import java.util.Arrays;
import java.util.List;
// Classes to support functional-style operations on streams of elements, such as map-reduce transformations on collections.
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Learn Stream in Java 8 from https://www.youtube.com/watch?v=t1-YZ6bF-g0
public class JavaStream {
    public static void main(String[] args) throws IOException {
        // Int Stream
        IntStream.range(1, 10).forEach(System.out::print);
        // prints 123456789
        System.out.println();


        // Integer Stream with skip
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x));
        // We skin the first five and get 6789
        System.out.println();


        // Integer Stream with sum
        System.out.print(IntStream.range(1, 4).sum());
        // prints 6 so 1 + 2 + 3
        System.out.println();


        //Stream.of, sorted and findFirst
        // prints Alberto
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);


        // Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)	// same as Stream.of(names)
                // Gives SarahSarikaShivika
                .filter(x -> x.startsWith("S")).sorted().forEach(System.out::print);
        System.out.println();


        // Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                // gives 44.0 (never fully trust ints when it comes to rounding
                .map(x -> x * x).average().ifPresent(System.out::print);
        System.out.println();


        // Stream from a list, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        // prints alankitamanda
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::print);
        System.out.println();

        // Stream rows from text file, sort, filter, and print
        // files stored in root directory
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        // prints "Mumford and Sons"
        bands.sorted().filter(x -> x.length() > 15).forEach(System.out::println);
        bands.close();


        // Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("jit")).collect(Collectors.toList());
        // prints "Arijit Singh"
        bands2.forEach(x -> System.out.println(x));
    }
}
