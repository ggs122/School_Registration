package br.com.javainsider.Enrollment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Teacher implements AllInterfacesOfTeacher{

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

    private static final Logger LOGGER = LoggerFactory.getLogger("Enrollment.Teacher");

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

    @Override
    public void createTeacher(int teacherClass, int chooseSubjectTeacher, String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        Teacher teacher = new Teacher(staticId++, teacherEnrollmentStatic++, TeacherUtils.returTeacherClass(teacherClass), returnSubjectTeacher(chooseSubjectTeacher), teacherFirstName.trim(), teacherMidlleName.trim(), teacherLastName.trim());
        if (checkingTeacher(teacherClass, chooseSubjectTeacher, teacherFirstName, teacherMidlleName, teacherLastName) == false) {
            teachersList.add(teacher);
            teacher.teacherLogger();
        }
    }

    private void teacherLogger() {

        LOGGER.info("Criado o objeto da professora e atribuído ao espaço da memória.");
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

    @Override
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
    public void findTeacher(String teacherFirstName, String teacherMidlleName, String teacherLastName) {
        IO.println("----------------------------------------------------------------------------------------");
        IO.println("Busca de professores por nome:");
        IO.println();
        Locale localeBr = Locale.forLanguageTag("pt-BR");
       boolean booleanFoundTeacher = teachersList
                .stream()
                .anyMatch(t ->
                                t.getTeacherFirstName().equalsIgnoreCase(teacherFirstName) &&
                                t.getTeacherMidlleName().equalsIgnoreCase(teacherMidlleName) &&
                                t.getTeacherLastName().equalsIgnoreCase(teacherLastName)
                        );

       if (booleanFoundTeacher) {
           IO.println("Professor(a) encontrado!");
           IO.println();
           teachersList
                   .stream()
                   .filter(t ->
                                          t.getTeacherFirstName().equalsIgnoreCase(teacherFirstName) &&
                                           t.getTeacherMidlleName().equalsIgnoreCase(teacherMidlleName) &&
                                           t.getTeacherLastName().equalsIgnoreCase(teacherLastName)
                           )
                   .forEach(t -> IO.println(t));
           IO.println("----------------------------------------------------------------------------------------");
       } else {
           IO.println(String.format(localeBr, "Professor(a) %s %s %s -> Não foi encontrado(a) no banco de dados", teacherFirstName, teacherMidlleName, teacherLastName));
           IO.println("----------------------------------------------------------------------------------------");
       }
    }

    public void teacherLog() {
        Locale localeBr = Locale.forLanguageTag("pt-BR");
        File file = new File("TeacherList");

        if (!file.exists()) {
            file.mkdir();
        }

        try(BufferedWriter bft = new BufferedWriter(new FileWriter("TeacherList/teacherList.txt"))) {
            bft.write("Lista de professores da Escola:\n");
            bft.newLine();

          Map<String, Map<SubjectTeacher, List< String>>> teacherListMap = teachersList
                    .stream()
                  .collect(Collectors.groupingBy(
                          Teacher::getTeacherClass,
                          Collectors.groupingBy(
                                  Teacher::getSubjectTeacher,
                                  Collectors.mapping(Teacher::getTeacherFirstName, Collectors.toList())

                          )
                  ));

          teacherListMap
                  .forEach((c, st) -> {
                      try {
                          bft.write(String.format(localeBr, "Turma: %s\n",c));

                          st.forEach((s, t) -> {
                              try {
                                  bft.write(String.format(localeBr, "Matéria: %-10s | Professora %s\n", s, t));
                                  bft.newLine();
                              } catch (IOException e) {
                                  throw new RuntimeException(e);
                              }
                          });


                      } catch (IOException e) {
                          throw new RuntimeException(e);
                      }
                  });


        } catch (IOException i) {

        }
    }

    @Override
    public String toString() {
        Locale localeBr = Locale.of("pt", "BR");
        return String.format(localeBr, "Id: %d | Matrícula: %d | Nome: %-10s %-10s %-10s | Turma: %s | Matéria: %-15s ", id, teacherEnrollment, teacherFirstName, teacherMidlleName, teacherLastName, teacherClass, subjectTeacher);
    }
}
