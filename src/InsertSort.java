public class InsertSort extends SortAlgorithm{
    /**
     * 插入排序
     * @param array
     * @return
     */
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j]<array[j-1]; j--) {
                swap(array,j,j-1);
            }
        }
    }
}
