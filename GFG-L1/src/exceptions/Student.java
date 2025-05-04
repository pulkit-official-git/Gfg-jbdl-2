package exceptions;

import java.sql.SQLException;

public class Student {
    public Integer getByid(Integer id) throws SQLException, EvenNumbeException, ClassNotFoundException {
        if(id==0){
            throw new ClassNotFoundException();
        }
        if(id%2==0){
            throw new EvenNumbeException();
        }
        if(id%2==1){
            System.out.println("Please give vlid value");
//           throw new OddNumberException();
        }

//        return 1/0;
        throw new SQLException();
    }
}
