import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temRes = new ArrayList<>();
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        Arrays.fill(visited,false);
        getNum(candidates,0,0,target,temRes);
        return res;
    }

    public void getNum(int[] candidates,int index,int now, int target,List<Integer> temRes)
    {

        if (now>target)
            return;

        if (now==target)
        {
            res.add(new ArrayList<>(temRes));
            return;
        }
        if (index==candidates.length)
            return;


        for (int i=index;i<candidates.length;i++)
        {
            if (i>0&&candidates[i-1]==candidates[i]&&!visited[i-1])
                continue;
            temRes.add(candidates[i]);
            visited[i] = true;
            getNum(candidates,i+1,now+candidates[i],target,temRes);
            temRes.remove(temRes.size()-1);
            visited[i] = false;
        }
    }


}
