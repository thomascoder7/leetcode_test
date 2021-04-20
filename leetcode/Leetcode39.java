import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();


    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<Integer> temRes = new ArrayList<>();
        getNum(candidates,0,0,target,temRes);
        return res;
    }


    public void getNum(int[] candidates,int index,int now, int target,List<Integer> temRes)
    {
        if (index==candidates.length)
            return;

        if (now>target)
            return;

        if (now==target)
        {
            res.add(new ArrayList<>(temRes));
            return;
        }


        for (int i=index;i<candidates.length;i++)
        {
            temRes.add(candidates[i]);
            getNum(candidates,i,now+candidates[i],target,temRes);
            temRes.remove(temRes.size()-1);
        }
    }
}
