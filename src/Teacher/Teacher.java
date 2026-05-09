package Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Teacher {

    private long id = staticId;
    private static long staticId = 50000;

    private long teacherEnrollment = teacherEnrollmentStatic;
    private static long teacherEnrollmentStatic = 70000;

    private String teacherClass;

    private String teacherFirstName;
    private String teacherMidlleName;
    private String teacherLastName;

    static List<Teacher> teachersList = new ArrayList<>();

    private Teacher(long id, long teacherEnrollment, String teacherClass, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        this.id = id;
        this.teacherEnrollment = teacherEnrollment;
        this.teacherClass = teacherClass;
        this.teacherFirstName = teacherFirstName;
        this.teacherMidlleName = teacherMidlleName;
        this.teacherLastName = teacherLastName;
    }

    public Teacher() {}

    public void createTeacher(int teacherClass, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        Teacher teacher = new Teacher(staticId++, teacherEnrollmentStatic++, TeacherUtils.returTeacherClass(teacherClass), teacherFirstName, teacherMidlleName, teacherLastName);
        teachersList.add(teacher);
    }

    public void printTeachers() {
        teachersList
                .stream()
                .forEach(t -> IO.println(t));
    }

    @Override
    public String toString() {
        Locale localeBr = Locale.of("pt", "BR");
        return String.format(localeBr, "Id: %d | Matrícula: %d | Turma: %s | Nome: %s %s %s", id, teacherEnrollment, teacherClass, teacherFirstName, teacherMidlleName, teacherLastName);
    }
}
