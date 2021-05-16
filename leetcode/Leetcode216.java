import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tempRes = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        getNum(k,n,0,1);
        return res;
    }

    public void getNum(int k,int target,int now,int index)
    {

        if (now==target&&k==0)
        {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        if (now>target||k==0)
            return;

        for (int i=index;i<=9;i++)
        {
            tempRes.add(i);
            getNum(k-1,target,now+i,i+1);
            tempRes.remove(tempRes.size()-1);
        }

    }

}
