import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        getIpAddress(s,0,2,new StringBuffer(),0);
        return res;
    }

    public void getIpAddress(String s,int start,int end,StringBuffer tempRes,int pointNum)
    {

        if (start>=s.length()&&pointNum==4)
        {
            tempRes.deleteCharAt(tempRes.length()-1);
            res.add(tempRes.toString());
            return;
        }
        if (pointNum>4||start>=s.length())
            return;

        int newEnd = 0;
        for (int i=start;i<=end;i++)
        {
            StringBuffer temp = new StringBuffer();
            if (i==start&&s.charAt(i)=='0')
            {
                newEnd = i+3>=s.length()?s.length()-1:i+3;
                getIpAddress(s,i+1,newEnd,new StringBuffer(tempRes).append(temp).append("0."),pointNum+1);
                break;
            }

            for (int j=start;j<=i;j++)
            {
                temp.append(s.charAt(j));
            }
            if (i==end&&Integer.parseInt(temp.toString())>255)
            {

            }
            else
            {
                newEnd = i+3>=s.length()?s.length()-1:i+3;
                getIpAddress(s,i+1,newEnd,new StringBuffer(tempRes).append(temp).append('.'),pointNum+1);
            }
        }
    }
}
