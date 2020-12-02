public class QuickSort3 extends SortAlgorithm {
    @Override
    public void sort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    public void quickSort(int[] array,int l,int r)
    {
        if (l>=r)
            return;
        int p = partition(array,l,r);
        quickSort(array,l,p);
        quickSort(array,p+1,r);
    }

    public int partition(int[] array,int l,int r)
    {
        int x = array[l];
        while (l<r)
        {
            while (l<r)
            {
                if (array[r]<x)
                {
                    array[l] = array[r];
                    break;
                }
                r--;
            }
            while (l<r)
            {
                if (array[l]>x)
                {
                    array[r] = array[l];
                    break;
                }
                l++;
            }
        }
        array[l] = x;
        return l;
    }

}
