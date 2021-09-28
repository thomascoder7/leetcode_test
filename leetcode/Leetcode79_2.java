import java.util.List;

public class Leetcode79_2 {

    boolean[][] visited;
    int[][] dirList = {{0,1},{0,-1},{-1,0},{1,0}};

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if (getPath(board,word,0,i,j))
                    return true;
            }
        }
        return false;
    }

    private boolean checkOutBound(char[][] board,int i,int j)
    {
        if (i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        return true;
    }


    private boolean getPath(char[][] board, String word, int index,int i,int j)
    {
        if (board[i][j]==word.charAt(index) && index==word.length()-1)
            return true;
        if (board[i][j]!=word.charAt(index))
            return false;

        visited[i][j] = true;
        for (int k=0;k<4;k++)
        {
            int new_i = i+dirList[k][0];
            int new_j = j+dirList[k][1];
            if (checkOutBound(board,new_i,new_j)&&!visited[new_i][new_j])
                if(getPath(board,word,index+1,new_i,new_j))
                    return true;

        }
        visited[i][j] = false;
        return false;
    }


}
