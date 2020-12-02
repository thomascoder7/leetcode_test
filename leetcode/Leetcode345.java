import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther Lu Qi
 * @Date 2020-08-19 23:02
 */

public class Leetcode345 {

    public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int l=0;
        int r=s.length()-1;
        char c;
        char[] letter=new char[] {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = new ArrayList<>();
        for(char a:letter)
            list.add(a);
        while(l<r)
        {
            while(l<r && !list.contains(ss[l]))
                l++;
            while(l<r && !list.contains(ss[r]))
                r--;
            c=ss[l];
            ss[l] = ss[r];
            ss[r] = c;
            l++;
            r--;
        }
        return String.valueOf(ss);
    }


    public static void main(String[] args) {
        Leetcode345 leetcode345 = new Leetcode345();
        leetcode345.reverseVowels("hello");
    }
}
