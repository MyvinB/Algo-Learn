package Contest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:36 AM 3/13/2022
 * Time Taken:
 */
public class CountArtifactsThatCanBeExtracted {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,0,0,0},{0,1,1,1}};
        int[][] dig = new int[][]{{0,0},{0,1},{1,1}};
        System.out.println(digArtifacts(2,t,dig));
    }

    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashMap<Integer,Integer> artifactCount =new HashMap<>();
        int[][] N = new int[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
               N[row][col] = -1;
            }
        }
        for(int i =0;i<artifacts.length;i++){
            int rowStart = artifacts[i][0];
            int colStart = artifacts[i][1];
            int rowEnd = artifacts[i][2];
            int colEnd = artifacts[i][3];
            int count = 0;
            for(int row=rowStart;row<=rowEnd;row++){
                for(int col=colStart;col<=colEnd;col++){
                    N[row][col] = i;
                    count++;
                }
            }
            artifactCount.put(i,count);
        }
        int totalCount = 0;
        for(int[] d:dig){
            int i = d[0];
            int j = d[1];
            if(N[i][j]==-1) continue;
            int count = artifactCount.get(N[i][j]);
            count--;
            artifactCount.put(N[i][j],count);
            if(artifactCount.get(N[i][j])==0) totalCount++;
        }
        return totalCount;

    }
}
