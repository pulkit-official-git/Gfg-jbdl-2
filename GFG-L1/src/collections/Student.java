package collections;

public class Student implements Comparable<Student> {
    String name;
    Integer attendance;
    Integer score;

    public Student() {
    }

    public Student(String name, Integer attendance, Integer score) {
        this.name = name;
        this.attendance = attendance;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(o.attendance == this.attendance) {
            return o.score.compareTo(this.score);
        }
        return o.attendance.compareTo(this.attendance);
    }
}
