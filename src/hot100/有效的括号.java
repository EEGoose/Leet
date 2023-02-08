package hot100;

import java.util.Stack;

/**
 * @author: EEGoose
 * @since: 2023-01-17 11:12
 */
public class 有效的括号 {
    public static boolean isValid(String s) {
        final Character a = '(';
        final Character b = ')';
        final Character x = '[';
        final Character y = ']';
        final Character p = '{';
        final Character q = '}';
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (a.equals(peek) && b.equals(c)) {
                stack.pop();
                continue;
            } else if (x.equals(peek) && y.equals(c)) {
                stack.pop();
                continue;
            } else if (p.equals(peek) && q.equals(c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "()";
        System.out.println(isValid(a));
    }
}
