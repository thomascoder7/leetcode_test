public class Leetcode79 {

    private int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int x=0;x<board.length;x++)
        {
            for (int y=0;y<board[0].length;y++)
            {
                if (getPath(board,word,0,x,y))
                    return true;
            }
        }
        return false;
    }

    private boolean checkOut(int X, int Y, int nowX, int nowY)
    {
        return nowX>=0&&nowX<X&&nowY>=0&&nowY<Y;
    }

    private boolean getPath(char[][] board, String word, int index, int startX, int startY)
    {
        if (word.length()-1==index&&word.charAt(index)==board[startX][startY])
            return true;

        if (word.charAt(index)==board[startX][startY])
        {
            visited[startX][startY] = true;
            for (int i=0;i<4;i++)
            {
                int newX = startX+direct[i][0];
                int newY = startY+direct[i][1];
                if (checkOut(board.length,board[0].length,newX,newY)&&!visited[newX][newY])
                {
                    if (getPath(board,word,index+1,newX,newY))
                        return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;

    }

}
