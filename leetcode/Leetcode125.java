/**
 * @Auther Lu Qi
 * @Date 2020-08-14 23:45
 */

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0)
            return true;
        int l=0,r=s.length()-1;
        while (l<r)
        {
            if (!Character.isDigit(s.charAt(l))&&!Character.isLetter(s.charAt(l)))
            {
                l++;
                continue;
            }
            if (!Character.isDigit(s.charAt(r))&&!Character.isLetter(s.charAt(r)))
            {
                r--;
                continue;
            }
            if (s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Leetcode125 leetcode125 = new Leetcode125();
        System.out.println(leetcode125.isPalindrome(s));
    }


}
