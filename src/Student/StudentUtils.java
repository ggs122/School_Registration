package Student;

import Student.Student.*;

public final class StudentUtils {


//    static void main(String[] args) {
//        System.out.println(StudentUtils.returnBimonthly(4));
//
////        System.out.println(StudentUtils.returnSubject(1));
////        System.out.println(StudentUtils.returnGradeType(-1));
//    }

    protected StudentUtils() {
    }

    public static Subject returnSubject(int chooseNumberOfSubject) {
        Subject subjectReturned = switch (chooseNumberOfSubject) {
            case 1 -> Subject.MATEMÁTICA;
            case 2 -> Subject.CIÊNCIAS;
            case 3 -> Subject.GEOGRAFIA;
            case 4 -> Subject.HISTÓRIA;
            default -> Subject.OPÇÃO_INVÁLIDA;
        };
        return subjectReturned;
    }

    public static GradeType returnGradeType(int chooseNumberOfGradeType) {
        GradeType gradeTypeReturned = switch ( chooseNumberOfGradeType) {
            case 1 -> GradeType.COMPORTAMENTO;
            case 2 -> GradeType.PARTICIPAÇÃO;
            case 3 -> GradeType.ATIVIDADES_DE_CASA;
            case 4 -> GradeType.TESTE;
            case 5 -> GradeType.PROVA;
            default -> GradeType.OPÇÃO_INVÁLIDA;
        };
        return gradeTypeReturned;
    }

    public static int returnBimonthly(int bimonthly) {
        return switch (bimonthly) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 4;
            default -> 0;
        };
    }
}
