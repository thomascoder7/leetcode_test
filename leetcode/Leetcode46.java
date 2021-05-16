import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode46 {

    class Solution {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] checkOut;

        public List<List<Integer>> permute(int[] nums) {
            checkOut = new boolean[nums.length];
            Arrays.fill(checkOut,false);
            getPermute(nums,0,new ArrayList<Integer>(),checkOut);
            return res;
        }

        public void  getPermute(int[] nums, int index, List<Integer> tempRes,boolean[] checkOut)
        {
            if (index==nums.length)
            {
                res.add(tempRes);
                return;
            }

            for (int i=0;i<nums.length;i++)
            {
                if (!checkOut[i])
                {
                    tempRes.add(nums[i]);
                    checkOut[i] = true;
                    getPermute(nums,index+1,new ArrayList<>(tempRes),checkOut);
                    checkOut[i] = false;
                    tempRes.remove(tempRes.size()-1);
                }

            }

        }
    }

}
