import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mathExpression = scanner.nextLine();

        Stack s = inicPilha();

        for (int i = 0; i < mathExpression.length(); i++) {
            push(s, mathExpression.substring(i, i + 1));
        }


        out.println(s);
    }

    private static Stack inicPilha() {
        return new Stack();
    }

    private static void push(Stack s, String a) {
        s.push(a);
    }

    public void pop(Stack s) {
        s.pop();
    }
}
