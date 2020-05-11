package lambda.functionalinterfaces;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Consumer<T> - void accept(T t)
 * BiConsumer<T, R> - void accept(T t, R r)
 * Supplier<T> - T get()
 * Function <T, R> - R apply(T t)
 * BiFunction <T, U, R> - R apply(T t, U u)
 * Predicate<T> - boolean test(T t)
 */


public class Ex1 {

    public static void main(String[] args) {
        Consumer<String> c1 = x -> System.out.println(x);
        c1.accept("abc");

        Supplier<LocalDate> ld1 = () -> LocalDate.now();
        ld1.get();

        Function<String, Integer> f1 = s -> s.length();
        f1.apply("asdfsfc");

        Predicate<Integer> p1 = x -> x % 2 == 0;
        p1.test(45);

    }

}
