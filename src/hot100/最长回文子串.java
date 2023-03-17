package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-22 16:19
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int strLength = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                int offset = kuosan(chars, i - 1, i);
                int length = offset * 2 + 2;
                if (length > strLength) {
                    strLength = length;
                    start = i - 1 - offset;
                    end = i +offset;
                }

            }
            int offset = kuosan(chars, i);
            int length = offset * 2 + 1;
            if (length > strLength) {
                strLength = length;
                start = i - offset;
                end = i + offset;
            }
        }

        return String.copyValueOf(chars, start + 1, end - start - 1);
    }

    private int kuosan(char[] chars, int i) {
        int offset = 0;
        while (true) {
            if (i - offset < 0 || i + offset >= chars.length) {
                return offset;
            }
            if (chars[i - offset] == chars[i + offset]) {
                offset++;
            } else {
                break;
            }
        }
        return offset;
    }

    private int kuosan(char[] chars, int i, int j) {
        int offset = 0;
        while (true) {
            if (i - offset < 0 || j + offset >= chars.length) {
                return offset;
            }
            if (chars[i - offset] == chars[j + offset]) {
                offset++;
            } else {
                break;
            }
        }
        return offset;
    }

    public static void main(String[] args) {
        最长回文子串 最长回文子串 = new 最长回文子串();
        String s = "ccc";
        System.out.println(最长回文子串.longestPalindrome(s));
    }
}
