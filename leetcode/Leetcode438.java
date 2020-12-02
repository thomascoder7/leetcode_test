import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Lu Qi
 * @Date 2020-09-21 14:58
 */

public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length()==0)
            return res;
        int[] win_freq = new int[256]; //当前窗口内各字符出现次数
        int[] needs = new int[256]; //字符串p所需的各字符出现次数
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        for(int i=0;i<arrP.length;i++)
            needs[(int)arrP[i]]++;
        int l=0,r=0;
        while (l<=arrS.length-1 && r<=arrS.length-1)
        {
            win_freq[(int)arrS[r]]++;
            r++;

            //后面这部分思路为当此时窗口内的元素出现次数都不超过需要的次数并且此时长度与所需要的也相同，则此时恰好就是我们需要的
            while (needs[(int)arrS[r-1]]<win_freq[(int)arrS[r-1]])
            {
                win_freq[(int)arrS[l]]--;
                l++;
            }
            if (r-1-l+1==arrP.length)
                res.add(l);
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode438 leetcode438 = new Leetcode438();
        System.out.println(leetcode438.findAnagrams("cbaebabacd","abc"));
    }


}
