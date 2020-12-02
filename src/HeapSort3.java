public class HeapSort3 extends SortAlgorithm{
    @Override
    public void sort(int[] array) {
        MaxHeap3 maxHeap3 = new MaxHeap3(array);
    }





    private class MaxHeap3
    {

        MaxHeap3(int[] array)
        {
            for (int i = (array.length-1)/2; i >= 0; i--) {
                shiftDown(array, array.length-1,i);
            }
            for (int i = array.length-1; i > 0; i--) {
                swap(array,0,i);
                shiftDown(array, i,0);
            }

        }


        /**
         *
         * @param array
         * @param n 当前需要shiftDown的数组长度
         * @param k 当前需要shiftDown的元素下标
         */
        private void shiftDown(int[] array, int n, int k)
        {
            while (k*2+1<=n)
            {
                int j = k*2+1;
                if (j+1<=n && array[j+1] > array[j])
                    j++;

                if (array[k]>array[j])
                    break;
                swap(array,k,j);
                k = j;
            }
        }
    }
}
