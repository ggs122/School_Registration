package br.com.javainsider.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Teacher {

    protected enum SubjectTeacher {
        MATEMÁTICA, HISTÓRIA, CIÊNCIAS, GEOGRAFIA, OPÇÃO_INVÁLIDA
    }

    private long id = staticId;
    private static long staticId = 50000;

    private long teacherEnrollment = teacherEnrollmentStatic;
    private static long teacherEnrollmentStatic = 70000;

    private String teacherClass;

    private SubjectTeacher subjectTeacher;

    private String teacherFirstName;
    private String teacherMidlleName;
    private String teacherLastName;

    static List<Teacher> teachersList = new ArrayList<>();

    private Teacher(long id, long teacherEnrollment, String teacherClass, SubjectTeacher subjectTeacher, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        this.id = id;
        this.teacherEnrollment = teacherEnrollment;
        this.teacherClass = teacherClass;
        this.subjectTeacher = subjectTeacher;
        this.teacherFirstName = teacherFirstName;
        this.teacherMidlleName = teacherMidlleName;
        this.teacherLastName = teacherLastName;
    }

    public Teacher() {}

    protected long getTeacherEnrollment() {
        return teacherEnrollment;
    }

    protected String getTeacherClass() {
        return teacherClass;
    }

    protected SubjectTeacher getSubjectTeacher() {
        return subjectTeacher;
    }

    protected String getTeacherFirstName() {
        return teacherFirstName;
    }

    protected String getTeacherMidlleName() {
        return teacherMidlleName;
    }

    protected String getTeacherLastName() {
        return teacherLastName;
    }

    protected static List<Teacher> getTeachersList() {
        return teachersList;
    }

    public void createTeacher(int teacherClass, int chooseSubjectTeacher, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        Teacher teacher = new Teacher(staticId++, teacherEnrollmentStatic++, TeacherUtils.returTeacherClass(teacherClass), returnSubjectTeacher(chooseSubjectTeacher), teacherFirstName.trim(), teacherMidlleName.trim(), teacherLastName.trim());
        if (checkingTeacher(teacherClass, chooseSubjectTeacher, teacherFirstName, teacherMidlleName, teacherLastName) == false) {
            teachersList.add(teacher);
        }

    }

    private SubjectTeacher returnSubjectTeacher(int chooseSubjectTeacher) {
        return switch (chooseSubjectTeacher) {
            case 1 -> SubjectTeacher.MATEMÁTICA;
            case 2 -> SubjectTeacher.HISTÓRIA;
            case 3 -> SubjectTeacher.CIÊNCIAS;
            case 4 -> SubjectTeacher.GEOGRAFIA;
            default -> SubjectTeacher.OPÇÃO_INVÁLIDA;
        };
    }

    private boolean checkingTeacher(int teacherClass, int chooseSubjectTeacher, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        Locale localeBR = Locale.of("pt", "BR");
       boolean sameTeacherName = teachersList
                .stream()
                .anyMatch(s ->
                                s.teacherClass == TeacherUtils.returTeacherClass(teacherClass) &&
                                s.subjectTeacher.equals(returnSubjectTeacher(chooseSubjectTeacher)) &&
                                s.teacherFirstName.equalsIgnoreCase(teacherFirstName.trim()) &&
                                s.teacherMidlleName.equalsIgnoreCase(teacherMidlleName.trim()) &&
                                s.teacherLastName.equalsIgnoreCase(teacherLastName.trim())
                        );

       if (sameTeacherName == true) {
           IO.println("----------------------------------------------------------------------------------------");
           IO.println(String.format(localeBR, "Ops!! Professor(a): %s %s %s -> Já cadastrado(a) anteriormente!", teacherFirstName, teacherMidlleName, teacherLastName));
           IO.println("----------------------------------------------------------------------------------------");
       } else {
           if (sameTeacherName == false) {
               IO.println("----------------------------------------------------------------------------------------");
               IO.println(String.format(localeBR, "Professor(a): %s %s %s -> Cadastrado(a) com sucesso!", teacherFirstName, teacherMidlleName, teacherLastName));
               IO.println("----------------------------------------------------------------------------------------");
           }
       }

       return sameTeacherName;
    }

    public void printTeachers() {
        if (!teachersList.isEmpty()) {
            IO.println("----------------------------------------------------------------------------------------");
            IO.println("Professores cadastrados:");
            teachersList
                    .stream()
                    .forEach(t -> IO.println(t));
            IO.println("----------------------------------------------------------------------------------------");
        } else {
            if (teachersList.isEmpty()) {
                IO.println("----------------------------------------------------------------------------------------");
                IO.println("Nada a mostrar -> Nenhum professor cadastrado!");
                IO.println("----------------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public String toString() {
        Locale localeBr = Locale.of("pt", "BR");
        return String.format(localeBr, "Id: %d | Matrícula: %d | Nome: %-10s %-10s %-10s | Turma: %s | Matéria: %-15s ", id, teacherEnrollment, teacherFirstName, teacherMidlleName, teacherLastName, teacherClass, subjectTeacher);
    }
}
