public class test {

    /**
     * 测试基础的排序算法
     * @param args
     */

    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 500000;
        int[] arr = sortTestHelper.generateRandomArray(n,0,n);
//        int[] arr = sortTestHelper.generateNearlyOrderedArray(n,200);
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();
        InsertSortOptimize insertSortOptimize = new InsertSortOptimize();
        MergeSort mergeSort = new MergeSort();
        MergeSortBU mergeSortBU = new MergeSortBU();
        QuickSort quickSort = new QuickSort();
        QuickSort2 quickSort2 = new QuickSort2();
        QuickSort3 quickSort3 = new QuickSort3();
//        sortTestHelper.TestSort("SelectionSort",selectionSort,arr.clone());
//        sortTestHelper.TestSort("InsertSort",insertSort,arr.clone());
//        sortTestHelper.TestSort("InsertSortOptimize",insertSortOptimize,arr.clone());
        sortTestHelper.TestSort("MergeSort",mergeSort,arr.clone());
        sortTestHelper.TestSort("MergeSortBU",mergeSortBU,arr.clone());
        sortTestHelper.TestSort("QuickSort",quickSort,arr.clone());
        sortTestHelper.TestSort("QuickSort2",quickSort2,arr.clone());
        sortTestHelper.TestSort("QuickSort3",quickSort3,arr.clone());
    }
}
