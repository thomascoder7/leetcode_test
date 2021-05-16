import java.util.LinkedList;
import java.util.Queue;

public class Leetcode279 {

    private class Pair{
        int a;
        int b;
        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

    }

    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(n,0));

        boolean[] visited = new boolean[n+1];
        while (!queue.isEmpty())
        {
            Pair tempPair = queue.poll();
            for (int i=1;;i++)
            {
                int temp = tempPair.a - i*i;
                if (temp<0)
                    break;
                if (temp==0)
                    return tempPair.b+1;
                if (!visited[temp])
                {
                    queue.offer(new Pair(temp,tempPair.b+1));
                    visited[temp] = true;
                }
            }
        }
        return 0;
    }

}
