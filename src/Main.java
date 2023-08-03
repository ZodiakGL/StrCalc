import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = input.nextLine();
        System.out.println('"' + CalculatorString.calc(expression) + '"');
    }
}
class CalculatorString {
    public static String calc(String input) {
        String operand1 = null;
        String operand2 = null;
        String answer;
        char operator;
        String[] split = input.split(" ");
        if (split.length != 3) {
            throw new RuntimeException("throws Exception");
        }
        if (Symbol1.c(split[0]) == false) {
            throw new RuntimeException("throws Exception// операнды должны выделяться кавычками");
        }
        if (split[0].length() > 10 || split[2].length() > 10) {
            throw new RuntimeException("throws Exception //т.к. длина строки должна быть не больше 10");
        }
        operand1 = split[0].substring(1, split[0].length() - 1);
        operator = split[1].charAt(0);
        if (Convert.isNumber(split[2]) == true) {
            operand2 = String.valueOf(Integer.parseInt(split[2]));
        } else {
            operand2 = split[2];
        }
        switch (operator) {
            case '+':
                answer = operand1 + operand2.substring(1, operand2.length() - 1);
                break;
            case '-':
                answer = Subtraction.x(operand1, operand2.substring(1, operand2.length() - 1));
                break;
            case '*':
                answer = Multiplication.y(operand1, Integer.parseInt(operand2));
                break;
            case '/':
                answer = Division.z(operand1, Integer.parseInt(operand2));
                break;
            default: {
                throw new RuntimeException("throws Exception// неверный ввод операнда");
            }
        }
        return answer.length() <= 40 ? answer : answer.substring(0, 40) + "...";
    }
}
class Convert {
    public static boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
class Subtraction {
    public static String x(String a, String b) {
        return a.replace(b, "");
    }
}
class Multiplication {
    public static String y(String a, int b) {
        if (Symbol1.c(a) && Symbol1.c(Integer.toString(b)) == false) {
            throw new RuntimeException("throws Exception// операнды должны выделяться кавычками");
        }
        if (a.length() > 10) {
            throw new RuntimeException("throws Exception //т.к. длина строки должна быть не больше 10");
        }
        if (b > 10 || b < 0) {
            throw new RuntimeException("throws Exception //т.к. числа должны быть не больше 10");
        }
        return a.repeat(b);
    }
}
class Division {
    public static String z(String a, int b) {
        if (Symbol1.c(a) && Symbol1.c(Integer.toString(b)) == false) {
            throw new RuntimeException("throws Exception// операнды должны выделяться кавычками");
        }
        if (a.length() > 10) {
            throw new RuntimeException("throws Exception //т.к. длина строки должна быть не больше 10");
        }
        if (b > 10 || b < 0) {
            throw new RuntimeException("throws Exception //т.к. числа должны быть не больше 10");
        }
        if (b <= 0) {
            throw new IllegalArgumentException("throws Exception// деление на ноль недопустимо");
        }
        int quantity = a.length();
        int answer = quantity / b;
        return a.substring(0, answer);

    }
}
class Symbol1 {
    public static boolean c(String a) {
        boolean marker = a.startsWith("\"") && a.endsWith("\"");
        return marker;
    }
}

