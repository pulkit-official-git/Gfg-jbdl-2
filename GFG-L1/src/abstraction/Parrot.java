package abstraction;

public class Parrot extends AnimalAb implements Flyable{

    @Override
    void eat() {
        System.out.println("parrot eating");
    }

    @Override
    void sleep() {
        System.out.println("parrot sleeping");
    }

    @Override
    void run() {
        System.out.println("parrot running");
    }

    @Override
    public void fly() {
        System.out.println("parrot flying");
    }
}
