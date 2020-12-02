public class MergeSort extends SortAlgorithm{

    /**
     * 归并排序的优化：当归并到一定程度时，数据量很小，很容易是趋近于有序的数组，之后对这部分数据进行插入排序
     * @param array
     * @param l
     * @param r
     */
    private void insertSort(int[] array, int l, int r)
    {
        for (int i = l+1; i <= r; i++) {
            int j=i;
            int temp = array[i];
            for (;j>0 && temp<array[j-1];j--)
            {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }

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

    private void inerMergeSort(int[] array, int l, int r)
    {
//        if (l>=r)
//            return;
        //归并排序的优化
        if (r-l<=15)
        {
            insertSort(array,l,r);
            return;
        }

        int mid = (l+r)/2; //这里可能会出现l+r特别特别大越界的情况
        inerMergeSort(array, l, mid);
        inerMergeSort(array, mid+1 , r);

        //归并排序的优化：添加一个判断
        if (array[mid]>array[mid+1])
            merge(array,l,mid,r);

    }

    @Override
    public void sort(int[] array) {
        inerMergeSort(array,0,array.length-1);
    }
}
