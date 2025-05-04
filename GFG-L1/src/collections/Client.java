package collections;

import java.lang.reflect.Array;
import java.util.*;

public class Client {

    public static void main(String[] args) {

//        List<Student> students = new ArrayList<>();
//        students.add(new Student("sid",40,90));
//        students.add(new Student("ram",50,80));
//        students.add(new Student("ravi",60,70));
//        students.add(new Student("aka",50,90));
//        Collections.sort(students,new StudentScoreComparator());
//        for (Student student : students) {
//            System.out.println(student.name);
//        }





//        Integer[]a={4,5,6,1,2,3};
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(10);
//        Integer c = 10;
        list.remove(new Integer(10));
        for(Integer i:list){
            System.out.println(i);
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        System.out.println(treeSet);

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
//        LinkedList
//        Status.REJECT


//        Collections.sort(list,Collections.reverseOrder());
//        for(Integer i:list){
//            System.out.print(i);
//        }

//        Arrays.sort(a,new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for(int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
    }

}
