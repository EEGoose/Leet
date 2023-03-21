package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-21 11:20
 */
public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }
        return cache[n];
    }

}
