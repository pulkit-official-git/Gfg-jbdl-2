public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student s1 = new Student();
        System.out.println(s1);
//        Student s2 = new Student("skr",35);
        Student s3 = new Student(s1);
        s3.name="temo";

    }
}