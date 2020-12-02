public class UnionFind2 {

    /**
     * 构造并查集方法2
     */


    private int[] parent; //并查集数组 用来表示其父节点所在数组位置
    private int count; //该并查集存储的数据数量

    public UnionFind2(int count) {
        parent = new int[count];
        for (int i = 0; i < count; i++)
            parent[i] = i;
        this.count = count;
    }

    /**
     * 查找节点p所在的树的根结点
     * @param p
     * @return
     */
    public int find(int p)
    {
        assert(p>0&&p<count);
        while (p!=parent[p])
            p = parent[p];
        return p;
    }

    /**
     * 查找p、q是否在同一个集合
     * @param p
     * @param q
     * @return
     */
    public boolean isConncetted(int p,int q)
    {
        return find(p)==find(q);
    }

    /**
     * 将 p和q进行并操作
     * @param p
     * @param q
     */
    public void UnionElements(int p,int q)
    {
        int p_root = find(p);
        parent[p_root] = find(q);
    }

}
