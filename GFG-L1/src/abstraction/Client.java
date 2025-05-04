package abstraction;

public class Client {

    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
        a.sleep();
        Dog d = new Dog();
        d.sound();
        System.out.println(a.color);
        System.out.println(d.color);

        Parrot ab = new Parrot();
        ab.fly();
        ab.sleep();
        ab.color="black";
        System.out.println(ab.color);
//        Flyable f = new Parrot();
//        f.

    }
}
