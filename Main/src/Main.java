import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        out.println(a);
        Stack s = inicPilha();
        push(s, 'c');
        out.println(s);
    }

    private static Stack inicPilha() {
        return new Stack();
    }

    private static void push(Stack s, char a) {
        s.push(a);
    }

    public void pop(Stack s) {

    }
}
