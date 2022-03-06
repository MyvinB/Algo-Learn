package Company.Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mmichaelbarboza
 * on 11:55 AM 3/6/2022
 * Time Taken:
 */
public class Trial13 {
    public static void main(String[] args) {
        int n = 5;
        int[] A  = new int[]{1,2,3,3};
        ConcurrentHashMap<Integer, List<Integer>> map = new ConcurrentHashMap<>();
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
        for(int i:map.keySet()){
            List<Integer> temp = map.get(i);
            if(temp.size() >1){
                map.put(temp.get(temp.size()-1),new ArrayList<>());
                temp.remove(temp.size()-1);
                map.put(i,temp);
            }

        }
        System.out.println(map);
    }

    public static int hackl(int i){
        return i =+ i +i %4;
    }
}
