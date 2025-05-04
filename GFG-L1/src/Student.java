public class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(){

    }
    Student(Student student){
        this.name = student.name;
        this.age = student.age;
    }
}
