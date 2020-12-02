public class InsertSortOptimize extends SortAlgorithm{
    /**
     * 插入排序的优化，不频繁的进行交换操作
     * @param array
     */
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j=i;
            int temp = array[i];
            for (;j>0 && temp<array[j-1];j--)
            {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }
}
