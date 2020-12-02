public class MaxHeap{

    /**
     * 大根堆
     */

    private int count = 0;
    private int capacity = 0;
    private int[] data;

    public MaxHeap(int capacity)
    {
        data = new int[capacity+1];
        this.capacity = capacity;
    }

    /**
     * 构造方法二
     * 通过shiftdown方法构造堆
     * @param array
     */
    public MaxHeap(int[] array)
    {
        data = new int[array.length+1];
        this.capacity = array.length+1;

        for (int i = 0; i < array.length; i++) {
            data[i+1] = array[i];
        }
        for (int i = array.length/2; i >0 ; i--) {
            shiftDown(i);
        }
        this.count = array.length;
    }

    public int getSize()
    {
        return count;
    }

    public Boolean isEmpty()
    {
        return count==0;
    }

    public void insert(int item)
    {
        assert(count<=capacity);
        count++;
        data[count] = item;
        shiftUp(count);


    }

    private void shiftUp(int k) {

        while (k>1 && data[k/2] <data[k])
        {
            swap(data,k,k/2);
            k = k/2;
        }
    }

    public int extractMax()
    {
        assert(count>0);
        int ret = data[1];

        swap(data,1,count);
        count--;
        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k)
    {
        while (k*2<=count)
        {
            int j = k*2;
            if (j+1<=count && data[j+1] > data[j])
                j++;

            if (data[k]>data[j])
                break;
            swap(data,k,j);
            k = j;
        }
    }

    public void testPrint()
    {
        int t=2;
        for (int i = 1; i <= count; i++) {
            if (i==t)
            {
                t*=2;
                System.out.println();
            }
            System.out.printf(data[i]+" ");
        }
    }

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
