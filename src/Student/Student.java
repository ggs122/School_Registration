package Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Student {

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

    // studentPresent -> Presenças do aluno.
    private int studentPresent;
    // studentAbsent -> Faltas do aluno.
    private int studentAbsent;

    private int bimonthlyPresentOrAbsent;

    private LocalDate dateOfPresentOrAbsent;
    // tardy -> atrasos do aluno.
    private int studentTardy;

    static List<Student> studentsList = new ArrayList<>();
    static List<Student> studentGradeList = new ArrayList<>();
    static List<Student> studentOldGradeList = new ArrayList<>();
    static List<Student> studentBimonthlyAvgList = new ArrayList<>();
    static List<Student> studentPresentOrAbsentList = new ArrayList<>();
    static List<Student> bimonthlyPresentOrAbsentForMethod = new ArrayList<>();

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

    private Student(long studentEnrollment, String studentFirstName, String studentMidlleName, String studentLastName, String teachersStudentFirstName, String teachersStudentMidlleName, String teachersStudentLastName) {
        this.studentEnrollment = studentEnrollment;
        this.studentFirstName = studentFirstName;
        this.studentMidlleName = studentMidlleName;
        this.studentLastName = studentLastName;
        this.teachersStudentFirstName = teachersStudentFirstName;
        this.teachersStudentMidlleName = teachersStudentMidlleName;
        this.teachersStudentLastName = teachersStudentLastName;
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
        Locale localeBr = Locale.of("pt", "BR");
        Student student1 = new Student();
        boolean studentClassBoolean = studentClass.matches("[0-9]{4}");
        if (studentClassBoolean == true && student1.CheckingSpecificName(studentFirstName, studentMidlleName, studentLastName) == false) {
            Student student2 = new Student(staticId++, staticStudentEnrollment++, studentClass, studentFirstName.trim().toUpperCase(), studentMidlleName.trim().toUpperCase(), studentLastName.trim().toUpperCase());
            studentsList.add(student2);
            IO.println("--------------------------------------------------------------------------------------------");
            IO.println(String.format("Aluno %s %s %s, criado com sucesso!", student2.studentFirstName, student2.studentMidlleName, student2.studentLastName));
            IO.println("--------------------------------------------------------------------------------------------");
        } else if (studentClassBoolean == false) {
            IO.println("--------------------------------------------------------------------------------------------");
            IO.println("Número da turma só aceita 4 dígitos.\nEx: 0000\nNão confere com " + studentClass + " que foi digitado.");
            IO.println("--------------------------------------------------------------------------------------------");
        } else if (student1.CheckingSpecificName(studentFirstName, studentMidlleName, studentLastName) == true) {
            IO.println("--------------------------------------------------------------------------------------------");
            IO.println(String.format(localeBr, "O aluno: %s %s %s, já foi cadastrado anteriormente no sistema", studentFirstName.trim().toUpperCase(), studentMidlleName.trim().toUpperCase(), studentLastName.trim().toUpperCase()));
            IO.println("--------------------------------------------------------------------------------------------");
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

        if (foundStudent == true && foundStudentBimonthlyAgvList == true) {
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

    private boolean valitedSpecificPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent, String datePresentOrAbsent, int studentPresent, int studentAbsent) {
        boolean chechking = true;

        if (!studentsList.isEmpty() && !studentBimonthlyAvgList.isEmpty() && !studentPresentOrAbsentList.isEmpty()) {
            boolean foundStudent = studentsList
                    .stream()
                    .anyMatch(s -> s.studentEnrollment == studentEnrollment);

            boolean foundStudentBimonthlyAgvList = studentBimonthlyAvgList
                    .stream()
                    .anyMatch(s ->
                            s.studentEnrollment == studentEnrollment &&
                                    StudentUtils.returnBimonthly(bimonthlyPresentOrAbsent) == bimonthlyPresentOrAbsent
                    );
            LocalDate dateFormated = LocalDate.parse(datePresentOrAbsent, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            boolean foundDate = studentPresentOrAbsentList
                    .stream()
                    .anyMatch(s -> s.dateOfPresentOrAbsent.equals(dateFormated));

            if (foundStudent == true && foundStudentBimonthlyAgvList == true && foundDate == true) {
                IO.println("Presença ou falta já informada anteriormente nesta data");
                chechking = true;
                return chechking;
            } else {
                if (foundStudent == false && foundStudentBimonthlyAgvList == false && foundDate == false) {
                    try {
                        LocalDate dateFormatedForCreated = LocalDate.parse(datePresentOrAbsent, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        Student student = new Student(studentEnrollment, bimonthlyPresentOrAbsent, dateFormatedForCreated, studentPresent, studentAbsent);
                        studentPresentOrAbsentList.add(student);
                    } catch (Exception e) {
                        IO.println("Ops! Erro! Data formato inválido");
                    }
                    IO.println("Presença ou falta lançado(a) com sucesso!");
                    chechking = false;
                    return chechking;
                }
            }
        } else {
            if (studentsList.isEmpty() && studentBimonthlyAvgList.isEmpty() && studentPresentOrAbsentList.isEmpty()) {
                IO.println("Aluno, Média bimestral e presença ainda não foram cadastrados.");
            }
        }
        return chechking;
    }



    public void printSpecificStudentPresentOrAbsent(long studentEnrollment, int bimonthlyPresentOrAbsent) {
        if (!studentPresentOrAbsentList.isEmpty()) {
            IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
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
            studentPresentOrAbsentList
                    .stream()
                    .filter(s -> s.studentEnrollment == studentEnrollment && s.bimonthlyPresentOrAbsent == bimonthlyPresentOrAbsent)
                    .forEach(s -> IO.println(
                            String.format(
                            localeBr,

                            "Bimestre: %-8d\nDia: %2$td, %2$-15tA, %2$tB, %2$tY | Presença: %3$d | Falta: %4$d\n", s.bimonthlyPresentOrAbsent, s.dateOfPresentOrAbsent, s.studentPresent, s.studentAbsent
                                    )
                            )
                    );

            IO.println();
            IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

    }

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
