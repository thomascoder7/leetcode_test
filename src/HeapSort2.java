public class HeapSort2 extends SortAlgorithm {
    @Override
    public void sort(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = maxHeap.extractMax();
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[temp.length-1-i];
        }

    }
}