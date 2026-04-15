import Student.Student;

public class AppTest1 {


    static void main(String[] args) {

        Student student1 = new Student();
        student1.createStudent("1504", "Romualdo", "Ferreira", "da Silva");

        Student student2 = new Student();
        student2.createStudent("1504", "Igor", "Melo", "de Oliveira");

        Student student3 = new Student();
        student3.printStudent();

        Student student4 = new Student();
        student4.createStudent("1504", "Igor", "Melo", "de Oliveira");

//        System.out.println(student3.CheckingSpecificName("Romualdo", "Ferreira", "da Silva"));
    }

}
