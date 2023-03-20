package hot100;

import java.util.Arrays;

/**
 * @author: EEGoose
 * @since: 2023-03-20 19:30
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                count = 1;
            }
        }
        return max;
    }
}
