import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode20 {

    public boolean isValid(String s) {
        if (s.length()%2==1)
            return false;
        Deque<Character> stack = new LinkedList<Character>();

        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        for (char c :s.toCharArray())
        {
            if (map.containsKey(c))
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty()||c!=map.get(stack.peek()))
                    return false;
                else
                {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }


}
