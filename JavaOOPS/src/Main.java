import java.lang.reflect.Array;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        /*int[] arr = new int[5];
        arr[1] = 10;*/
        List<Integer> L1 = new ArrayList<Integer>();
        L1.add(0,10);
        L1.add(2);
        L1.add(20);
        L1.add(1,-1);
        L1.set(1,3);
        //L1.clear();
        List<Integer> L2 = new ArrayList<Integer>(Arrays.asList(200,300));
        L2.addAll(L1);
        Collections.sort(L2);
        Collections.reverse(L2);
        //Integer[] arr = L2.toArray();
        
    }
}