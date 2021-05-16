import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther Lu Qi
 * @Date 2021-03-03 17:10
 */

public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i=1;i<n;i++) {

            for (int j=0;j<=i;j++) {

                if (j == 0) { // 三角形的最左边

                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) { // 三角形的最右边

                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(i);
                } else {

                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        // dp最后一行记录了最小路径
        int minSum = dp[n - 1][0];
        for (int i=1;i<n;i++) {

            minSum = Math.min(minSum, dp[n - 1][i]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        List<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(new ArrayList<Integer>(Arrays.asList(2)));
        group.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        group.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
        group.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
        System.out.println(leetcode120.minimumTotal(group));

    }


}
