package ex1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) {
        System.out.println(function(Arrays.asList(5,10)));
    }

    public static String function(List<Integer> ints){
        String result = ints.stream().map(e -> (e%2 == 0?"p":"i") + e).collect(Collectors.joining(","));
        return result;
    }
}
