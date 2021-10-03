package pl.beda.UserAuthenticationSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// IT'S NOT IMPORTANT CLASS FOR THIS PROJECT

public class LambdasAndStreams {

    public static void main(String[] args) {

        // function
        // name
        // parameters
        // function body
        // return type

        // (parameters) -> <function body>

        Thread thread = new Thread(() -> System.out.println("Thread"));
        thread.start();

        List<Integer> numbers = Arrays.asList(52, 17, 44, 67, 98, 60, 21, 18, 57, 102);

        // classic style  //

        int result = 0;

        for (int i : numbers) {
            if (i % 2 == 0) {
                result += i * 2;
            }
        }

        // stream data style //

        System.out.println(
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .mapToInt(i -> i * 2)
                        .sum()
        );

        System.out.println(numbers.stream().reduce(0, (subtotal, element) -> subtotal + element));

        Set<Integer> collect = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        System.out.println(collect);
    }
}
