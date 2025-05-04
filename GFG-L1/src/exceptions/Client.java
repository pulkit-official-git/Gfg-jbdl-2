package exceptions;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws SQLException {
        Student student = new Student();
        try {
            student.getByid(0);
        }catch (EvenNumbeException e){
            System.out.println("Please give valid even");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            System.out.println("Inside finally block");
        }
        System.out.println("outside");

    }
}
