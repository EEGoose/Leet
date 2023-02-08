package day221226;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *
 * 请找出数组中任意一个重复的数字。
 *
 * @author: EEGoose
 * @since: 2022-12-26 11:10
 */
public class JianzhiOffer03 {

    public Integer checkRepeated(List<Integer> arrays, Integer range) {
        Byte[] bitmap = new Byte[range];
        for (Integer item : arrays) {
            int i = item % (range + 1);
            if (bitmap[i] == 0) {
                bitmap[i] = 1;
            } else {
                return item;
            }
        }
        return null;
    }

    public Integer checkRepeated2(List<Integer> arrays, Integer range) {
        Set<Integer> set = new HashSet<>();
        for (Integer item : arrays) {
            if (set.contains(item)) {
                return item;
            } else {
                set.add(item);
            }
        }
        return null;
    }
}
