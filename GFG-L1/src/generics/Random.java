package generics;

import java.util.ArrayList;
import java.util.List;

public class Random {


    public static void doSomething(List<? extends Animal> animals) {

//        animals.add(new Cat());
//        animals.add(new Dog());
//        animals.add(new Cat());


    }
    public static <T extends Animal> void doSomething2(List<T> animals) {

//        animals.add(new Cat());
//        animals.add(new Dog());
//        animals.add(new Cat());

    }

//    public static void doSomething2(Animal animal) {
//
//        List<Animal> animals = new ArrayList<>();
//        animals.add(animal);
//
////        animals.add(new Cat());
////        animals.add(new Dog());
////        animals.add(new Cat());
//
//    }
}
