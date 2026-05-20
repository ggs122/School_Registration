package br.com.javainsider.AppTests;

import br.com.javainsider.Enrollment.Student;

import br.com.javainsider.Enrollment.Teacher;

public class AppTest1 {


    static void main(String[] args) {

        Student student1 = new Student();
        student1.createStudent(1, "Romualdo", "Ferreira", "da Silva");
        student1.CreateGradeOfStudent(400, 1, 1, 1, 3.5);
        student1.CreateGradeOfStudent(400, 1, 1, 2, 6);
        student1.CreateGradeOfStudent(400, 1, 1, 3, 7.5);
        student1.CreateGradeOfStudent(400, 1, 1, 4, 8);
        student1.CreateGradeOfStudent(400, 1, 1, 5, 5.5);
//        student1.createSpecificStudentPresentOrAbsent(400, 1, "2026-05-04", 1, 0);
//        student1.printSpecificStudentPresentOrAbsent();
//        student1.printStudentBimonthlyAvg(400);

        student1.CreateGradeOfStudent(400, 2, 1, 1, 10);
        student1.CreateGradeOfStudent(400, 2, 1, 2, 10);
        student1.CreateGradeOfStudent(400, 2, 1, 3, 10);
        student1.CreateGradeOfStudent(400, 2, 1, 4, 10);
        student1.CreateGradeOfStudent(400, 2, 1, 5, 10);
//        student1.printStudentBimonthlyAvg(400);

        student1.CreateGradeOfStudent(400, 3, 1, 1, 7.5);
        student1.CreateGradeOfStudent(400, 3, 1, 2, 5.5);
        student1.CreateGradeOfStudent(400, 3, 1, 3, 4.5);
        student1.CreateGradeOfStudent(400, 3, 1, 4, 9.5);
        student1.CreateGradeOfStudent(400, 3, 1, 5, 10);
//        student1.printStudentBimonthlyAvg(400);

        student1.CreateGradeOfStudent(400, 4, 1, 1, 6.5);
        student1.CreateGradeOfStudent(400, 4, 1, 2, 5.5);
        student1.CreateGradeOfStudent(400, 4, 1, 3, 4.5);
        student1.CreateGradeOfStudent(400, 4, 1, 4, 7.5);
        student1.CreateGradeOfStudent(400, 4, 1, 5, 3.5);
        student1.CreateGradeOfStudent(400, 4, 1, 5, 3.5);
//        student1.printStudentBimonthlyAvgForSubject(400, 1);
//        student1.printGradeList();

//        student1.printStudentSpecificGradeListForStudentEnrollmentAndBiomonthly(400, 1);
        student1.printSTudentSpecificGradeForEnrollMentAndSubject(400, 1);
        student1.printStudentBimonthlyAvgForSubject(400, 1);
//        System.out.println(student1.checkingGradeOfStudent(400, 4, 1, 7));

//        student1.test(400, 1);

        student1.createSpecificStudentPresentOrAbsent(400, 1, "04/05/2026", 1, 0);
        student1.createSpecificStudentPresentOrAbsent(400, 1, "05/05/2026", 1, 0);
        student1.createSpecificStudentPresentOrAbsent(400, 1, "06/05/2026", 0, 1);
        student1.createSpecificStudentPresentOrAbsent(400, 1, "07/05/2026", 0, 1);
        student1.createSpecificStudentPresentOrAbsent(400, 1, "07/05/2026", 0, 1);

        student1.printSpecificStudentPresentOrAbsent(400, 1);
//        System.out.println(student1.valitedSpecificPresentOrAbsent(400, 1, "08/05/2026"));
        student1.printSpecificStudentTotalPresentOrAbsent(400, 1);

        student1.printSpecificStudentPresentOrAbsentWithoutParam();



//        System.out.println(student1.returnBimonthlyAvgOfStudent(400));

//        Student student2 = new Student();
//        student2.createStudent("1504", "Igor", "Melo", "de Oliveira");
//        student2.CreateGradeOfStudent(401, 1, 1, 3.5);
//        student2.CreateGradeOfStudent(401, 2, 2, 6);
//        student2.printGradeList();

//        Student student3 = new Student();
//        student3.printStudent();

        Student student4 = new Student();
        student4.createStudent(1, "Igor", "Melo", "de Oliveira");

        Teacher teacher = new Teacher();
        teacher.createTeacher(1, 1,"Isadora", "dos Santos", "Silva");
        teacher.createTeacher(2, 2,"Márcia", "Souza", "Soares");
        teacher.createTeacher(2, 2,"Márcia", "Souza", "Soares");
        teacher.printTeachers();

        Student student5 = new Student();
        student5.createStudent(2, "Helias", "Silva", "Soares");

        Student student6 = new Student();
        student6.createStudent(2, "Solange", "Couto", "Martins");

        student1.showStudentAndTeacherClass();

        Student student7 = new Student();
        student7.findStudent("Romualdo", "Ferreira", "da Silva");

        Teacher teacher1 = new Teacher();
        teacher1.findTeacher("Isadora", "dos Santos", "Silva");
        student7.writeSubjectTextsOfStudents(400, 70000, "18/05/2026", "Aula sobre frações: Soma, divisão, multiplicação, subtração");
        student7.printWriteSubjectTextOfStudent();

//        System.out.println(student7.formatsubjectTextOfStudents("A casa de papel caiu em cima de mim e blabla", 16));


//        System.out.println(teacher.chechingTeacher(1, 1,"Isadora", "dos Santos", "Silva"));


//        System.out.println(student3.CheckingSpecificName("Romualdo", "Ferreira", "da Silva"));
    }

}
