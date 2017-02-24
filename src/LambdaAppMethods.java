public class LambdaAppMethods {
    public static void main(String[] args) {
        Expression func = (n)-> n % 2 == 0;
        int[] nums = { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int result = sum(nums, func);
        System.out.println(result); // 20

        // ссылка на другой метод
        // имя_класса::имя_статического_метода (если метод статический)
        // объект_класса::имя_метода (если метод нестатический)
        // методы, на которые идет ссылка, должны совпадать по параметрам и результату с методом функционального интерфейса
        System.out.println(sum(nums, ExpressionHelper::isEven));
        Expression expr = ExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));
        ExpressionHelper exprHelper = new ExpressionHelper();
        System.out.println(sum(nums, exprHelper::isNegative));
    }

    private static int sum (int[] numbers, Expression func) {
        int result = 0;
        for(int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}

interface Expression {
    boolean isEqual(int n);
}

// класс, в котором определены методы
class ExpressionHelper {

    static boolean isEven(int n) {
        return n%2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }

    boolean isNegative(int n) {
        return n < 0;
    }
}