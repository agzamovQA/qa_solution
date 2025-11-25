package solution.qa;

public class JavaHomeWorkL1 {

    public static void main (String... args) {

        System.out.println("Применение арифметических операций \n");
        System.out.println(2 + 2);
        System.out.println(4 / 2);
        System.out.println(4.0 * 2);
        System.out.println(4.0 - 9);

        System.out.println("\nПрименение логических операций \n");
        System.out.println(2 > 2);
        System.out.println(4 < 2);
        System.out.println(4.0 != 2);
        System.out.println(4.0 == 9);

        System.out.println("\nПримеры переполнения при работе с вещественными(числа с плавающей точкой) типами данных \n");
        float minFloat = Float.MIN_VALUE;      // 1.4E-45
        float maxFloat = Float.MAX_VALUE;      // 3.4028235E38
        float positiveInfinity = Float.POSITIVE_INFINITY;
        float negativeInfinity = Float.NEGATIVE_INFINITY;

        System.out.println("Float MIN: " + minFloat);
        System.out.println("Float MAX: " + maxFloat);

        double minDouble = Double.MIN_VALUE;     // 4.9E-324
        double maxDouble = Double.MAX_VALUE;     // 1.7976931348623157E308
        double nan = Double.NaN;           // Not a Number

        System.out.println("Double MIN: " + minDouble);
        System.out.println("Double MAX: " + maxDouble);

        // Переполнение float
        float overflowFloat = Float.MAX_VALUE * 2;
        System.out.println("Float overflow: " + overflowFloat); // Infinity

        // Переполнение double
        double overflowDouble = Double.MAX_VALUE * 2;
        System.out.println("Double overflow: " + overflowDouble); // Infinity

        // Деление на ноль
        double infinityDouble = 1.0 / 0.0;
        System.out.println("1.0 / 0.0 = " + infinityDouble); // Infinity

        // Неопределенность
        double nanDouble = 0.0 / 0.0;
        System.out.println("0.0 / 0.0 = " + nanDouble); // NaN

    }
}
