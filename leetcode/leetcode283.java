/**
 * @Auther Lu Qi
 * @Date 2020-08-11 18:43
 */

public class leetcode283 {
    /**
     *   这道题遇到的问题在于当遇到连续的0时i和j如何向后移动，以及i和j不越界，共提交了8次
     *   我的思路需要不断的进行交换操作，性能有较大损失
     *   思路2：提取出数组中不为0的元素，将他们一次赋值到数组，剩余的元素即为0，如moveZeroes2所示
     */
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=1;
        if(nums.length <=1)
            return;
        while(i<nums.length-1 && j<=nums.length-1)
        {
            if(nums[i]==0)
            {
                while(nums[j]==0)
                {
                    if(j<nums.length-1)
                        j++;
                    else
                        break;
                }
                if(j<=nums.length-1)
                {
                    swit(nums, i, j);
                }
            }
            i++;
            j++;
        }
    }

    public void swit(int[] nums, int i, int j)
    {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void moveZeroes2(int[] nums) {
        int i=0;
        int j=0;
        if(nums.length <=1)
            return;
        while (j<=nums.length-1)
        {
            if (nums[j]!=0)
            {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i<=nums.length-1)
        {
            nums[i] = 0;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        leetcode283 aleetcode283 = new leetcode283();
        aleetcode283.moveZeroes(a);
        for(int t=0;t<a.length;t++)
            System.out.println(a[t]);
    }


}


