package Company.Trial;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 6:00 AM 2/26/2022
 * Time Taken:
 */
///FAIL NEED A BETTER SOLN
public class MexEquality {

    public static void main(String[] args) {
        int[][] t = new int[][]{{2,5,6,5,2},{1,7,9,7,2}};
        System.out.println(solve(2,3, t));
    }

    static int solve(int N, int M, int[][] Arr){
        // code here        int result = 0;         return result;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i< Arr.length;i++){
            Set<Integer> tempSet = new HashSet<>();
            for(int j=0;j<Arr[i].length;j++){
                min = Math.min(Arr[i][j],min);
                max = Math.max(Arr[i][j],max);
                tempSet.add(Arr[i][j]);
            }
            map.put(i,tempSet);
        }

        for(int k=min;k<=max;k++){
            for(int i:map.keySet()){
                if(!map.get(i).contains(k)) set.add(k);
            }
        }


        return set.size();
    }
}
