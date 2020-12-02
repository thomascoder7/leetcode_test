import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test4 {
    private int a=10;

    public static void main(String[] args) {

        List<String> b = new ArrayList<>();
        b.add("fff");
        for (String i:b)
        {
            System.out.println(i);
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(1,10);
        map.put(2,100);
        for (Integer i : map.keySet())
        {
            System.out.println(map.get(i));
        }
        System.out.println("fsddsf");
        test4 t = new test4();

        System.out.println(t.a);
    }

}


