package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-02-01 15:58
 */
public class 括号生成 {
    private static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        fun(n, 1, 1, "(");
        return result;
    }

    private static void fun(int n, int use, int rest, String s) {
        if (n == use && rest == 0) {
            result.add(s);
            return;
        }

        if (use < n) {
            fun(n, use + 1, rest + 1, s + "(");
        }
        if (rest > 0) {
            fun(n, use, rest - 1, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}
