import java.util.Random;

public class SortTestHelper {

    /**
     * 生成一个具有n个随机数的随机数组，数组范围从rangeL到rangeR
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public int[] generateRandomArray(int n, int rangeL, int rangeR)
    {
        assert(rangeL<=rangeR);
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt() %(rangeR-rangeL+1)+rangeL;
        }
        return array;
    }

    /**
     * 生成一个近乎有序的数组
     * @param n
     * @param swapTimes
     * @return
     */
    public int[] generateNearlyOrderedArray(int n, int swapTimes)
    {
        int[] array = new int[n];
        for(int i=0; i<n; i++)
        {
            array[i] = i;
        }
        Random random = new Random();
        for(int i=0; i<swapTimes; i++)
        {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            array = swap(array,x,y);
        }
        return array;
    }

    /**
     * 打印数组
     * @param array
     */
    public void printArray(int[] array)
    {
        for (int a:array
             ) {
            System.out.printf(String.valueOf(a)+" ");
        }
        System.out.println();
    }

    /**
     * 测试排序性能
     * @param sortName
     * @param sortAlgorithm
     * @param array
     */
    public void TestSort(String sortName, SortAlgorithm sortAlgorithm, int[] array)
    {
        long startTime=System.currentTimeMillis();
        sortAlgorithm.sort(array);
        long endTime=System.currentTimeMillis();
        assert(isSorted(array));
//        printArray(array);
        System.out.println(sortName+"："+String.valueOf(endTime-startTime)+"ms");
    }

    /**
     * 判断是否成功排好序
     * @param array
     * @return
     */
    public boolean isSorted(int[] array)
    {
        for(int i=0;i<array.length-1;i++)
        {
            if (array[i]>array[i+1])
                return false;
        }
        return true;
    }

    /**
     * 交换数组两个元素
     * @param array
     * @param i
     * @param j
     * @return
     */
    int[] swap(int[] array, int i, int j)
    {
        if (i!=j)
        {
            int temp;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

}
