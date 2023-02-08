package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-01 15:39
 */
public class 比特位计数 {
    public static int[] countBits(int n) {
        n++;
        int[] array = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                array[i] = 0;
                continue;
            }
            if (i == 1) {
                array[i] = 1;
                continue;
            }
            array[i] = 1;
            p = i;
            for (int j = i + 1; j < 2 * p && j < n; j++) {
                array[j] = array[p] + array[j - p];
                i = j;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ints = countBits(5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
