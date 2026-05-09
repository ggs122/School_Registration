package Teacher;

public final class TeacherUtils {

    private TeacherUtils() {}

    public static String returTeacherClass(int chooseTeacherClass) {
        return switch (chooseTeacherClass) {
            case 1 -> "1504";
            case 2 -> "1505";
            case 3 -> "1506";
            case 4 -> "1507";
            default -> "Número de turma inválido";
        };
    }
}
