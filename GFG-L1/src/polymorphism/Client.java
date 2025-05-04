package polymorphism;

public class Client {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
//        animal.eat("food");
        Dog animal2 = new Dog();
        animal2.eat("food");
    }
}
