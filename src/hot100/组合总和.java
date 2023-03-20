package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-03-20 15:34
 */
public class 组合总和 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        digui(new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void digui(List<Integer> list, int[] candidates, int rest, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > rest) {
                break;
            }
            int subRest = rest - candidates[i];
            List<Integer> subList = new ArrayList<>(list);
            subList.add(candidates[i]);
            if (subRest == 0) {
                result.add(subList);
            } else {
                digui(subList, candidates, subRest, i);
            }
        }
    }
}
