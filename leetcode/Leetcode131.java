import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode131 {

    List<List<String>> res = new ArrayList<List<String>>();
    List<String> tempRes = new ArrayList<>();
    boolean[][] checkout;
    public List<List<String>> partition(String s) {
        //为避免在判断回文串时出现重复计算我们提前计算输入的字符串s的子串是否是回文串
        checkout = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++)
            Arrays.fill(checkout[i],true);

        for (int i=0;i<s.length();i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if (s.charAt(i)==s.charAt(j)&&checkout[j+1][i-1])
                    checkout[j][i] = true;
                else
                    checkout[j][i] = false;
            }
        }

        dfs(s,0);
        return res;

    }

    public void dfs(String s,int start)
    {
        if (start==s.length())
        {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i=start;i<s.length();i++)
        {
            if (checkout[start][i])
            {
                tempRes.add(s.substring(start,i+1));
                dfs(s,i+1);
                tempRes.remove(tempRes.size()-1);
            }
        }

    }

}
