package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: EEGoose
 * @since: 2023-01-17 10:27
 */
public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer index = map.get(chars[i]);
            if (null != index && start <= index && end >= index) {
                start = index + 1;
            }
            map.put(chars[i], i);
            int length = end -start+1;
            if (length > max) {
                max = length;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
