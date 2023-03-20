package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-20 18:57
 */
public class 回文子串 {
    private int count = 1;

    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            check(chars, i);
            if (chars[i] == chars[i - 1]) {
                check(chars, i, i - 1);
            }
        }
        return count;
    }

    private void check(char[] chars, int i, int j) {
        count++;
        while (true) {
            i = i - 1;
            j = j + 1;
            if (i < 0 || j >= chars.length) {
                break;
            }
            if (chars[i] == chars[j]) {
                count++;
            }
        }
    }

    private void check(char[] chars, int i) {
        count++;
        int x = i;
        int y = i;
        while (true) {
            x = x - 1;
            y = y + 1;
            if (x < 0 || y >= chars.length) {
                break;
            }
            if (chars[x] == chars[y]) {
                count++;
            }
        }
    }
}
