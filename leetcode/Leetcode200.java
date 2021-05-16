public class Leetcode200 {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (!visited[i][j]&&grid[i][j]=='1')
                {
                    res++;
                    getPath(grid,i,j);
                }
            }
        }
        return res;
    }

    private int[][] direct= {{0,1},{1,0},{0,-1},{-1,0}};

    private void getPath(char[][] grid,int i,int j)
    {
        if (grid[i][j]=='1')
            visited[i][j] = true;
        else
            return;
        for (int t=0;t<4;t++)
        {
            int newI = i+direct[t][0];
            int newJ = j+direct[t][1];
            if (newI>=0&&newI<grid.length&&newJ>=0&&newJ<grid[0].length&&!visited[newI][newJ])
                getPath(grid,newI,newJ);
        }
        return;

    }


}
