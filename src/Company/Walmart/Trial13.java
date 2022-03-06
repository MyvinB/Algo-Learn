package Company.Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:55 AM 3/6/2022
 * Time Taken:
 */
public class Trial13 {
    public static void main(String[] args) {
        int n = 4;
        int[] A  = new int[]{1,2,2};
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int k =2;
        for(int i=0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                map.put(A[i],new ArrayList<>());
            }
            List<Integer> temp = map.get(A[i]);
            temp.add(k++);
            map.put(A[i],temp);
        }
        System.out.println(map);


    }
}
