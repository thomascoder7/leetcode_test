public class Leetcode198 {

    // 存储考虑从0号到index之间进行偷取获取的钱数
    private int[] money;

    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++)
        {
            money[i] = Math.max(nums[i]+money[i-2],money[i-1]);
        }
        return money[nums.length-1];
    }


}
