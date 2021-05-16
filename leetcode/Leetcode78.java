import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tempRes = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length==0)
            return res;

        findSub(nums,0,tempRes);
        return res;
    }

    public void findSub(int[] nums,int index,List<Integer> tempRes)
    {
        res.add(new ArrayList<>(tempRes));
        if (index==nums.length)
            return;

        for (int i=index;i<nums.length;i++)
        {

            tempRes.add(nums[i]);
            findSub(nums,i+1,tempRes);
            tempRes.remove(tempRes.size()-1);
        }
    }

}
