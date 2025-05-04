package polymorphism;

public class Dog extends Animal{

    void eat(String food){
        System.out.println("Dog Eating " + food);
//        return "food";
    }
    void sound(){
        System.out.println("bark");
    }
}
