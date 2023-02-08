package hot100;

/**
 * @author: EEGoose
 * @since: 2023-01-18 11:16
 */
public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,1,1};
        System.out.println(singleNumber(nums));;
    }
}
