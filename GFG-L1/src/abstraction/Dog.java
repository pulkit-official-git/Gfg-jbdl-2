package abstraction;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eating");
    }

    @Override
    public void sleep() {
        System.out.println("dog sleeping");
    }

    @Override
    public void run() {
        System.out.println("dog run");
    }

    public void sound(){
        System.out.println("dog sound bark");
    }
}
