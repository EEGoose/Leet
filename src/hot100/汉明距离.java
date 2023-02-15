package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-14 11:24
 */
public class 汉明距离 {
    public static int hammingDistance(int x, int y) {
        int count = 0;

        while (x != 0 || y != 0) {
            int xR = 0;
            int yR = 0;

            if (x != 0) {
                xR = x % 2;
                x = x / 2;
            }

            if (y != 0) {
                yR = y % 2;
                y = y / 2;
            }

            if (xR != yR) {
                count++;
            }
        }

        return count;
    }


    public static int hammingDistance2(int x, int y) {
        int count = 0;
        int z = x ^ y;

        while (z != 0) {
            int r =  z % 2;
            if (r == 1) {
                count++;
            }
            z = z/2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance2(1, 4));
    }
}
