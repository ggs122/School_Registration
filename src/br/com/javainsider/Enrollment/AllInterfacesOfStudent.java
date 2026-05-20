package br.com.javainsider.Enrollment;

public interface AllInterfacesOfStudent {

    void createStudent(int studentClass, String studentFirstName, String studentMidlleName, String studentLastName);

    void CreateGradeOfStudent(long studentEnrollment, int bimonthly, int subject, int gradeType ,double studentGrade);

    void createSpecificStudentPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent, String datePresentOrAbsent, int studentPresent, int studentAbsent);

    void printSpecificStudentPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent);

    void printSpecificStudentPresentOrAbsentWithoutParam();

    void printSpecificStudentTotalPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent);

    void printGradeList();

    void printStudentSpecificGradeListForStudentEnrollmentAndBiomonthly(long studentEnrollment, int bimonthly);

    void printSTudentSpecificGradeForEnrollMentAndSubject(long studentEnrollment, int subject);

    void printStudentBimonthlyAvgForSubject(long studentEnrollment, int subject);

    void showStudentAndTeacherClass();

    void findStudent(String studentFirstName, String studentMidlleName, String studentLastName);

    void writeSubjectTextsOfStudents(long studentEnrollment, long teacherEnrollment, String studentOrderNumberSubjectTextOfNumberLocalDate, String subjectTextOfStudents);

    void printWriteSubjectTextOfStudent();

}
