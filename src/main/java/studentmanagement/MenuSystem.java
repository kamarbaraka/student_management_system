package studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * a java program to simulate a student management system
 * @author kamar baraka
 * @since 29/06/2023*/

public class MenuSystem {

    public static void main(String[] args) {
        /*create student objects*/
        var student1 = new Student("kamar", 23, Grade.B);
        var student2 = new Student("makena", 20, Grade.A);
        var student3 = new Student("tom", 25, Grade.C);
        var student4 = new Student("evans", 20, Grade.D);

        /*create a class to store the students*/
        var classA = new ClassOfStudents();
        classA.addAll(List.of(student1, student2, student3, student4));

        /*create a menu object to store the class*/
        var menu = new Menu(classA);

        /*the search algorithm*/
        try (var input = new Scanner(System.in)){
            while (true){

                System.out.println("welcome, search a student by (name/age) or exit");

                switch (input.next()){
                    case "name" -> {
                        System.out.println("enter the name");
                        System.out.println(menu.searchByName(input.next()));
                    }
                    case "age" -> {
                        System.out.println("enter the age");
                        System.out.println(menu.searchByAge(input.nextInt()));
                    }
                    case "exit" -> System.exit(0);
                    case "students" -> System.out.println(menu.getStudents());
                    default -> System.out.println("invalid input");
                }
            }
        }
    }
}

class Menu{

    /**
     * a class to hold a class of students
     */

    private ClassOfStudents classOfStudents;

    /**
     * canonical constructor
     * @param classOfStudents the class of students*/
    public Menu(ClassOfStudents classOfStudents) {
        this.classOfStudents = classOfStudents;
    }

    /**
     * method to search students by name
     * @param name the student name
     * @return a list of students with the matching name*/
    public List<Student> searchByName(String name){
        var foundStudents = new ArrayList<Student>();
        for (Student student : this.classOfStudents){
            if (student.getName().equals(name))
                foundStudents.add(student);
        }

        return foundStudents;
    }

    /**
     * a method to search students by the age
     * @param age the age of the student
     * @return list of students with matching age*/
    public List<Student> searchByAge(int age){
        var foundStudents = new ArrayList<Student>();
        for (Student student : this.classOfStudents){
            if (student.getAge() == age)
                foundStudents.add(student);
        }
        return foundStudents;
    }

    /**
     * method to get all students
     * @return list of students*/
    public ClassOfStudents getStudents(){
        return this.classOfStudents;
    }
}
