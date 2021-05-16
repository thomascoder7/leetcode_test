import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tempRes = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,0);
        return res;
    }

    public void dfs(int n,int k, int index)
    {
        if (tempRes.size()+(n-index)<k)
            return;

        if (tempRes.size()==k)
        {
            res.add(new ArrayList<>(tempRes));
            return;
        }


        for (int i=index+1;i<=n;i++)
        {
            tempRes.add(i);
            dfs(n,k,i);
            tempRes.remove(tempRes.size()-1);
        }
    }

}
