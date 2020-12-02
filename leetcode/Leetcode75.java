/**
 * @Auther Lu Qi
 * @Date 2020-08-12 21:53
 */

public class Leetcode75 {

    /**
     * 第一种思路，使用计数排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] count = {0,0,0};
        for(int i=0;i<nums.length;i++)
        {
            count[nums[i]] += 1;
        }
        int l = 0;
        for(int t=0;t<3;t++)
        {
            for(int i=0;i<count[t];i++)
            {
                nums[l] = t;
                l++;
            }
        }
    }

    /**
     * 第二种思路：使用三路快排的思想
     * [0,x)是0 ，[x,i)是1，i是当前指针位置，(y,length-1]是2,当i指针与y相遇时结束
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int x=0;
        int y=nums.length-1;
        int i=0;
        while (i <= y)
        {
            if (nums[i] == 0)
            {
                sw(nums,i,x);
                x++;
                i++;
            }
            else if (nums[i] == 2)
            {
                sw(nums,i,y);
                y--;
            }
            else
                i++;
        }
    }

    public void sw(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] count = {0,0,0};
        for(int i : count)
        {
            System.out.println(i);
        }
    }

}
