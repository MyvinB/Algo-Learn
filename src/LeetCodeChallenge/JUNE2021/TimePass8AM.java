package LeetCodeChallenge.JUNE2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TimePass8AM {

    public static void main(String[] args) {
        int[][] t = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(t));
    }

    public char repeatedCharacter(String s) {
        int[] t = new int[26];
        for(int i=0;i<s.length();i++){
            t[s.charAt(i)-'a']++;
            if(t[s.charAt(i)-'a']>=2) return s.charAt(i);
        }
        return '\0';
    }

    public static int equalPairs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0,j = 0;
        int p = 0,q=0;
        int count = 0;
        while(i<m && j<n && p<m && q<n){
            if(grid[i][j]==grid[p][q]){
                j++;
                p++;
            }else{
                q++;
                j=0;
                p=0;
            }
            if(j==n && p==m){
                count++;
                q++;
                j=0;
                p=0;
            }
            if(q==n){
                //Move to next row comparison
                q= 0;
                i++;
            }

        }
        return count;
    }


}
