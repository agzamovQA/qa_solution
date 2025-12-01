package solution.qa;

public class Human {

    String name;
    int age;
    boolean isCute;

    //Тэг оверрайд нужен для переопределения метода. Приоритет на исполенение становится у метода с данным тэгом.
//    @Override
//    public String toString() {
//        return "Human{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", isCute=" + isCute +
//                '}';
//    }

    public Human (String name, int age, boolean isCute) {
        this.name = name;
        this.age = age;
        this.isCute = isCute;
    }

}