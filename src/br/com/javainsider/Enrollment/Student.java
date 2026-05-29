package br.com.javainsider.Enrollment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student implements AllInterfacesOfStudent {

    protected enum Subject {
        MATEMÁTICA, HISTÓRIA, CIÊNCIAS, GEOGRAFIA, OPÇÃO_INVÁLIDA
    }

    protected enum GradeType {
        COMPORTAMENTO, PARTICIPAÇÃO, ATIVIDADES_DE_CASA, TESTE, PROVA, OPÇÃO_INVÁLIDA
    }

    // id -> id do aluno.
    private long id = staticId;
    private static  long staticId = 10000;

    // studentEnrollment -> Matrícula do aluno.
    private long studentEnrollment = staticStudentEnrollment;
    private static long staticStudentEnrollment = 400;

    private long studentOrderNumberSubjectTextOfNumber = studentOrderNumberSubjectTextOfNumberStatic;
    private static long studentOrderNumberSubjectTextOfNumberStatic = 1;

    private LocalDate studentOrderNumberSubjectTextOfNumberLocalDate;

    private Subject subject;
    private GradeType gradeType;

    private String studentClass;

    private String studentFirstName;
    private String studentMidlleName;
    private String studentLastName;
    private double studentGrade;
    private double studentAvgQuarter;


    private int bimonthly;
    private int bimonthlyAvg;
    private int bimonthlyPresentOrAbsentForStaticMethod;
    private Subject subjectBimonthlyAvg;
    private double studentBimonthlyAvg;

    private double studentFinalAnualGrade;

    private String teachersStudentFirstName = "Cadastre";
    private String teachersStudentMidlleName = "um";
    private String teachersStudentLastName = "nome";
    private Teacher.SubjectTeacher subjectTeacher;

    // studentPresent -> Presenças do aluno.
    private int studentPresent;
    // studentAbsent -> Faltas do aluno.
    private int studentAbsent;

    private int bimonthlyPresentOrAbsent;

    private LocalDate dateOfPresentOrAbsent;
    // tardy -> atrasos do aluno.
    private int studentTardy;

    private StringBuilder subjectTextOfStudents;

    private static final Logger LOGGER = LoggerFactory.getLogger("Enrollment.Student");

    static List<Student> studentsList = new ArrayList<>();
    static List<Student> studentGradeList = new ArrayList<>();
    static List<Student> studentOldGradeList = new ArrayList<>();
    static List<Student> studentBimonthlyAvgList = new ArrayList<>();
    static List<Student> studentPresentOrAbsentList = new ArrayList<>();
    static List<Student> bimonthlyPresentOrAbsentForMethod = new ArrayList<>();
    static List<Teacher> teachersList = Teacher.getTeachersList();
    static List<Student> subjectTextsOfStudentList = new ArrayList<>();

    private Student(long id, long studentEnrollment, String studentClass, String studentFirstName, String studentMidlleName, String studentLastName) {
        this.id = id;
        this.studentEnrollment = studentEnrollment;
        this.studentClass = studentClass;
        this.studentFirstName = studentFirstName;
        this.studentMidlleName = studentMidlleName;
        this.studentLastName = studentLastName;
    }

    private Student(long studentEnrollment, int bimonthly, Subject subject, GradeType gradeType, double studentGrade) {
            this.studentEnrollment = studentEnrollment;
            this.bimonthly = bimonthly;
            this.subject = subject;
            this.gradeType = gradeType;
            this.studentGrade = studentGrade;
    }

    private Student(long studentEnrollment, Subject subject, int bimonthlyAvg, double studentBimonthlyAvg) {
        this.studentEnrollment = studentEnrollment;
        this.subjectBimonthlyAvg = subject;
        this.bimonthlyAvg = bimonthlyAvg;
        this.studentBimonthlyAvg = studentBimonthlyAvg;
    }

    private Student( long studentOrderNumberSubjectTextOfNumber, LocalDate studentOrderNumberSubjectTextOfNumberLocalDate, long studentEnrollment, String studentFirstName, String studentMidlleName, String studentLastName, String teachersStudentFirstName, String teachersStudentMidlleName, String teachersStudentLastName, Teacher.SubjectTeacher teacherSubject, StringBuilder subjectTextOfStudents) {
        this.studentEnrollment = studentEnrollment;
        this.studentFirstName = studentFirstName;
        this.studentMidlleName = studentMidlleName;
        this.studentLastName = studentLastName;
        this.teachersStudentFirstName = teachersStudentFirstName;
        this.teachersStudentMidlleName = teachersStudentMidlleName;
        this.teachersStudentLastName = teachersStudentLastName;
        this.subjectTeacher = teacherSubject;
        this.subjectTextOfStudents = subjectTextOfStudents;
        this.studentOrderNumberSubjectTextOfNumber = studentOrderNumberSubjectTextOfNumber;
        this.studentOrderNumberSubjectTextOfNumberLocalDate = studentOrderNumberSubjectTextOfNumberLocalDate;

    }

    private Student(long studentEnrollment, int bimonthlyPresentOrAbsent, LocalDate dateOfPresentOrAbsent, int studentPresent, int studentAbsent) {
        this.studentEnrollment = studentEnrollment;
        this.bimonthlyPresentOrAbsent = bimonthlyPresentOrAbsent;
        this.dateOfPresentOrAbsent = dateOfPresentOrAbsent;
        this.studentPresent = studentPresent;
        this.studentAbsent = studentAbsent;
    }

    private Student(int bimonthlyPresentOrAbsentForStaticMethod) {
        this.bimonthlyPresentOrAbsentForStaticMethod = bimonthlyPresentOrAbsentForStaticMethod;
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

//    protected String getTeachersStudentFirstName() {
//        return teachersStudentFirstName;
//    }
//
//    protected String getTeachersStudentMidlleName() {
//        return teachersStudentMidlleName;
//    }
//
//    protected String getTeachersStudentLasttName() {
//        return teachersStudentLastName;
//    }

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

    @Override
    public void createStudent(int studentClass, String studentFirstName, String studentMidlleName, String studentLastName) {
        Locale localeBr = Locale.of("pt", "BR");
        Student student1 = new Student();

        if (student1.CheckingSpecificName(studentFirstName, studentMidlleName, studentLastName) == false) {
            Student student2 = new Student(staticId++, staticStudentEnrollment++, StudentUtils.returnStudentClass(studentClass), studentFirstName.trim().toUpperCase(), studentMidlleName.trim().toUpperCase(), studentLastName.trim().toUpperCase());
            studentsList.add(student2);
            IO.println("--------------------------------------------------------------------------------------------");
            IO.println(String.format("Aluno %s %s %s, criado com sucesso!", student2.studentFirstName, student2.studentMidlleName, student2.studentLastName));
            student2.loggerInfo();
            IO.println("--------------------------------------------------------------------------------------------");
        } else if (student1.CheckingSpecificName(studentFirstName, studentMidlleName, studentLastName) == true) {
            IO.println("--------------------------------------------------------------------------------------------");
            IO.println(String.format(localeBr, "O aluno: %s %s %s, já foi cadastrado anteriormente no sistema", studentFirstName.trim().toUpperCase(), studentMidlleName.trim().toUpperCase(), studentLastName.trim().toUpperCase()));
            IO.println("--------------------------------------------------------------------------------------------");
        }
    }

    private void loggerInfo() {
        IO.println("---------------------------------------------------------------");
        LOGGER.info("Foi gerado o objeto do aluno e atribuído ao espaço da memória.");
        IO.println("---------------------------------------------------------------");
    }

    public void studentLog() {

        File file = new File("StudentsList");

        if (!file.exists()) {
            file.mkdir();
        }

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter("StudentsList/studentsList.txt"))) {
            Locale localeBr = Locale.forLanguageTag("pt-BR");
            bfw.write("Lista de Estudantes da Escola:");
            bfw.newLine();
            bfw.newLine();

           for(var s : studentsList) {
               bfw.write(s.toString().concat("\n"));

               Map<Integer, List<Double>> bimonthlyWithGrades = new HashMap<>();

               List<Double> studentOldGradeListGrades = studentOldGradeList
                       .stream()
                       .filter(st -> st.studentEnrollment == s.studentEnrollment)
                       .mapToDouble(st -> st.studentGrade)
                       .boxed()
                       .toList();

               studentOldGradeList
                       .stream()
                       .filter(sto -> sto.studentEnrollment == s.studentEnrollment)
                       .forEach(sto -> {
                           bimonthlyWithGrades.put(sto.bimonthly, studentOldGradeListGrades);
                       });

               

           }


//            studentsList
//                    .forEach(s -> {
//                        try {
//                            bfw.write(s.toString().concat("\n"));
//                            bfw.newLine();
//                            studentOldGradeList
//                                    .stream()
//                                    .filter(st -> st.studentEnrollment == s.studentEnrollment)
//                                    .forEach(st -> {
//                                        try {
//                                            bfw.write(String.format(localeBr, "Nota: %-8.2f Bimestre: %dº | Matéria: %s | Atividade: %s", st.studentGrade, st.bimonthly, st.subject, st.gradeType));
//                                            bfw.newLine();
//                                            bfw.newLine();
//                                        } catch (IOException e) {
//                                            throw new RuntimeException(e);
//                                        }
//                                    });
//                        } catch (IOException e) {
//
//                        }
//                        try {
//
//                            bfw.write("Média por Bimestre:\n");
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                        studentBimonthlyAvgList
//                                .stream()
//                                .filter(st -> st.studentEnrollment == s.studentEnrollment)
//                                .forEach(st -> {
//                                    try {
//                                        bfw.write(String.format(localeBr,"Bimestre: %dº | Média: %.2f", st.bimonthlyAvg, st.studentBimonthlyAvg).concat("\n"));
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                });
//                        try {
//                            bfw.newLine();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    private boolean CheckingSpecificName(String studentFirstName, String studentMidlleName, String studentLastName) {
      boolean booleanEqualsStudentName = studentsList
                .stream()
                .anyMatch(s ->
                                s.studentFirstName.equalsIgnoreCase(studentFirstName) &&
                                s.studentMidlleName.equalsIgnoreCase(studentMidlleName) &&
                                s.studentLastName.equalsIgnoreCase(studentLastName)
                        );
      return booleanEqualsStudentName;
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
    public void CreateGradeOfStudent(long studentEnrollment, int bimonthly, int subject, int gradeType ,double studentGrade) {

      boolean studentEnrollmentFoundBoolean = studentsList
                .stream()
                .anyMatch(s -> s.studentEnrollment == studentEnrollment);

      if (studentEnrollmentFoundBoolean == true && checkingGradeOfStudent(studentEnrollment, bimonthly, subject, gradeType) == false) {
          Student newGrade = new Student(studentEnrollment, bimonthly, StudentUtils.returnSubject(subject), StudentUtils.returnGradeType(gradeType), studentGrade);
          studentGradeList.add(newGrade);
          studentOldGradeList.add(newGrade);
         long countGrades = studentGradeList
                  .stream()
                          .filter(s -> s.studentEnrollment == studentEnrollment)
                                  .count();

          IO.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
          Locale localeBr = Locale.of("pt", "BR");
          studentsList
                  .stream()
                  .filter(s -> s.studentEnrollment == studentEnrollment)
                  .findFirst()
                  .ifPresent(s ->
                          IO.println(
                                  String.format(localeBr, "Aluno: %s %s %s\nMatrícula Nº: %d", s.getStudentFirstName(), s.getStudentMidlleName(), s.getStudentLastName(), s.studentEnrollment)
                          ));

          IO.println(String.format(localeBr, "Nota: %.1f | Atividade: %s | Matéria: %s", newGrade.studentGrade, newGrade.gradeType, newGrade.subject));
          IO.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
          if (countGrades == 5) {
              createBimonthlyAvgOfStudent(studentEnrollment, subject, bimonthly);
              IO.println(">>> Sistema: 5 notas atingidas. Média bimestral gerada com sucesso!");
              IO.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
          }

      } else if (studentEnrollmentFoundBoolean == false){
          Locale localeBr = Locale.of("pt", "BR");
          IO.println("------------------------------------------------------------------------------------------------------");
          IO.println(String.format(localeBr, "Matrícula Nº %d, inexistente e por isso não é possível adicionar a nota %.2f do aluno.", studentEnrollment, studentGrade));
          IO.println("------------------------------------------------------------------------------------------------------");
      }
    }

    @Override
    public void createSpecificStudentPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent, String datePresentOrAbsent, int studentPresent, int studentAbsent) {
        boolean foundStudent = studentsList
                .stream()
                .anyMatch(s -> s.studentEnrollment == studentEnrollment);


        boolean foundStudentBimonthlyAgvList = studentBimonthlyAvgList
               .stream()
               .anyMatch(s ->
                       s.studentEnrollment == studentEnrollment &&
                               StudentUtils.returnBimonthly(bimonthlyPresentOrAbsent) == bimonthlyPresentOrAbsent
                       );
        if (foundStudent == true && foundStudentBimonthlyAgvList == true && valitedSpecificPresentOrAbsent(studentEnrollment, bimonthlyPresentOrAbsent, datePresentOrAbsent) == false) {
            IO.println("-----------------------------------------------------------------------");
            IO.println("Aluno encontrado e bimestre da respectiva média encontados com sucesso!");
            IO.println("-----------------------------------------------------------------------");

            try {
             LocalDate dateFormated = LocalDate.parse(datePresentOrAbsent, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
             Student student = new Student(studentEnrollment, bimonthlyPresentOrAbsent, dateFormated, studentPresent, studentAbsent);
             studentPresentOrAbsentList.add(student);
         } catch (Exception e) {
             IO.println("Ops! Erro! Data formato inválido");
         }

        } else {
            if (foundStudent == false && foundStudentBimonthlyAgvList == false) {
                IO.println("-----------------------------------------------------------------------");
                IO.println("Aluno e bimestre da respectiva média não encontrados");
                IO.println("-----------------------------------------------------------------------");
            }
        }
    }

    private boolean valitedSpecificPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent, String datePresentOrAbsent) {
        boolean chechking = true;
        Locale localeBr = Locale.of("pt", "BR");
        LocalDate dateFormated = LocalDate.parse(datePresentOrAbsent, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       chechking = studentPresentOrAbsentList
                .stream()
                .anyMatch(s ->
                    s.studentEnrollment == studentEnrollment &&
                            s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent &&
                            s.dateOfPresentOrAbsent.equals(dateFormated)
                );

       if (chechking == true) {
           IO.println("-----------------------------------------------------------------------------------------------------------------------------");
           studentPresentOrAbsentList
                   .stream()
                   .filter(s ->
                           s.studentEnrollment == studentEnrollment &&
                                   s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent &&
                                   s.dateOfPresentOrAbsent.equals(dateFormated)
                   ).forEach(s -> IO.println(String.format(localeBr, "Matrícula: %d | Bimestre: %dº | Dia: %3$td, %3$-15tA, %3$tB, %3$tY -> Presença já cadastrada anteriormente!", s.studentEnrollment, s.bimonthlyPresentOrAbsent, s.dateOfPresentOrAbsent)));
           IO.println("-----------------------------------------------------------------------------------------------------------------------------");

       } else {
           if (chechking == false) {
               IO.println("-----------------------------------------------------------------------------------------------------------------------------");
               IO.println("Presença cadastrada com sucesso!");
               IO.println("-----------------------------------------------------------------------------------------------------------------------------");
           }
       }

       return chechking;
    }

    @Override
    public void printSpecificStudentPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent) {
        if (!studentPresentOrAbsentList.isEmpty()) {
            IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
            IO.println("Busca de presenças por aluno:");
            IO.println();
            Locale localeBr = Locale.of("pt", "BR");
            studentsList
                    .stream()
                            .filter(s -> s.studentEnrollment == studentEnrollment)
                                    .forEach(s -> IO.println(String.format(localeBr, "Matrícula: %s", s.studentEnrollment)));
            IO.println();
            studentsList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .forEach(s -> IO.println(String.format(localeBr, "Aluno(a): %s %s %s", s.studentFirstName, s.studentMidlleName, s.studentLastName)));
            IO.println();
         List<Integer>  bimonthlyPresentOrAbsentIntegerList = studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                    .mapToInt(s -> s.bimonthlyPresentOrAbsent)
                    .distinct()
                    .boxed()
                    .toList();
            bimonthlyPresentOrAbsentIntegerList
                    .stream()
                            .filter(b -> b == bimonthlyPresentOrAbsent)
                                    .distinct()
                                            .forEach(b -> IO.println(String.format(localeBr, "Bimestre: %dº", b)));

            IO.println();

            studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                    .forEach(s -> IO.println(
                                    String.format(
                                            localeBr,

                                            "Dia: %1$td | Dia da semana: %1$15tA | Mês: %1$tB | Ano: %1$tY | Presença: %2$d | Falta: %3$d\n", s.dateOfPresentOrAbsent, s.studentPresent, s.studentAbsent
                                    )
                            )
                    );

            IO.println();
            IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void printSpecificStudentPresentOrAbsentWithoutParam() {
        if (!studentPresentOrAbsentList.isEmpty() && !studentsList.isEmpty()) {
            IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
            Locale localeBr = Locale.of("pt", "BR");
            IO.println("Presença de Todos os Alunos:");
            IO.println();
            List<Student> studentsListWithDistinct = studentsList
                    .stream()
                            .distinct()
                                    .toList();

          List<Integer> bimonthlyStudentPresentOrAbsentList = studentPresentOrAbsentList
                    .stream()
                            .mapToInt(s -> s.bimonthlyPresentOrAbsent)
                                    .distinct()
                                            .boxed()
                                                    .toList();

            studentsListWithDistinct
                    .forEach(sw -> {
                        studentsList
                                .stream()
                                .filter(s -> s.studentEnrollment == sw.studentEnrollment)
                                .forEach(s -> IO.println(String.format(localeBr, "Matrícula: %s\n\nAluno: %s %s %s", s.studentEnrollment, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
                        IO.println();

                        bimonthlyStudentPresentOrAbsentList
                                .forEach(b -> {
                                    studentPresentOrAbsentList
                                            .stream()
                                            .filter(s ->
                                                    s.studentEnrollment == sw.studentEnrollment && b == s.bimonthlyPresentOrAbsent
                                            )
                                            .map(s -> s.bimonthlyPresentOrAbsent)
                                            .distinct()
                                            .forEach(s -> IO.println(String.format(localeBr, "Bimestre: %dº", s)));
                                });
                        IO.println();
                        bimonthlyStudentPresentOrAbsentList
                                .forEach(b -> {
                                            studentPresentOrAbsentList
                                                    .stream()
                                                    .filter(s ->
                                                            s.studentEnrollment == sw.studentEnrollment && b == s.bimonthlyPresentOrAbsent
                                                    )
                                                    .forEach(s -> IO.println(String.format(localeBr, "Dia: %1$td | Dia da Semana: %1$-15tA | Mês: %1$tB | Ano: %1$tY | Presença: %2$d | Falta: %3$d\n", s.dateOfPresentOrAbsent, s.studentPresent, s.studentAbsent)));

                                        }
                                );
                        IO.println("--------------------------------------------------------------------------------------------------------------------------------------");

                    });
            }

    }

    @Override
    public void printSpecificStudentTotalPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent) {
        if (!studentPresentOrAbsentList.isEmpty() && !studentsList.isEmpty()) {
            IO.println("------------------------------------");
            IO.println("Total de presenças por bimestre: ");
            IO.println();
            Locale localeBr = Locale.of("pt", "BR");
            int presentTotal = studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                    .mapToInt(s -> s.studentPresent)
                    .sum();

            int absentTotal = studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                    .mapToInt(s -> s.studentAbsent)
                    .sum();

            studentsList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .forEach(s -> IO.println(String.format(localeBr,"Matrícula: %d", s.studentEnrollment)));
            IO.println();
            studentsList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .forEach(s -> IO.println(String.format(localeBr, "Aluno: %s %s %s", s.studentFirstName, s.studentMidlleName, s.studentLastName)));
            IO.println();
            int bPresentOrAbsent = studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                            .mapToInt(s -> s.bimonthlyPresentOrAbsent)
                                    .distinct()
                                            .sum();
            IO.println(String.format(localeBr, "Bimestre: %dº", bPresentOrAbsent));

            IO.println();
            IO.println(String.format(localeBr, "Total presenças: %d | Total faltas: %d", presentTotal, absentTotal));
            IO.println("------------------------------------");
        }
    }

    @Override
    public void printGradeList() {
        if (!studentOldGradeList.isEmpty()) {

           long gradeListLimit = studentOldGradeList
                    .stream()
                    .count();

            Locale localeBr = Locale.of("pt", "BR");
            IO.println("----------------------------------------------------------------------------");
            IO.println("Lista de notas de todos os alunos:");

            studentOldGradeList
                    .stream()
                    .forEach(s -> IO.println(String.format(localeBr, "Matrícula %d | Matéria: %-15s | Atividade: %-20s | Nota: %.1f", s.studentEnrollment, s.subject, s.gradeType, s.studentGrade)));
            IO.println("----------------------------------------------------------------------------");
        }
    }

    private boolean checkingGradeOfStudent(long studentEnrollment, int bimonthly, int subject,  int gradeType) {
        Locale localeBr = Locale.of("pt", "BR");
       boolean checkingGradeType = studentOldGradeList
                .stream()
                .anyMatch(s -> s.studentEnrollment == studentEnrollment &&
                        s.bimonthly == bimonthly &&
                        s.subject == StudentUtils.returnSubject(subject) &&
                        s.gradeType == StudentUtils.returnGradeType(gradeType));

       if (checkingGradeType == true) {
           for (var s : studentOldGradeList) {
               if (s.studentEnrollment == studentEnrollment && s.bimonthly == bimonthly && s.subject == StudentUtils.returnSubject(subject) && s.gradeType == StudentUtils.returnGradeType(gradeType)) {
                   IO.println("------------------------------------------------------------------------------------------------------------------");
                   IO.println(String.format(localeBr, "Atividade: %s | Bimestre: %dº |Matéria: %s -> já cadastrada anteriormente na matrícula: %d", s.gradeType, s.bimonthly, s.subject, s.studentEnrollment));
                   IO.println("------------------------------------------------------------------------------------------------------------------");
               }
           }
       } else if (checkingGradeType == false) {
           IO.println("---------------------------------------------------------------------------------------");
           IO.println("Nota cadastrada com sucesso!");
           IO.println("---------------------------------------------------------------------------------------");
       }
        return checkingGradeType;
    }

    @Override
    public void printStudentSpecificGradeListForStudentEnrollmentAndBiomonthly(long studentEnrollment, int bimonthly) {
        IO.println("----------------------------------------------------------------------");
        Locale localeBr = Locale.of("pt", "BR");
        if (!studentsList.isEmpty() && !studentOldGradeList.isEmpty()) {
            IO.println("Dados do aluno:");
            IO.println();
            studentsList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .forEach(s -> IO.println(String.format(localeBr,"Matrícula: %d\nTurma:     %s\nNome:      %s %s %s", s.studentEnrollment, s.studentClass, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
            IO.println();

       var selectedSubject = studentOldGradeList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .map(s -> s.subject)
                    .distinct()
                    .toList();

       selectedSubject
               .stream()
                       .forEach(s -> IO.println(String.format(localeBr, "Matéria: %s", s)));
       IO.println();

      var distinctList = studentOldGradeList
               .stream()
                       .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthly == bimonthly)
                               .map(s -> bimonthly)
                                       .distinct()
                                               .toList();
      IO.println();

      distinctList
              .stream()
                      .forEach(s -> IO.println(String.format(localeBr, "Bimestre: %dº ", s)));

IO.println();

       IO.println("Notas:");

            studentOldGradeList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthly == bimonthly)
                    .forEach(s -> IO.println(String.format(localeBr, "Atividade: %-20s | Nota: %.1f ", s.gradeType, s.studentGrade)));

            double rawAvg = 0.0;
            double sumGradesOfStudent = studentOldGradeList
                    .stream()
                    .filter(s -> s.studentEnrollment == s.studentEnrollment && s.bimonthly == bimonthly)
                    .mapToDouble(s -> s.studentGrade)
                    .sum();
            rawAvg = sumGradesOfStudent / 3;
            double localStudentAvg = Math.floor(rawAvg * 10) / 10;
            IO.println(String.format(localeBr, "Média: %.1f", localStudentAvg));
            IO.println("----------------------------------------------------------------------");
        } else if(studentsList.isEmpty() && studentOldGradeList.isEmpty()) {
            IO.println("Estudantes não cadastrados ou notas não cadastradas.");
        }
    }

    @Override
    public void printSTudentSpecificGradeForEnrollMentAndSubject(long studentEnrollment, int subject) {
        Locale localeBr = Locale.of("pt", "BR");
        IO.println("-------------------------------------------------------");
        if (!studentsList.isEmpty() && !studentOldGradeList.isEmpty()) {
            IO.println("MÉDIA GERAL DETALHADA POR MATÉRIA");
            IO.println();
            studentsList
                    .stream()
                    .filter(s -> s.studentEnrollment  == studentEnrollment)
                    .distinct()
                    .forEach(s -> IO.println(String.format(localeBr,"Matrícula: %d\nTurma:     %s\nNome:      %s %s %s", s.studentEnrollment, s.studentClass, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
            IO.println();
            var bimonthlyList = studentOldGradeList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.subject == StudentUtils.returnSubject(subject))
                    .map(s -> s.bimonthly)
                    .distinct()
                    .toList();

            var subjectChoosed = studentOldGradeList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.subject == StudentUtils.returnSubject(subject))
                    .map(s -> s.subject)
                    .distinct()
                    .toList();

            subjectChoosed
                    .stream()
                    .forEach(s -> IO.println(String.format(localeBr, "Matéria: %s", s)));
            IO.println();
            for (var b : bimonthlyList) {
                IO.println(String.format(localeBr, "Bimestre: %dº", b));

                var gradeBimonthly = studentOldGradeList
                        .stream()
                        .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthly == b && s.subject == StudentUtils.returnSubject(subject))
                        .toList();

                gradeBimonthly
                        .forEach(g ->
                                IO.println(String.format(localeBr, "Atividade: %-20s | Nota: %.1f ", g.gradeType, g.studentGrade))
                        );

                if (gradeBimonthly.size() == 5) {
                    double sumGrades = gradeBimonthly
                            .stream()
                            .mapToDouble(s -> s.studentGrade)
                            .sum();

                    double calculateAvg = sumGrades / 3;

                    double finalAvg = Math.floor(calculateAvg * 10) /10;
                    IO.println();
                    IO.println(String.format(localeBr, "Média: %.1f", finalAvg));
                    IO.println();
                    IO.println();
                }

            }
            IO.println("-------------------------------------------------------");
        } else if (studentsList.isEmpty() && studentOldGradeList.isEmpty()) {
            IO.println("Sem estudantes e notas cadastrados, impossível mostrar na tela.");
        }

       }

       @Override
    public void printStudentBimonthlyAvgForSubject(long studentEnrollment, int subject) {
        if (!studentBimonthlyAvgList.isEmpty() && !studentsList.isEmpty()) {
            IO.println("--------------------------------------------");
            Locale localeBr = Locale.of("pt", "BR");
            IO.println("MÉDIA FINAL POR MATÉRIA");
            IO.println();
            IO.println("Dados do aluno:");
            IO.println();
            studentsList
                    .stream()
                            .filter(s -> s.studentEnrollment == studentEnrollment)
                                    .forEach(s -> IO.println(String.format(localeBr, "Turma: %s\nMatrícula: %d\nAluno: %s %s %s ", s.studentClass, s.studentEnrollment, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
            IO.println();

          var subjectChoose = studentBimonthlyAvgList
                    .stream()
                            .filter(s -> s.studentEnrollment == studentEnrollment && s.subjectBimonthlyAvg == StudentUtils.returnSubject(subject))
                                    .map(s -> s.subjectBimonthlyAvg)
                    .distinct()
                            .toList();

          subjectChoose
                  .stream()
                          .forEach(s -> IO.println(String.format(localeBr, "Matéria: %s", s)));
          IO.println();
            studentBimonthlyAvgList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment)
                    .forEach(s -> IO.println(String.format(localeBr, "%dº Bimestre | Média: %.1f", s.bimonthlyAvg, s.studentBimonthlyAvg)));

            double bimonthlySum = studentBimonthlyAvgList
                    .stream()
                            .filter(s -> s.studentEnrollment == studentEnrollment)
                                    .mapToDouble(s -> s.studentBimonthlyAvg)
                                            .sum();

            double bimonthlyAvg = bimonthlySum / 4;
            double localBimonthlyAvg = Math.floor(bimonthlyAvg * 10) / 10;
            IO.println();
            IO.println(String.format(localeBr, "Média final: %.1f ", localBimonthlyAvg));
            IO.println();
            if (localBimonthlyAvg >= 6.0) {
                IO.println("Status: APROVADO!");
            } else if (localBimonthlyAvg <= 6.0) {
                IO.println("Status: REPROVADO!");
            }
            IO.println("---------------------------------------------");
        } else if (studentBimonthlyAvgList.isEmpty()) {
            IO.println("Não foi criada a média do aluno, por favor, crie a média antes de mostra na tela.");
        }
    }

    private void createBimonthlyAvgOfStudent(long studentEnrollment, int subject, int bimonthlyAvg) {
        double rawAvg = 0.0;
      double sumGradesOfStudent = studentGradeList
                .stream()
                .filter(s -> s.studentEnrollment == s.studentEnrollment)
                .mapToDouble(s -> s.studentGrade)
                .sum();
      rawAvg = sumGradesOfStudent / 3;
     double localStudentAvg = Math.floor(rawAvg * 10) / 10;
        for (var s :studentGradeList) {
            if (s.studentEnrollment == studentEnrollment) {
                Student studentBimonthlyAvg = new Student(studentEnrollment, StudentUtils.returnSubject(subject), bimonthlyAvg, localStudentAvg);
                studentBimonthlyAvgList.add(studentBimonthlyAvg);
                studentGradeList.removeIf(st -> st.studentEnrollment == studentEnrollment);
                return;
            }
        }
    }

    @Override
    public void showStudentAndTeacherClass() {
        if (!studentsList.isEmpty() && !teachersList.isEmpty()) {
            IO.println("--------------------------------------------------------------------------------");
            IO.println("Todas as Turmas:");
            IO.println();
            Locale localeBr = Locale.forLanguageTag("pt-BR");

            List<String> studentClassList = studentsList
                    .stream()
                    .map(s -> s.studentClass)
                    .distinct()
                    .toList();

            List<String> teacherClassList = teachersList
                    .stream()
                    .map(s -> s.getTeacherClass())
                    .distinct()
                    .toList();

            studentClassList
                    .forEach(sc -> {
                        studentsList
                                .stream()
                                .filter(s -> s.studentClass.equals(sc))
                                .map(s -> s.studentClass)
                                .distinct()
                                .forEach(s -> IO.println(String.format(localeBr, "Turma: %s",s)));

                        teachersList
                                .stream()
                                .filter(t -> t.getTeacherClass().equals(sc))
                                .forEach(t -> IO.println(String.format(localeBr,"Professora: %s %s %s\nMatéria: %s", t.getTeacherFirstName(), t.getTeacherMidlleName(), t.getTeacherLastName(), t.getSubjectTeacher())));
                        IO.println();
                        IO.println("Alunos:");
                        studentsList
                                .stream()
                                .filter(s -> s.studentClass.equals(sc))
                                .forEach(s -> IO.println(String.format(localeBr, "Matrícula: %d | Aluno: %s %s %s", s.studentEnrollment, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
                        IO.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    });
            IO.println("--------------------------------------------------------------------------------");
        } else {
            if (studentsList.isEmpty() && teachersList.isEmpty()) {
                IO.println("--------------------------------------------------------------------------------");
                IO.println("Ops!! Alunos e professores ainda não foram cadastrados!");
                IO.println("--------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void findStudent(String studentFirstName, String studentMidlleName, String studentLastName) {
        IO.println("--------------------------------------------------------------------------------");
        IO.println("Busca por nome do aluno:");
        Locale localeBr = Locale.forLanguageTag("pt-BR");
      boolean foundStudent = studentsList
                .stream()
                .anyMatch(s ->
                        s.studentFirstName.equalsIgnoreCase(studentFirstName.trim()) &&
                        s.studentMidlleName.equalsIgnoreCase(studentMidlleName.trim()) &&
                        s.studentLastName.equalsIgnoreCase(studentLastName.trim())
                        );
      if (foundStudent) {
          IO.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
          IO.println("Aluno encontrado com sucesso!");
          IO.println();
          studentsList
                  .stream()
                  .filter(s ->
                          s.studentFirstName.equalsIgnoreCase(studentFirstName.trim()) &&
                                  s.studentMidlleName.equalsIgnoreCase(studentMidlleName.trim()) &&
                                  s.studentLastName.equalsIgnoreCase(studentLastName.trim())
                  )
                  .forEach(s -> IO.println(String.format(localeBr, "Turma: %s | Matrícula: %d | Aluno: %s %s %s", s.studentClass, s.studentEnrollment, s.studentFirstName, s.studentMidlleName, s.studentLastName)));
          IO.println("--------------------------------------------------------------------------------");
      } else {
          IO.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
          IO.println(String.format(localeBr, "O Aluno: %s %s %s -> Não se encontra no banco de dados.", studentFirstName, studentMidlleName, studentLastName));
          IO.println("--------------------------------------------------------------------------------");
      }
    }

    @Override
    public void writeSubjectTextsOfStudents(long studentEnrollment, long teacherEnrollment, String studentOrderNumberSubjectTextOfNumberLocalDate, String subjectTextOfStudents) {
       Locale localeBr = Locale.forLanguageTag("pt-BR");
       LocalDate studentOrderNumberSubjectTextOfNumberNewLocalDate = LocalDate.parse(studentOrderNumberSubjectTextOfNumberLocalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy", localeBr));
       boolean booleanFoundStudent = studentsList
                .stream()
                .anyMatch(s ->
                        s.studentEnrollment == studentEnrollment
                        );

      boolean booleanFoundTeacher = teachersList
               .stream()
               .anyMatch(t ->
                       t.getTeacherEnrollment() == teacherEnrollment
                       );

      if (booleanFoundStudent && booleanFoundTeacher) {
          IO.println();
        List<Student> foundStudentList  = studentsList
                  .stream()
                  .filter(s ->
                          s.studentEnrollment == studentEnrollment
                          )
                  .toList();
       List<Teacher> foundTeacherList = teachersList
                .stream()
                .filter(t ->
                        t.getTeacherEnrollment() == teacherEnrollment
                        )
                .toList();

       StringBuilder sb = new StringBuilder(formatsubjectTextOfStudents(subjectTextOfStudents, 34));

       foundStudentList
               .forEach(f -> {
                   foundTeacherList
                           .forEach(t -> {
                               Student student = new Student(studentOrderNumberSubjectTextOfNumberStatic++, studentOrderNumberSubjectTextOfNumberNewLocalDate,  f.studentEnrollment, f.studentFirstName, f.studentMidlleName, f.studentLastName, t.getTeacherFirstName(), t.getTeacherMidlleName(), t.getTeacherLastName(), t.getSubjectTeacher(), sb);
                               subjectTextsOfStudentList.add(student);
                           });
               });

      } else {
          IO.println(String.format(localeBr, "Matrícula do aluno(a) %d e do professor(a) %d -> Não existem no banco de dados", studentEnrollment, teacherEnrollment));
      }
    }

    @Override
    public void printWriteSubjectTextOfStudent() {
        IO.println("----------------------------------------------------------------------------------------");
        IO.println("Tarefas diárias do aluno:");
        IO.println();
       Locale localeBr = Locale.forLanguageTag("pt-BR");
       if (!subjectTextsOfStudentList.isEmpty()) {
           subjectTextsOfStudentList
                   .stream()
                   .forEach(s -> IO.println(String.format(localeBr, "Nº: %d\n\nDia: %td | Dia da semana: %-15tA | Mês: %tB | Ano: %tY\n\nMatrícula: %d | Aluno: %s %s %s\n\nProfessora: %s %s %s\n\nMatéria: %s\n\nConteúdo -> %s ",s.studentOrderNumberSubjectTextOfNumber, s.studentOrderNumberSubjectTextOfNumberLocalDate, s.studentOrderNumberSubjectTextOfNumberLocalDate, s.studentOrderNumberSubjectTextOfNumberLocalDate, s.studentOrderNumberSubjectTextOfNumberLocalDate, s.studentEnrollment, s.studentFirstName, s.studentMidlleName, s.studentLastName, s.teachersStudentFirstName, s.teachersStudentMidlleName, s.teachersStudentLastName, s.subjectTeacher, s.subjectTextOfStudents.toString())));
           IO.println("----------------------------------------------------------------------------------------");
       }
    }

    private String formatsubjectTextOfStudents(String text, int numberOfCharacter) {

        if (text == null || text.trim().isEmpty()) {
            return "Não há um texto para processar a quebra de linha.";
        }

        StringBuilder textFormated = new StringBuilder();
        int lenghOfTextInInt = text.length();

        for (int i = 0; i < lenghOfTextInInt; i += numberOfCharacter) {

            int endOfBlock = Math.min(i + numberOfCharacter, lenghOfTextInInt);
            textFormated.append(text, i, endOfBlock).append("\n");
        }

        return textFormated.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return id == student.id && studentEnrollment == student.studentEnrollment && Double.compare(studentGrade, student.studentGrade) == 0 && Double.compare(studentAvgQuarter, student.studentAvgQuarter) == 0 && bimonthly == student.bimonthly && bimonthlyAvg == student.bimonthlyAvg && bimonthlyPresentOrAbsentForStaticMethod == student.bimonthlyPresentOrAbsentForStaticMethod && Double.compare(studentBimonthlyAvg, student.studentBimonthlyAvg) == 0 && Double.compare(studentFinalAnualGrade, student.studentFinalAnualGrade) == 0 && studentPresent == student.studentPresent && studentAbsent == student.studentAbsent && bimonthlyPresentOrAbsent == student.bimonthlyPresentOrAbsent && studentTardy == student.studentTardy && subject == student.subject && gradeType == student.gradeType && Objects.equals(studentClass, student.studentClass) && Objects.equals(studentFirstName, student.studentFirstName) && Objects.equals(studentMidlleName, student.studentMidlleName) && Objects.equals(studentLastName, student.studentLastName) && subjectBimonthlyAvg == student.subjectBimonthlyAvg && Objects.equals(dateOfPresentOrAbsent, student.dateOfPresentOrAbsent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentEnrollment, subject, gradeType, studentClass, studentFirstName, studentMidlleName, studentLastName, studentGrade, studentAvgQuarter, bimonthly, bimonthlyAvg, bimonthlyPresentOrAbsentForStaticMethod, subjectBimonthlyAvg, studentBimonthlyAvg, studentFinalAnualGrade, studentPresent, studentAbsent, bimonthlyPresentOrAbsent, dateOfPresentOrAbsent, studentTardy);
    }

    @Override
    public String toString() {
        Locale localeBR = Locale.of("pt", "BR");
        return String.format(localeBR, "Id: %d | Matrícula: %d | Turma: %s | Aluno: %-15s %-15s %-15s", id, studentEnrollment, studentClass, studentFirstName, studentMidlleName, studentLastName);
    }
}
