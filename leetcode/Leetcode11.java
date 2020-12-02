public class Leetcode11 {

    public int maxArea(int[] height) {
        int max = 0;
        int temp = 0;
        int l=0,r=height.length-1;
        if (height.length<2)
            return 0;
        max = get_size(height[l],height[r],r-l);
        while (l<r)
        {
            if (height[l]<height[r])
            {
                l++;
                if (height[l]>height[l-1])
                {
                    temp = get_size(height[l],height[r],r-l);
                    if (temp>max)
                        max = temp;
                }
            }
            else
            {
                r--;
                if (height[r]>height[r+1])
                {
                    temp = get_size(height[l],height[r],r-l);
                    if (temp>max)
                        max = temp;
                }
            }
        }
        return max;
    }

    private int get_size(int l_h, int r_h, int wide)
    {
        int h = l_h>r_h?r_h:l_h;
        return h*wide;
    }

    public static void main(String[] args) {
        
    }


}
