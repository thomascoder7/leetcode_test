public class Leetcode91 {

    public int numDecodings(String s) {
        int l = s.length();
        int[] res = new int[l+1];
        res[0] = 1;

        for (int i=1;i<=s.length();i++)
        {
            if (s.charAt(i-1)!='0')
                res[i] += res[i-1];
            if (i>=2 && s.charAt(i-2)!='0' && (s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')<=26)
            {
                res[i] += res[i-2];
            }
        }
        return res[l];

    }


}
