package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huyu3
 * @since: 2023-01-17 09:47
 */
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer b = map.get(target - nums[i]);
            if (b != null) {
                int[] result = {b, i};
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] ints = twoSum(a, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
