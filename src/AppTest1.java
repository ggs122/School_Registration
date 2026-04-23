import Student.Student;

import Student.StudentUtils.*;

public class AppTest1 {


    static void main(String[] args) {

        Student student1 = new Student();
        student1.createStudent("1504", "Romualdo", "Ferreira", "da Silva");
        student1.CreateGradeOfStudent(400, 1, 1, 3.5);
        student1.CreateGradeOfStudent(400, 1, 2, 6);
        student1.CreateGradeOfStudent(400, 1, 3, 7.5);
        student1.CreateGradeOfStudent(400, 1, 4, 8);
        student1.CreateGradeOfStudent(400, 1, 5, 5.5);
        student1.printStudentBimonthlyAvg(400);

        student1.CreateGradeOfStudent(400, 1, 1, 10);
        student1.CreateGradeOfStudent(400, 1, 2, 10);
        student1.CreateGradeOfStudent(400, 1, 3, 10);
        student1.CreateGradeOfStudent(400, 1, 4, 10);
        student1.CreateGradeOfStudent(400, 1, 5, 10);
        student1.printGradeList();
        student1.printStudentBimonthlyAvg(400);

//        System.out.println(student1.returnBimonthlyAvgOfStudent(400));

//        Student student2 = new Student();
//        student2.createStudent("1504", "Igor", "Melo", "de Oliveira");
//        student2.CreateGradeOfStudent(401, 1, 1, 3.5);
//        student2.CreateGradeOfStudent(401, 2, 2, 6);
//        student2.printGradeList();

        Student student3 = new Student();
        student3.printStudent();

        Student student4 = new Student();
        student4.createStudent("1504", "Igor", "Melo", "de Oliveira");


//        System.out.println(student3.CheckingSpecificName("Romualdo", "Ferreira", "da Silva"));
    }

}
