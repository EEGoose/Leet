package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-03-17 16:59
 */
public class 子集 {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        digui(new ArrayList<>(), nums, 0);
        return result;
    }

    private static void digui(List<Integer> item, int[] nums, int i) {
        if (i >= nums.length) {
            result.add(item);
            return;
        }
        List<Integer> two = new ArrayList<>(item);
        two.add(nums[i]);
        ++i;
        digui(new ArrayList<>(item), nums, i);
        digui(two, nums, i);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums).toString());
    }
}
