public class Leetcode213 {

    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);

        return Math.max(robFrom(nums,0,nums.length-2),robFrom(nums,1,nums.length-1));
    }

    private int robFrom(int[] nums,int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);

        for (int i=start+2;i<=end;i++)
        {
            int temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;

    }



}
