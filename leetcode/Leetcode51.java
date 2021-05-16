import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {

    boolean[] cols; //表示列是否有棋子了
    boolean[] dia1; //表示右上角到左下角的对角线
    boolean[] dia2; //表示左上角到右下角的对角线
    List<List<String>> res;
    List<String> tempRes;


    public List<List<String>> solveNQueens(int n) {

        cols = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];

        res = new ArrayList<List<String>>();

        tempRes = new ArrayList<>();
        getDone(0,n);
        return res;

    }

    private void getDone(int row,int n)
    {

        if (row>=n)
        {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i=0;i<n;i++)
        {
            if (checkOut(row,i,n))
            {
                cols[i] = true;
                dia1[row+i] = true;
                dia2[row-i+n-1] = true;
                StringBuffer stringBuffer = new StringBuffer();
                for (int j=0;j<n;j++)
                {
                    if (j==i)
                        stringBuffer.append('Q');
                    else
                        stringBuffer.append('.');
                }
                tempRes.add(stringBuffer.toString());
                getDone(row+1,n);
                cols[i] = false;
                dia1[row+i] = false;
                dia2[row-i+n-1] = false;
                tempRes.remove(tempRes.size()-1);
            }
        }
    }

    private boolean checkOut(int row,int col,int n)
    {
        if (!cols[col]&&!dia1[row+col]&&!dia2[row-col+n-1])
            return true;
        else
            return false;
    }

}
