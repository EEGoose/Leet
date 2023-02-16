package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-16 15:21
 */
public class 移动零 {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
int[] nums = {1,0,2,3,0,0,5,6,0};
moveZeroes(nums);
    }
}
