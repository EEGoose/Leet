package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-17 16:44
 */
public class 统计一个圆中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int cx = queries[j][0];
            int cy = queries[j][1];
            int cr = queries[j][2];

            int count = 0;
            for (int i = 0; i < points.length; i++) {
                int pointX = points[i][0];
                int pointY = points[i][1];
                if (Math.pow(pointX - cx, 2) + Math.pow(pointY - cy, 2) <= Math.pow(cr, 2)) {
                    count++;
                }
            }
            result[j] =count;
        }
        return result;
    }
}
