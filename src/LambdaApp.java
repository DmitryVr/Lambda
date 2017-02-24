/**
 * по факту лямбда-выражения являются в некотором роде
 * сокращенной формой внутренних анонимных классов
 */
public class LambdaApp {
    static int x = 10;
    static int y = 20;

    private static void separator() {
        System.out.println("==================");
    }

    public static void main(String[] args) {

        Operationable operation1 = (int x, int y)-> x + y;
        Operationable operation2 = (int x, int y)-> x - y;
        Operationable operation3 = (int x, int y)-> x * y;

        int result1 = operation1.calculate(20, 10);
        int result2 = operation2.calculate(20, 10);
        int result3 = operation3.calculate(20, 10);

        System.out.println("x + y = " + result1); //30
        System.out.println("x - y = " + result2); //10
        System.out.println("x * y = " + result3); //200
        separator();

//        внутренний анонимный класс
//        Operationable op = new Operationable() {
//            @Override
//            public int calculate(int x, int y) {
//                return x + y;
//            }
//        };
//        int z = op.calculate(20, 10);
//        System.out.println(z); // 30

        // терминальное лямбда-выражение, которое не возвращают никакого значения
        Printable printer = s->System.out.println(s);
        printer.print("Hello Java!");
        separator();

        // переменные на уровне класса (можно изменять)
        // переменные на уровне метода нельзя изменят,
        // они константы и их нельзя изменять и вне лямбды
        Operation op = ()->{
            x = 30;
            return x + y;
        };
        System.out.println("x + y = " + op.calculate()); // 50
        System.out.println("new x = " + x); // 30 - значение x изменилось
        separator();

        // блочные лямбда
        // явный return
        Operationable operation4 = (int x, int y)-> {
            if(y == 0)
                return 0;
            else
                return x/y;
        };
        System.out.println(operation4.calculate(20, 10)); //2
        System.out.println(operation4.calculate(20, 0)); //0
        separator();

        // дженерик
        OperationableGeneric<Integer> operation5 = (x, y)-> x + y;
        OperationableGeneric<String> operation6 = (x, y) -> x + y;
        System.out.println(operation5.calculate(20, 10)); //30
        System.out.println(operation6.calculate("20", "10")); //2010
        separator();

        // Runnable
        Runnable threadTest = ()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " - done work");
        };
        new Thread(threadTest).start();
        System.out.println(Thread.currentThread().getName() + " - I'm Thread!");
        separator();
    }
}

// функциональный интерфейс - один метод без реализации
interface Operationable {
    int calculate(int x, int y);
}

interface Printable{
    void print(String s);
}

interface Operation{
    int calculate();
}

interface OperationableGeneric<T>{
    T calculate(T x, T y);
}