import java.util.Random;

public class QuickSort extends SortAlgorithm{
    Random random = new Random();

    private int partition(int[] array, int l, int r)
    {

//        快速排序的优化：如果用快速排序对近乎有序数组排序会使得其退化成O(n2)的算法
//        通过每次随机取标定元素对其进行优化

        int t = random.nextInt(r)%(r-l+1) + l;
        swap(array,l,t);
        int v = array[l];

        int j = l;
        // 这一步使v=array[l] 使array[l+1]到array[j] < v 使array[j+1]到array[i] >v
        for(int i=l+1;i <= r;i++)
        {
            if (array[i]<v)
            {
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }

    private void quickSort(int[] array, int l, int r)
    {
        if (l>=r)
            return;
        int p = partition(array,l,r);
        quickSort(array,l,p);
        quickSort(array,p+1,r);
    }

    @Override
    public void sort(int[] array) {
        quickSort(array,0,array.length-1);
    }
}
