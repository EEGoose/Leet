package hot100;

/**
 * @author: huyu3
 * @since: 2023-01-18 11:07
 */
public class 买卖股票最佳时间 {

    public int maxProfit(int[] prices) {
        int maxProfix = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfix = Math.max(maxProfix, price - minPrice);
        }
        return maxProfix;
    }
}
