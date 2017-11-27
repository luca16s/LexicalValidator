import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valido = true;
        String mathExpression = scanner.nextLine();
        String auxVariable = "";
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
            out.println(s);
        }

        for (int i = 0; i < s.size(); i++) {
            if (mathExpression.substring(i, i + 1).equals(")")
                    || mathExpression.substring(i, i + 1).equals("]")
                    || mathExpression.substring(i, i + 1).equals("}")) {
                if (pilhaVazia(s)) {
                    valido = false;
                } else {
                    auxVariable = pop(s);
                    String c = s.peek();
                    switch (auxVariable) {
                        case "}":
                            if (c != "{") {
                                valido = false;
                            }
                            break;
                        case ")":
                            if (c != "(") {
                                valido = false;
                            }
                            break;
                        case "]":
                            if (c != "[") {
                                valido = false;
                            }
                            break;
                    }
                }
            }
        }

        if (pilhaVazia(s) == true) {
            valido = false;
        }
        if (valido) {
            out.println("Expressão válida");
        } else {
            out.println("Expressão inválida");
        }
    }

    private static boolean pilhaVazia(Stack s) {
        return s.empty();
    }

    private static Stack inicPilha() {
        return new Stack<String>();
    }

    private static void push(Stack s, String a) {
        s.push(a);
    }

    public static String pop(Stack s) {
        String local = (String) s.pop();
        return local;
    }
}
