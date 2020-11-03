import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

// Learn Stream in Java 8 from https://www.youtube.com/watch?v=t1-YZ6bF-g0
public class JavaStream {
    public static void main(String[] args) {
        // Int Stream
        IntStream.range(1, 10).forEach(System.out::print);
        // prints 123456789
        System.out.println();

        // Integer Stream with skip
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x));
        // We skin the first five and get 6789
        System.out.println();
    }
}
