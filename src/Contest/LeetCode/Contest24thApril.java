package Contest.LeetCode;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:08 AM 4/24/2022
 * Time Taken:
 */
public class Contest24thApril {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(res.size());
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

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] res = new int[points.length];
        List<List<Integer>> group = new ArrayList<>(101);
        for(int i = 0;i<101;i++){
            group.add(new ArrayList<>());
        }
        for(int[] rec:rectangles){
            int l = rec[0];
            int h = rec[1];
            group.get(h).add(l);
        }

        for(int i=0;i<group.size();i++){
            Collections.sort(group.get(i));
        }
        for(int i=0;i<points.length;i++){
            int count =0;
            int l = points[i][0];
            int h = points[i][1];
            for(int k=h;k<101;k++){
                List<Integer> temp = group.get(k);
                int index =  binarySearch(temp,l);
                count += temp.size() - index;
            }
            res[i] = count;
        }
        return res;
    }

    public int binarySearch(List<Integer> res,int target){
        //If it's not there low will move to size making count zero or else count index will be one value less
        int low = 0;
        int high = res.size();
        while(low<high){
            int mid = low + (high-low)/2;
            if(res.get(mid)<target){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }


}
