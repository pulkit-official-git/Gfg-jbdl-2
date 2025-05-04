package polymorphism;

public class Animal {

    String name;
    String color;
    int age;
    void eat() {
        System.out.println("Eating...");
    }
    void eat(String food){
        System.out.println("Animal Eating " + food);
//        return "food";
    }
//    void sleep() {
//        System.out.println("Sleeping...");
//    }
}
