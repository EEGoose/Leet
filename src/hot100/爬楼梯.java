package hot100;

/**
 * @author: EEGoose
 * @since: 2023-01-17 16:45
 */
public class 爬楼梯 {
    public static int climbStairs(int n) {
        Integer count = 0;
        de(n, 1, count);
        de(n, 2, count);
        return count;
    }

    private static void de(int rest, int offset, Integer count) {
        int de = rest - offset;
        if (de < 0) {
            return;
        }
        if (de == 0) {
            count++;
            return;
        }
        de(de, 1, count);
        de(de, 2, count);
    }

    public static int climbStairs2(int n) {
        int p = 0;
        int q = 1;
        int r = 1;
        for (int i = 0; i < n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs2(3));
    }
}
