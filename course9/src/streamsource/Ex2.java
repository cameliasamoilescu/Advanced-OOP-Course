package streamsource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex2 {
    public static void main(String[] args) {
        Stream<String> streamOnArray = Stream.of("aa", "aaaa", "aaaabb");
        streamOnArray.forEach(System.out::println);

        int[] ints = {1, 3, 5, 6, 8, 5, 5};
        Set<Integer> set = new HashSet<>(Arrays.asList(33, 44, 55, 77, 44, 88, 33));
        Stream<Set<Integer>> s1 = Stream.of(set);

        Stream<int[]> streamOfIntArray = Stream.of(ints);
        streamOfIntArray.forEach(System.out::println);

        //vs.
//        Arrays.stream(ints).forEach(System.out::println);
        Arrays.stream(ints, 2, 5).forEach(System.out::println); // [2,5)

        // IntStream, DoubleStream, LongStream
//
//        IntStream is1 = Arrays.stream(ints);
//        System.out.println(is1.sum());
//
//        IntStream is2 = Arrays.stream(ints);
//        System.out.println(is2.count());

        LongStream ls1 = LongStream.range(3, 5); // [3, 5)
        ls1.forEach(System.out::println);

        LongStream ls2 = LongStream.rangeClosed(0,3); // [0, 3]
        ls2.forEach(System.out::println);

        Random random = new Random();
        DoubleStream ds1 = random.doubles().limit(3);
        ds1.forEach(System.out::println);

        DoubleStream ds2 = random.doubles(5, 5, 6);
        ds2.forEach(System.out::println);


        // generate
        Stream<String> stringStream = Stream.generate(() -> "element").limit(2);
        stringStream.forEach(System.out::println);

        // UnaryOperator
        Stream<Integer> integerStream = Stream.iterate(0, i -> i + 2).limit(10);
        integerStream.forEach( x -> {
                System.out.println(x);
                }

        );


    }

}
