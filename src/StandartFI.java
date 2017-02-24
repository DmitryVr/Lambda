import java.util.Scanner;
import java.util.function.*;

public class StandartFI {
    private static void separator() {
        System.out.println("==================");
    }
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
        separator();

        BinaryOperator<Integer> multiply = (x, y) -> x*y;
        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20
        separator();

        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25
        separator();

        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов
        separator();

        Consumer<Integer> printer = x-> System.out.println(x + " долларов");
        printer.accept(600); // 600 долларов
        separator();

        Supplier<Man> userFactory = ()-> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new Man(name);
        };
        Man user1 = userFactory.get();
        Man user2 = userFactory.get();
        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }
}

class Man {
    private String name;

    String getName() {
        return name;
    }

    Man(String n) {
        this.name=n;
    }
}

/*
public interface Predicate<T> {
    boolean test(T t);
}

public interface BinaryOperator<T> {
    T apply(T t1, T t2);
}

public interface UnaryOperator<T> {
    T apply(T t);
}

public interface Function<T, R> {
    R apply(T t);
}

public interface Consumer<T> {
    void accept(T t);
}

public interface Supplier<T> {
    T get();
}
*/