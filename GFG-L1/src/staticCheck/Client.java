package staticCheck;

public class Client {

    public static void main(String[] args) {
        Student s1 = new Student();
//        Student s2 = new Student();
//        Student s3 = new Student();
////        s1.univ="gfg";
//        System.out.println(s2.univ);
//        System.out.println(Student.year());
        Student.year();
        System.out.println(s1.univ);
    }
}
