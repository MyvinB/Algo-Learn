package Contest.LeetCode;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest14May {

    public static void main(String[] args) {
       // System.out.println(divisorSubstrings(430043,2));
//        System.out.println(waysToSplitArray(new int[]{1,1,1,2,3}));
        int[][] t = new int[][]{{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},{8096,8104},{7917,7925},{8027,8035},{8003,8011}};
                //{{1,5},{10,11},{12,18},{20,25},{30,32}};
                //{{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},{8096,8104},{7917,7925},{8027,8035},{8003,8011}};
        System.out.println(maximumWhiteTiles(t,9854));
    }


    public static int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int n = s.length();
        int count = 0;
        for(int i=0;i<=n-k;i++){
            int t = Integer.parseInt(s.substring(i,i+k));
            if(t==0) continue;
            if(num%t==0)count++;
        }
        return count;

    }

    public static int waysToSplitArray(int[] nums) {
        long total = 0,count=0,preSum=0;
        for(int i=0;i<nums.length;i++) total+=nums[i];
        for(int i=0;i<nums.length-1;i++){
            preSum += nums[i];
            if(preSum >=total-preSum) count++;
        }
        return (int)count;
    }


    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->a[0]-b[0]);
        int maxCount = 0;
        int n = tiles.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int curBegin = tiles[i][0];
                int curEnd = tiles[i][1];
                int nextBegin = tiles[j][0];
                int nextEnd = tiles[j][1];
                int countAll = nextEnd-curBegin+1;
                int countNonWhite = nextBegin-curEnd-1;
                if(countAll<=carpetLen){
                    maxCount = Math.max((countAll-countNonWhite),maxCount);
                }
            }
        }

        return maxCount;
    }
}
