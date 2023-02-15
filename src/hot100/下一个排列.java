package hot100;

/**
 * Tips：思路及解法
 *
 * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
 *
 * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 *
 * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
 *
 * 以排列 [4,5,2,6,3,1] 为例：
 *
 * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 2 与 3，满足「较小数」尽量靠右，而「较大数」尽可能小。
 *
 * 当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6]。
 *
 * 具体地，我们这样描述该算法，对于长度为 n 的排列 a：
 *
 * 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i]<a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
 *
 * 如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i]<a[j]。这样「较大数」即为 a[j]。
 *
 * 交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序
 *
 * @author: EEGoose
 * @since: 2023-02-07 15:45
 */
public class 下一个排列 {

    public static void nextPermutation(int[] nums) {
        int last = nums[nums.length - 1];
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (last > nums[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int swap = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = swap;
            }
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = last;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation2(nums);
    }

    public static void nextPermutation2(int[] nums) {
        int split = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                split = i;
                break;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        if (split != -1) {
            block:{
                for (int i = split; i >= 0; i--) {
                    for (int j = nums.length - 1; j > split; j--) {
                        if (nums[i] < nums[j]) {
                            left = i + 1;

                            int swap = nums[i];
                            nums[i] = nums[j];
                            nums[j] = swap;
                            break block;
                        }
                    }
                }
            }
        }

        for (int i = left; i <= (left + right) / 2; i++) {
            int j = right - (i - left);
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
