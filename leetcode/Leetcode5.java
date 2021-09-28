public class Leetcode5 {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int maxLen = 1;

        for (int i=0;i<s.length();i++)
            dp[i][i] = true;
        for (int j=1;j<=s.length()-1;j++)
        {
            for (int i=0;i<j;i++)
            {
                if (s.charAt(i)==s.charAt(j) && (j-i<3||dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if (j-i+1>maxLen)
                    {
                        maxLen = j-i+1;
                        begin = i;
                    }
                }

            }

        }
        //注意substring是左闭右开
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        leetcode5.longestPalindrome("bb");
    }


}
