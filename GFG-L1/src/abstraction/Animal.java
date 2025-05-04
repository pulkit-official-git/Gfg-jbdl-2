package abstraction;

public interface Animal {
    String color="rainbow";
    void eat();
    void sleep();
    void run();
    default void move() {
        System.out.println("Animal is moving");
    }
}
