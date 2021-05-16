import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Lu Qi
 * @Date 2021-03-02 23:41
 */

public class Leetcode70 {

    private List<Integer> temp = new ArrayList<>();

    public int climbStairs(int n) {

        temp.add(1);
        temp.add(2);
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
        {
            for (int i=2; i<n;i++)
            {
                temp.add(temp.get(i-1)+temp.get(i-2));
            }
        }


        return temp.get(n-1);
    }

    public static void main(String[] args) {

    }
}
