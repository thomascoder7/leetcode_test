
public class SelectionSort extends SortAlgorithm {
    /**
     * 选择排序
     * @param array
     * @return
     */
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j]<min)
                {
                    min = array[j];
                    minIndex = j;
                }
            }
            array = super.swap(array,minIndex,i);
        }
    }
}
