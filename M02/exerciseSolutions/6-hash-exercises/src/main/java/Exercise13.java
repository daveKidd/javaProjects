import learn.Student;

import java.util.HashMap;

public class Exercise13 {
    public static void main(String[] args) {
        /*
        Add at least three students to the map using their studentId as the key.
        8. Retrieve one student and display them.
        9. Delete one student.
        10. Display all students.
         */
        HashMap<Integer, Student> students = new HashMap<>();

        Student dave = new Student();
        dave.setStudentId(1);
        dave.setFirstName("Dave");
        dave.setLastName("Kidd");

        Student ava = new Student();
        ava.setStudentId(2);
        ava.setFirstName("Ava");
        ava.setLastName("Kidd");

        Student lily = new Student();
        lily.setStudentId(3);
        lily.setFirstName("Lily");
        lily.setLastName("Kidd");

        students.put(dave.getStudentId(),dave);
        students.put(ava.getStudentId(),ava);
        students.put(lily.getStudentId(),lily);

        System.out.println(students.get(2));
        System.out.println();

        students.remove(2);

        for(Student student : students.values()){
            System.out.println(student);
        }
    }
}
