package Contest.LeetCode;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:52 AM 4/3/2022
 * Time Taken:
 */
public class FIndPlayersWithZeorOneLoss {

    public static void main(String[] args) {
       int[][] t = new int[][]{	{2,3},{1,3},{5,4},{6,4}};
        System.out.println(findWinners(t));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> won = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> lost = new ArrayList<>();
        List<Integer> lostOne = new ArrayList<>();

        for(int[] c:matches){
            lost.add(c[1]);
            map.put(c[1],map.getOrDefault(c[1],0)+1);
        }
        for(int[] c:matches){

            if(lost.contains(c[0])){
                won.remove((Integer)c[0]);
                continue;
            }
            if(won.contains(c[0])) continue;

            won.add(c[0]);

        }
        for(int k:map.keySet()){
            if(map.get(k)==1) lostOne.add(k);
        }
        System.out.println(won);
        System.out.println(lostOne);
        Collections.sort(won);
        Collections.sort(lostOne);
        List<List<Integer>> res = new ArrayList<>();
        res.add(won);
        res.add(lostOne);
        return res;

    }
}
