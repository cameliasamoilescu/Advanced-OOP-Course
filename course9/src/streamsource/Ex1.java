package streamsource;

import java.util.*;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 4, 6, 7, 9, 22, 53, 44);


        // using iteration
        for (int i : intList){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        // using stream()
        Stream<Integer> s1 = intList.stream();
        s1.filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i));
        //.forEach(System.out::println);


        //empty()
        long count = streamOf(new HashSet<>()).count();
        System.out.println(count);

        // builder()
        Stream<String> streamWithBuilder = Stream.<String>builder().add("aa").add("aab").add("aabbc").add("bc").build();
        Optional<String> opt = streamWithBuilder
                .filter(s -> s.startsWith("a"))
                .max(Comparator.comparingInt(String::length));

        System.out.println(opt);


    }

    public static Stream<String> streamOf(Set<String> set){
        return set == null || set.isEmpty() ? Stream.empty() : set.stream();
    }
}
