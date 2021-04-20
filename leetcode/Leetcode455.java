import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Leetcode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_index = g.length-1;
        int s_index = s.length-1;
        int res = 0;
        while (g_index>=0&&s_index>=0)
        {
            if (s[s_index]>=g[g_index])
            {
                res++;
                s_index--;
                g_index--;
            }
            else
                g_index--;
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();
        int i=0 , j=0;
        while (i<s_length&&j<t_length)
        {
            if (s.charAt(i)==t.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i==s_length;
    }

}
