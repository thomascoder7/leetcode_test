public class UnionFind {

    /**
     * 并查集
     * 该种实现方法在查找时效率很快，但是在执行并操作时时间复杂度较高
     */

    private int[] id; //并查集数组 id[i] = j  表示第i个元素属于第j组，如果id[i+1] = j，说明i+1和i属于同一组
    private int count; //该并查集存储的数据数量

    public void UnionFind(int n)
    {
        count = n;
        id = new int[n];
        for(int i=0;i<n;i++)
        {
            id[i] = i;
        }
    }

    /**
     * 查找位置p的元素属于哪一组
     * @param p
     * @return
     */
    public int find(int p)
    {
        assert(p>=0&&p<count);
        return id[p];
    }

    /**
     * 对于p所在的组和q所在的组执行并操作
     * 该操作的时间复杂度为O(n)对于n个元素执行该操作则为O(n2)级别的操作，时间复杂度过高
     * @param p
     * @param q
     */
    public void Union(int p, int q)
    {
        int Pid = find(p);
        int Qid = find(q);
        if (Pid == Qid)
            return;
        for (int i=0;i<count;i++)
        {
            if (id[i]==Pid)
                id[i] = Qid;
        }
    }

    /**
     * 返回a和b是否连接
     * @param a
     * @param b
     * @return
     */
    public boolean isConnectted(int a,int b)
    {
        if (id[a]==id[b])
            return true;
        return false;
    }

}
