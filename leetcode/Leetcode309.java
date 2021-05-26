public class Leetcode309 {

    int[][] res;

    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
//        买入股票可以资产即为负卖出为正
//        res[i][0] 表示第i天，持有股票情况下的收益，res[i][1] 表示第i天，卖出股票情况下的收益，res[i][2] 表示第i天，处于冷冻期的收益
        res = new int[prices.length][3];
        res[0][0] = -prices[0];
        int l = prices.length;
        for (int i=1;i<l;i++)
        {
            // 有两种情况状态转移到第i天持有股票，i-1天持有股票第i天没动或第i-1天为冷冻期不持有股票第i天买入
            res[i][0] = Math.max(res[i-1][0],res[i-1][2]-prices[i]);
            res[i][1] = res[i-1][0]+prices[i];
            // 第i天处于冷冻期即当天没有进行操作，有两种情况转移到该状态，前一天处于冷冻期或前一天卖出了股票
            res[i][2] = Math.max(res[i-1][1],res[i-1][2]);
        }
        return Math.max(res[l - 1][1], res[l - 1][2]);
    }


}
