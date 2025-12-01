package solution.qa;

public class Main {

    public static void main(String[] args) {
        Human dima = new Human();

        System.out.println("Name: " + dima.name);
        System.out.println("Age: " + dima.age);
        System.out.println("Cute: " + dima.isCute);

        dima.name = "Dmitri";
        dima.age = 34;
        dima.isCute = true;

        System.out.println("Name: " + dima.name);
        System.out.println("Age: " + dima.age);
        System.out.println(dima);
    }

}
