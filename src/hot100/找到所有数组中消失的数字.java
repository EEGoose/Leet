package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-02-01 10:51
 */
public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] records = new int[nums.length];
        for (int num : nums) {
            records[num-1] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            if (records[i] == 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
