package hot100;

import java.util.Arrays;

/**
 * @author: EEGoose
 * @since: 2023-03-20 16:10
 */
public class 除自身以外数组的乘积 {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        int guodu = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                nums[i] = 1;
            } else {
                int temp = nums[i];
                nums[i] = nums[i + 1] * guodu;
                guodu = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Arrays.stream(productExceptSelf(nums)).forEach(item -> {
            System.out.println(item);
        } );
    }
}
