package solution.qa;

import java.util.List;

//Класс (Всегда с большой буквы + написание в стиле camelCase)
public class ExampleJavaClass {

    //Метод
    public static void main (String... args) {
        //Добавляем переменную, которую использует System.out.println для отображения
        //String - Это тип данных строка. toBePrint - это название переменной. "=" - знак ровно - это оператор присвоения
        String toBePrint = "\n Я программист!(Нет)";

        //ПОДРОБНЕЕ ПРО ТИПЫ ДАННЫХ.

        //Целочисленные типы (Всегда со знаком. Либо +, либо -)
        byte aByte = 0; // Занимаемое место в памяти 8bit // Диапазон хранимых значений: -128 + 127 // (-2^8) .. (2^8 -1)
        short aShort = 0; // Занимаемое место в памяти 16bit // Диапазон хранимых значений: -32768 + 32768 // (-2^16) .. (2^16 -1)
        int aInt = 0; // Занимаемое место в памяти 32bit // Диапазон хранимых значений: -2 147 483 648 до 2 147 483 647 // (-2^32) .. (2^32 -1)
        long aLong = 0; // Занимаемое место в памяти 64bit // Диапазон хранимых значений: -9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 // (-2^32) .. (2^32 -1)
        Integer intWrapper = 0; // Обертка над обычным int. Является объектом, а не примитивом

        //P.S. Чаще всего используется тип int, так как целочисленный литерал изначально идет с типом int. Ему можно добавить тип Long, но типы Byte/Short не добавить.

        //Типы с Плавающей точкой - являются не самыми точными
        float aFloat = 0.0F; // Занимаемое место в памяти 32bit
        double aDouble = 0.0; // Занимаемое место в памяти 64bit

        //Символьный
        char aChar = 'a';
        Character charWrapper = 'a'; // Обертка над обычным char. Является объектом, а не примитивом
        //Логический
        boolean aBoolean = true;
        Boolean booleanWrapper = true; // Обертка над обычным boolean. Является объектом, а не примитивом

        //Строка (и бесконечность других объектных/ссылочных типов данных)
        String stringExample = "\n Памагити";
        List<String> teachers = List.of("Statislav","Dmitri");
        System.out.println(toBePrint);
        System.out.println(stringExample);
        System.out.println(teachers);

        //ОПЕРАТОРЫ

        //Оператор присвоения "=" (Это равно)
        String nickName = "Agzamurai"; // Простой оператор. Берет что справа и присваивает к тому, что слева.
        int age = 34; // Простой оператор. Берет что справа и присваивает к тому, что слева.

        //Арифметические операторы + (Складывает); - (Вычитает); / (Делит); * (Умножает); % (взятие остатка от деления); ++ (Инкримент); -- (Декримент).
        System.out.println("\nАрифметические операторы");
        System.out.println(4.0 + 3);
        System.out.println(4.0 - 3);
        System.out.println(4.0 * 3);
        System.out.println(4.0 / 3);
        System.out.println(4.0 % 3);
        System.out.println(5 / 3); // Деление в Java отбрасывает остаток, если оно осуществляется над целыми числами
        System.out.println(5 % 3); // Если хотим видеть остаток, то %
        int resultMinus = --aInt; // Декримент. -- всегда дает -1
        System.out.println(resultMinus);
        int resultPlus = ++aInt; // Инкримент. ++ всегда дает +1
        System.out.println(resultPlus);

        //Операторы сравнения <, >, >=, <=, !=, ==
        System.out.println("\nОператоры сравнения");
        System.out.println(3 < 2);
        System.out.println(3 > 2);
        System.out.println(3 >= 2);
        System.out.println(3 <= 2);
        System.out.println(3 != 2);
        System.out.println(3 == 2);

        //Логические операторы &, | (или), && (сокр. И), || (сокр. ИЛИ), ^ (Сор. Аналог !=), ! (Аналог !=). Позволяют группировать несколько булевых значений и получить итоговый результат
        System.out.println(nickName.equals("Agzamurai") && age == 34);
            // equals - используется для сравнения объектов. В примере сравниваем 2 значения. Имя и возраст. Ждем, что все будет ровно
            // Почему && - потому что, если никНейм не совпадет, то возраст уже не будет сравниваться.

        //Оператор instanceof - проверяет тип данных в рантайме (Что?!)
        System.out.println(nickName instanceof String); //Является ли nickName - строкой?

        //Тернарный оператор - позволяет что-то проверить, прежде чем сделать
        char sex = 'm';
        String childName  = sex == 'm'
                ? "Valentin"
                : "Valentina";
        //Управляющая конструкция if / else
        if (sex == 'm') {
            childName = "Valentin";
        } else {
            childName = "Valentina";
        }

        //Ключевое слово new - создано для того, чтобы создавать объекты (В Java почти всё является объектом)
        String name = new String("Agzamurai");
        String nameNotNew = ("Agzamurai"); // Для стринга существует исключение. Не обязательно прописывать new

    }
}