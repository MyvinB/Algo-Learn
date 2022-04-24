package Contest.LeetCode;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:08 AM 4/24/2022
 * Time Taken:
 */
public class Contest24thApril {

    public static void main(String[] args) {

    }

    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i :map.keySet()){
            if(map.get(i)==n){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }


    public int countLatticePoints(int[][] circles) {
        int totalPoints = 0;
        HashSet<String> set = new HashSet<>();
        for(int[] points:circles){
            int x = points[0];
            int y = points[1];
            int r = points[2];
            for(int i=x-r;i<=x+r;i++){
                for(int j=y-r;j<=y+r;j++){
                    //eucladion distance
                    if((x-i)*(x-i)+ (y-j)*(y-j)<= r*r){
                        set.add(i+ " "+j);
                    }
                }
            }
        }
        return set.size();
    }
}
