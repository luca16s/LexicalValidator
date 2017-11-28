import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valido = true;
        String mathExpression = scanner.nextLine();
        int colchetes = 0, chaves = 0, parenteses = 0;
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
                    if (item.equals("{") || item.equals("}"))
                        chaves++;
                    if (item.equals("(") || item.equals(")"))
                        parenteses++;
                    if (item.equals("[") || item.equals("]"))
                        colchetes++;
                }
                if (chaves != 0 && parenteses != 0 && colchetes != 0) {
                    if (chaves % 2 != 0 || parenteses % 2 != 0 || colchetes % 2 != 0) {
                        valido = false;
                    }
                }
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
