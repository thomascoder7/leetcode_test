import java.lang.reflect.Array;
import java.util.*;

/**
 * Leetcode1 Leetcode242 Leetcode202 Leetcode290
 */

public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++)
        {
            if (map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

//    Leetcode242题
    public boolean isAnagram(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        return Arrays.equals(s_array,t_array);
    }

    // Leetcode 202
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        n = getNext(n);
        while (n!=1 && !set.contains(n))
        {
            set.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    private int getNext(int n)
    {
        int next = 0;
        while (n!=0)
        {
            int a = n%10;
            next += a*a;
            n = n/10;
        }
        return next;
    }

    // Leetcode290
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap();
        Map<String,Character> map2 = new HashMap();
        char[] patternArray = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (patternArray.length!=strings.length)
            return false;
        for(int i=0;i<patternArray.length;i++)
        {
            if (map.containsKey(patternArray[i]))
            {
                if (!map.get(patternArray[i]).equals(strings[i]))
                    return false;
            }
            else
                map.put(patternArray[i],strings[i]);
            if (map2.containsKey(strings[i]))
            {
                if (!map2.get(strings[i]).equals(patternArray[i]))
                    return false;
            }
            else
                map2.put(strings[i],patternArray[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        leetcode1.wordPattern("abba","dog cat cat dog");
    }


}
