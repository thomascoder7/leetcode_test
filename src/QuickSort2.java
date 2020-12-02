import java.util.Random;

public class QuickSort2 extends SortAlgorithm{
    Random random = new Random();
    // 二路快排

    private int partation(int[] array, int l, int r)
    {

        int t = random.nextInt(r)%(r-l+1) + l;
        swap(array,l,t);
        int v = array[l];

        int i,j;
        i = l+1;
        j = r;
        //使得array[l...i) <= v array(j...r) >= v
        while (true)
        {
            while (i<=r && array[i] < v)
                i++;
            while (array[j] >v && j>=l+1)
                j--;
            if (j<i)
                break;
            swap(array,i,j);
            i++;
            j--;
        }
        swap(array,l,j);
        return j;
    }

    private void quicksort(int[] array,int l, int r)
    {
        if (l>=r)
            return;
        int t = partation(array,l,r);
        quicksort(array,l,t);
        quicksort(array,t+1,r);
    }

    @Override
    public void sort(int[] array) {
        quicksort(array,0,array.length-1);
    }
}
