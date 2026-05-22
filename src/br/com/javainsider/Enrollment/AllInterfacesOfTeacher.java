package br.com.javainsider.Enrollment;

public interface AllInterfacesOfTeacher {

    void createTeacher(int teacherClass, int chooseSubjectTeacher, String teacherFirstName, String teacherMidlleName, String teacherLastName);

    void printTeachers();

    void findTeacher(String teacherFirstName, String teacherMidlleName, String teacherLastName);

}
