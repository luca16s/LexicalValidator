import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valido = true;
        String mathExpression = scanner.nextLine();
        int colchetesLeft = 0, chavesLeft = 0, parentesesLeft = 0;
        int colchetesRight = 0, chavesRight = 0, parentesesRight = 0;
        Stack<String> s = inicPilha();

        for (int i = 0; i < mathExpression.length(); i++) {

            if (mathExpression.substring(i, i + 1).equals("(")
                    || mathExpression.substring(i, i + 1).equals("[")
                    || mathExpression.substring(i, i + 1).equals("{")) {
                push(s, mathExpression.substring(i, i + 1));
            } else if (mathExpression.substring(i, i + 1).equals(")")
                    || mathExpression.substring(i, i + 1).equals("]")
                    || mathExpression.substring(i, i + 1).equals("}")) {
                push(s, mathExpression.substring(i, i + 1));
            }

        }

        if (s.peek().equals(")")
                || s.peek().equals("]")
                || s.peek().equals("}")) {
            if (pilhaVazia(s)) {
                valido = false;
            } else {
                for (String item : s) {
                    if (item.equals("{"))
                        chavesLeft++;
                    if (item.equals("("))
                        parentesesLeft++;
                    if (item.equals("["))
                        colchetesLeft++;
                    if (item.equals("}"))
                        chavesRight++;
                    if (item.equals(")"))
                        parentesesRight++;
                    if (item.equals("]"))
                        colchetesRight++;
                }
                if (chavesLeft != chavesRight || parentesesLeft != parentesesRight || colchetesLeft != colchetesRight)
                        valido = false;
            }
        } else {
            valido = false;
        }

        if (pilhaVazia(s)) {
            valido = false;
        }
        if (valido) {
            out.println("Expressão válida");
        } else {
            out.println("Expressão inválida");
        }
    }

    private static boolean pilhaVazia(Stack<String> s) {
        return s.empty();
    }

    private static Stack<String> inicPilha() {
        return new Stack<>();
    }

    private static void push(Stack<String> s, String a) {
        s.push(a);
    }

    private static void pop(Stack<String> s) {
        s.pop();
    }
}
