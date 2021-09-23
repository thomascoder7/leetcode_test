public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int[][] res = new int[prices.length][2];

//        第一天有两种可能
        res[0][0] = 0; // 第一天不持股则为0
        res[0][1] = -prices[0]; //第一天持股说明在第一天买入了股票减去第一天的股价


        for (int i=1;i<prices.length;i++)
        {
            //如果第i天不持股有两种可能，前一天也不持股，或者前一天持股第i天卖掉
            res[i][0] = Math.max(res[i-1][0],res[i-1][1]+prices[i]);

            //如果第i天持股有两种可能，前一天也持股，或者之前没买入过第i天买入（因为要求只进行一次买卖）
            res[i][1] = Math.max(res[i-1][1],-prices[i]);
        }
        return res[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] test = {7,1,5,3,6,4};
        Leetcode121 leetcode121 = new Leetcode121();
        leetcode121.maxProfit(test);
    }

}
