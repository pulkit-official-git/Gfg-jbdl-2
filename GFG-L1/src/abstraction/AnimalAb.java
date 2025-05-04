package abstraction;

public abstract class AnimalAb {
    String color;
    String countInCountry;

    abstract void eat();
    abstract void sleep();
    abstract void run();

    void dance(){
        System.out.println(" Animal Dance");
    }
}
