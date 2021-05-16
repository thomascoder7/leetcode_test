import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode17 {

    private List<String> res = new ArrayList<>();
    private List<String> letters = Arrays.asList(" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)
            return res;
        getCombinations(digits,0,new StringBuffer());
        return res;
    }

    public void getCombinations(String digits,int index,StringBuffer combination) {

        if (index==digits.length())
        {
            res.add(combination.toString());
            return;
        }


        for (int i=0;i<letters.get(Character.getNumericValue(digits.charAt(index))).length();i++)
        {
            getCombinations(digits,index+1,new StringBuffer(combination).append(letters.get(Character.getNumericValue(digits.charAt(index))).charAt(i)));

        }
    }
}
