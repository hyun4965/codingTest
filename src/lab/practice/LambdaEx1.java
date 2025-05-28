package lab.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaEx1 {
    public static void main(String[] args) {
        MyFunction add = (x, y) -> { return x + y; };  // 람다식
        MyFunction minus = (x, y) -> x - y;           // 람다식. {}와 return 생략

        System.out.println(add.calc(1, 2));   // 합 구하기
        System.out.println(minus.calc(1, 2)); // 차 구하기

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // 람다식 사용
        fruits.forEach(fruit -> System.out.println(fruit));

        // 메서드 참조 사용
        fruits.forEach(System.out::println);

        List<Integer> list = List.of(1, 2, 3);
        Consumer<Number> numberConsumer = (Number n) -> System.out.println(n.doubleValue());

        list.forEach(numberConsumer); // OK, because Number is a supertype of Integer
        Consumer<String> printConsumer = s -> System.out.println("Value: " + s);
        Consumer<String> upperConsumer = s -> System.out.println("Upper: " + s.toUpperCase());

        // 두 Consumer를 연결
        Consumer<String> combined = printConsumer.andThen(upperConsumer);

        // 하나의 Consumer처럼 사용
        combined.accept("hello");
        // 실행 순서:
        // 1) printConsumer.accept("hello") -> "Value: hello"
        // 2) upperConsumer.accept("hello") -> "Upper: HELLO"
    }
}