/**
 * @Auther Lu Qi
 * @Date 2020-08-14 0:34
 */

public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        int flag = 0;
        int i=0;
        int j=nums.length-1;
        int l=0;
        int r=nums.length-1;
        if(nums.length==1)
            return nums[0];
        while(true)
        {
            flag = partition(nums,l,r);
            if(flag == k-1)
                return nums[flag];
            else if (flag<k-1)
                l = flag+1;
            else
                r = flag-1;

        }
    }

    public int partition(int[] nums, int l,int r)
    {
        if (l==r)
            return l;
        int i=l+1;
        int j=r;
        int temp;
        while(true)
        {
            while(nums[i]>=nums[l])
            {
                i++;
                if (i>r)
                    break;
            }

            while(nums[j]<=nums[l] && j>=l+1)
                j--;
            if (i==j)
            {
                temp = nums[l];
                nums[l] = nums[j];
                nums[j] = temp;
                break;
            }
            if(i>j)
                break;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        temp = nums[l];
        nums[l] = nums[j];
        nums[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        Leetcode215 leetcode215 = new Leetcode215();
        int[] a = {3,2,1,5,6,4};
        int[] b = {2,1};
        leetcode215.findKthLargest(b,2);
        for(int i:b)
            System.out.println(i);
    }
}
