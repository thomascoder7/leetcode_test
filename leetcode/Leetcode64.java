/**
 * @Auther Lu Qi
 * @Date 2021-03-04 16:27
 */

public class Leetcode64 {


    public int minPathSum(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];

        for (int x=0;x<grid.length;x++)
        {
            for (int y=0;y<grid[0].length;y++)
            {
                if (x==0 && y==0)
                    temp[0][0] = grid[0][0];
                else if (x==0)
                    temp[x][y] = temp[x][y-1] + grid[x][y];
                else if (y==0)
                    temp[x][y] = temp[x-1][y] + grid[x][y];
                else
                    temp[x][y] = Math.min(temp[x-1][y] + grid[x][y],temp[x][y-1] + grid[x][y]);
            }
        }
        return temp[grid.length-1][grid[0].length-1];
    }


    public static void main(String[] args) {

    }
}
