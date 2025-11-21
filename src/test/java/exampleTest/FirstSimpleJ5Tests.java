package exampleTest;

import org.junit.jupiter.api.*;

public class FirstSimpleJ5Tests {

    int result;
    @BeforeAll
    // BeforeAll - практически тоже самое, что и @BeforeEach, только нужно использовать метод статик.
    static void beforeAll () {
        System.out.println("\nЯ вызываюсь перед всеми тестами\n");
    }

    @AfterAll
    // AfterAll - вызывается после всех тестов.
    static void afterAll () {
        System.out.println("\nЯ вызываюсь после всех тестов\n");
    }

    @BeforeEach
    // BeforeEach - предусловие, которое выполняется до запуска тестов.
    void beforeEach () {
        result = getResult();
    }
    @Test
    void firstSimpleTest () {
        System.out.println("### firstSimpleTest");
        // Assertion - проверка на сравнение. Три больше 2
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondSimpleTest () {
        System.out.println("### secondSimpleTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdSimpleTest () {
        System.out.println("### thirdSimpleTest");
        Assertions.assertTrue(result > 2);
    }

    private int getResult () {
        return 3;
    }
  }
