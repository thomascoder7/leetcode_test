public class MergeSortBU extends SortAlgorithm{

    /**
     * 自底向上的归并排序
     * @param array
     * @param l
     * @param mid
     * @param r
     */

    private void merge(int[] array, int l, int mid, int r)
    {
        int[] aux = new int[r-l+1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = array[i+l];
        }
        int x,y,z;
        x = 0;
        y = mid+1-l;
        z = l;
        while (x<mid+1-l && y<=r-l)
        {
            if (aux[x]<aux[y])
            {
                array[z] = aux[x];
                z++;
                x++;
            }
            else
            {
                array[z] = aux[y];
                z++;
                y++;
            }
        }
        while (x<mid+1-l)
        {
            array[z] = aux[x];
            z++;
            x++;
        }
        while (y<=r-l)
        {
            array[z] = aux[y];
            z++;
            y++;
        }
    }

    private int min(int x, int y)
    {
        if (x<y)
            return x;
        return y;
    }

    @Override
    public void sort(int[] array) {
        for (int sz = 1; sz <= array.length; sz+=sz) {
            for (int  i= 0;  i+sz<array.length ; i+=(2*sz)) {
                merge(array,i,i+sz-1,min(i+sz+sz-1,array.length-1));
            }
        }
    }
}
