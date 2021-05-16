public class Leetcode52 {

    boolean[] cols; //表示列是否有棋子了
    boolean[] dia1; //表示右上角到左下角的对角线
    boolean[] dia2; //表示左上角到右下角的对角线
    int res = 0;


    public int totalNQueens(int n) {

        cols = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        getDone(0,n);
        return res;

    }

    private void getDone(int row,int n)
    {

        if (row>=n)
        {
            res++;
            return;
        }

        for (int i=0;i<n;i++)
        {
            if (checkOut(row,i,n))
            {
                cols[i] = true;
                dia1[row+i] = true;
                dia2[row-i+n-1] = true;

                getDone(row+1,n);
                cols[i] = false;
                dia1[row+i] = false;
                dia2[row-i+n-1] = false;

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
