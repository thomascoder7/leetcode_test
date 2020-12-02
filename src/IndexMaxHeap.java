public class IndexMaxHeap {

    /**
     * 索引堆
     */

    private int count = 0;
    private int capacity = 0;
    private int[] data;
    private int[] indexes;

    public IndexMaxHeap(int capacity)
    {
        data = new int[capacity+1];
        indexes = new int[capacity+1];
        this.capacity = capacity;
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
        assert(count+1<=capacity);
        assert(count+1<=capacity);
        count++;
        data[count] = item;
        indexes[count] = count;
        shiftUp(count);

    }

    private void shiftUp(int k) {

        while (k>1 && data[indexes[k/2]] <data[indexes[k]])
        {
            swap(indexes,k,k/2);
            k = k/2;
        }
    }

    public int extractMax()
    {
        assert(count>0);
        int ret = data[indexes[1]];

        swap(indexes,1,count);
        count--;
        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k)
    {
        while (k*2<=count)
        {
            int j = k*2;
            if (j+1<=count && data[indexes[j+1]] > data[indexes[j]])
                j++;

            if (data[indexes[k]]>data[indexes[j]])
                break;
            swap(indexes,k,j);
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
            System.out.printf(data[indexes[i]]+" ");
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

    /**
     * 更改某个index对应的data值
     * @param i
     * @param item
     */
    void change(int i, int item)
    {
        data[i] = item;
        //找到 i对应的在堆中的位置 之后对该位置执行shiftup shiftdown
        for (int j = 1; j < count; j++) {
            if (indexes[j] == i)
            {
                shiftDown(j);
                shiftUp(j);
                return;
            }
        }
    }


}
