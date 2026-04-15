package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Student {

    // id -> id do aluno.
    private long id = staticId;
    private static  long staticId = 10000;

    // studentEnrollment -> Matrícula do aluno.
    private long studentEnrollment = staticStudentEnrollment;
    private static long staticStudentEnrollment = 400;

    private String studentClass;

    private String studentFirstName;
    private String studentMidlleName;
    private String studentLastName;
    private double studentGrade;
    private double studentAvgQuarter;

    private double studentFinalAnualGrade;

    private String teachersStudentFirstName;
    private String teachersStudentMidlleName;
    private String teachersStudentLastName;

    // studentPresent -> Presenças do aluno.
    private int studentPresent;
    // studentAbsent -> Faltas do aluno.
    private int studentAbsent;
    // tardy -> atrasos do aluno.
    private int studentTardy;

    static List<Student> studentsList = new ArrayList<>();

    private Student(long id, long studentEnrollment, String studentClass, String studentFirstName, String studentMidlleName, String studentLastName) {
        this.id = id;
        this.studentEnrollment = studentEnrollment;
        this.studentClass = studentClass;
        this.studentFirstName = studentFirstName;
        this.studentMidlleName = studentMidlleName;
        this.studentLastName = studentLastName;
    }

    private Student(long studentEnrollment, double studentGrade) {
            this.studentEnrollment = studentEnrollment;
            this.studentGrade = studentGrade;
    }

    private Student(long id, long studentEnrollment, double studentAvgQuarter) {
        this.id = id;
        this.studentEnrollment = studentEnrollment;
        this.studentAvgQuarter = studentAvgQuarter;
    }

    private Student(long studentEnrollment, String studentFirstName, String studentMidlleName, String studentLastName, String teachersStudentFirstName, String teachersStudentMidlleName, String teachersStudentLastName) {
        this.studentEnrollment = studentEnrollment;
        this.studentFirstName = studentFirstName;
        this.studentMidlleName = studentMidlleName;
        this.studentLastName = studentLastName;
        this.teachersStudentFirstName = teachersStudentFirstName;
        this.teachersStudentMidlleName = teachersStudentMidlleName;
        this.teachersStudentLastName = teachersStudentLastName;
    }

    private Student(long studentEnrollment, int studentPresent, int studentAbsent, int studentTardy) {
        this.studentEnrollment = studentEnrollment;
        this.studentPresent = studentPresent;
        this.studentAbsent = studentAbsent;
        this.studentTardy = studentTardy;
    }

    public Student() {}

    protected long getId() {
        return id;
    }

    protected long getStudentEnrollment() {
        return studentEnrollment;
    }

    protected String getStudentClass() {
        return studentClass;
    }

    protected String getStudentFirstName() {
        return studentFirstName;
    }

    protected String getStudentMidlleName() {
        return studentMidlleName;
    }

    protected String getStudentLastName() {
        return studentLastName;
    }

    protected String getTeachersStudentFirstName() {
        return teachersStudentFirstName;
    }

    protected String getTeachersStudentMidlleName() {
        return teachersStudentMidlleName;
    }

    protected String getTeachersStudentLasttName() {
        return teachersStudentLastName;
    }

    protected double getStudentGrade() {
        return studentGrade;
    }

    protected double getStudentAvgQuarter() {
        return studentAvgQuarter;
    }

    protected double getStudentFinalAnualGrade() {
        return studentFinalAnualGrade;
    }

    protected int getStudentPresent() {
        return studentPresent;
    }

    protected int getStudentAbsent() {
        return studentAbsent;
    }

    protected int getStudentTardy() {
        return studentTardy;
    }

    protected List<Student> getStudentsList() {
        return studentsList;
    }

    public void createStudent(String studentClass, String studentFirstName, String studentMidlleName, String studentLastName) {
        boolean studentClassBoolean = studentClass.matches("[0-9]{4}");
        if (studentClassBoolean == true) {
            Student student = new Student(staticId++, staticStudentEnrollment++, studentClass, studentFirstName.trim().toUpperCase(), studentMidlleName.trim().toUpperCase(), studentLastName.trim().toUpperCase());
            studentsList.add(student);
        } else if (studentClassBoolean == false) {
            IO.println("Número da turma só aceita 4 dígitos.\nEx: 0000\nNão confere com " + studentClass + " que foi digitado.");
        }
    }

    public void printStudent() {

        if (!studentsList.isEmpty()) {
            IO.println("Dados dos Alunos:");
            studentsList
                    .stream()
                    .forEach(s -> IO.println(s));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return id == student.id && studentEnrollment == student.studentEnrollment && Double.compare(studentGrade, student.studentGrade) == 0 && Double.compare(studentAvgQuarter, student.studentAvgQuarter) == 0 && Double.compare(studentFinalAnualGrade, student.studentFinalAnualGrade) == 0 && studentPresent == student.studentPresent && studentAbsent == student.studentAbsent && studentTardy == student.studentTardy && Objects.equals(studentClass, student.studentClass) && Objects.equals(studentFirstName, student.studentFirstName) && Objects.equals(studentMidlleName, student.studentMidlleName) && Objects.equals(studentLastName, student.studentLastName) && Objects.equals(teachersStudentFirstName, student.teachersStudentFirstName) && Objects.equals(teachersStudentMidlleName, student.teachersStudentMidlleName) && Objects.equals(teachersStudentLastName, student.teachersStudentLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentEnrollment, studentClass, studentFirstName, studentMidlleName, studentLastName, studentGrade, studentAvgQuarter, studentFinalAnualGrade, teachersStudentFirstName, teachersStudentMidlleName, teachersStudentLastName, studentPresent, studentAbsent, studentTardy);
    }

    @Override
    public String toString() {
        Locale localeBR = Locale.of("pt", "BR");
        return String.format(localeBR, "Id: %d | Matrícula: %d | Turma: %s | Aluno: %-15s %-15s %-15s | Notas: %.2f | Bimestre: %.2f | Nota Final: %.2f | Professora: %s %s %s | Presença: %d | Falta: %d | Atrasos: %d", id, studentEnrollment, studentClass, studentFirstName, studentMidlleName, studentLastName, studentGrade, studentAvgQuarter, studentFinalAnualGrade, teachersStudentFirstName, teachersStudentMidlleName, teachersStudentLastName, studentPresent, studentAbsent, studentTardy);
    }
}
