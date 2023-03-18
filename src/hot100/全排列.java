package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-03-17 17:13
 */
public class 全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute2(int[] nums) {

        List<Integer> origin = new ArrayList<>();
        for (int num : nums) {
            origin.add(num);
        }

        backtrack2(0, origin);
        return result;
    }

    private static void backtrack2(int huisuwei, List<Integer> origin) {
        if (huisuwei == origin.size()) {
            result.add(origin);
        }
        for (int i = huisuwei; i < origin.size(); i++) {
            List<Integer> newList = new ArrayList<>(origin);
            if (i != huisuwei) {
                Collections.swap(newList, huisuwei, i);
            }
            backtrack2(huisuwei + 1, newList);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> permute = permute2(nums);
        System.out.println(true);
    }
}
