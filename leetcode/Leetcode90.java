import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tempRes = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length==0)
            return res;

        Arrays.sort(nums);
        visited = new boolean[nums.length];
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
            if (i>0&&nums[i-1]==nums[i]&&!visited[i-1])
                continue;
            visited[i] = true;
            tempRes.add(nums[i]);
            findSub(nums,i+1,tempRes);
            tempRes.remove(tempRes.size()-1);
            visited[i] = false;
        }
    }

}
