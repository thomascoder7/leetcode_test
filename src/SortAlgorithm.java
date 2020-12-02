public abstract class SortAlgorithm {
    public abstract void sort(int[] array);

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
