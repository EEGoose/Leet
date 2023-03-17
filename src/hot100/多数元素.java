package hot100;

import java.util.Arrays;

/**
 * @author: huyu3
 * @since: 2023-01-28 11:30
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
