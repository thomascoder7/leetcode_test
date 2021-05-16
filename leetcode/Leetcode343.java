import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Lu Qi
 * @Date 2021-03-06 22:26
 */
//该解法运行速度和内存消耗均不理想

public class Leetcode343 {

    List<Integer> temp = new ArrayList<Integer>();

    public int integerBreak(int n) {
        temp.add(1);
        temp.add(1); //2 = 1+1
        temp.add(2); // 3 = 1+2
        if (n==2 || n==3)
            return temp.get(n-1);
        for (int i=4;i<=n;i++)
        {
            int max_value = 0;
            for (int j=1;j<i;j++)
            {
                int value = max4(temp.get(j-1)*temp.get(i-j-1),temp.get(j-1)*(i-j),j*temp.get(i-j-1),j*(i-j));
                if (value>max_value)
                    max_value = value;
            }
            temp.add(max_value);
        }
        return temp.get(n-1);


    }

    private int max4(int a,int b,int c,int d)
    {
        return Math.max(Math.max(c,Math.max(a,b)),d);
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        System.out.println(leetcode343.integerBreak(10));
    }


}
