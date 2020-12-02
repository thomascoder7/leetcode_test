/**
 * @Auther Lu Qi
 * @Date 2020-09-21 11:27
 */

public class Leetcode3 {


    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        int l=0,r=0,max_l=1;
        int[] freq = new int[256];
        freq[(int)s.charAt(l)]++;

        while(l<s.length()-1 && r<s.length()-1)
        {
            if(freq[(int)s.charAt(r+1)]>0)
            {
                freq[(int)s.charAt(l)]--;
                l++;
            }
            else
            {
                r++;
                freq[(int)s.charAt(r)]++;
                if(r-l+1>max_l)
                    max_l = r-l+1;
            }
        }
        return max_l;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Leetcode3 t = new Leetcode3();
        System.out.println(t.lengthOfLongestSubstring(s));
    }
}
