package three;

import java.util.*;

class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCourse() {
        return this.course;
    }
}

class StudentTableGateway {
    private List<Student> students;

    public StudentTableGateway() {
        students = new ArrayList<>();
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student find(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void insert(Student student) {
        students.add(student);
    }

    public void update(Student student) {
        int index = students.indexOf(find(student.getId()));
        if (index != -1) {
            students.set(index, student);
        }
    }

    public void delete(int id) {
        students.remove(find(id));
    }
}

public class Main {
    public static void main(String[] args) {
        StudentTableGateway gateway = new StudentTableGateway();

        Student alice = new Student(1, "Alice", "Computer Science");
        Student bob = new Student(2, "Bob", "Physics");

        gateway.insert(alice);
        gateway.insert(bob);

        for (Student student : gateway.findAll()) {
            System.out.println(student.getName());
        }

        Student aliceUpdated = new Student(1, "Alicia", "Computer Science");
        gateway.update(aliceUpdated);

        System.out.println(gateway.find(1).getName());

        gateway.delete(1);

        for (Student student : gateway.findAll()) {
            System.out.println(student.getName());
        }
    }
}