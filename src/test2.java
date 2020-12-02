import java.util.Random;

public class test2 {

    /**
     * 测试堆排序
     * @param args
     */

//    public static void main(String[] args) {
//        Random random = new Random();
//        MaxHeap maxHeap = new MaxHeap(100);
//        for (int i = 0; i < 15; i++) {
//            maxHeap.insert(random.nextInt(100));
//        }
//
//        for (int i = 0; i < 15; i++) {
//            System.out.printf(maxHeap.extractMax()+" ");
//        }
//    }

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 15;
        int[] arr = sortTestHelper.generateRandomArray(n,0,n);
//        int[] arr = sortTestHelper.generateNearlyOrderedArray(n,200);
        HeapSort heapSort = new HeapSort();
        HeapSort2 heapSort2 = new HeapSort2();
        HeapSort3 heapSort3 = new HeapSort3();
        sortTestHelper.TestSort("HeapSort",heapSort,arr.clone());
        sortTestHelper.TestSort("HeapSort2",heapSort2,arr.clone());
        sortTestHelper.TestSort("HeapSort3",heapSort3,arr.clone());

        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(n);
        for (int i = 0; i < n; i++) {
            indexMaxHeap.insert(arr[i]);
        }
        indexMaxHeap.testPrint();
        indexMaxHeap.change(2,100);
        System.out.println();
        indexMaxHeap.testPrint();
    }

}
