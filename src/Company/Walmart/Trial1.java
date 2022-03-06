package Company.Walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@author mmichaelbarboza
 * on 7:09 AM 2/26/2022
 * Time Taken: 
 */public class Trial1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        String t = br.readLine();
        int ar[][] = new int[n][n];
        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ar[i][j] = t.charAt(k++)-'0';
            }
        }
        System.out.println(dfs(ar,0,0));

    }

    public static boolean dfs(int[][] ar,int i, int j){
        if(i<0 || i>=ar.length || j<0 || j>=ar.length || ar[i][j] == 0){
            return false;
        }

        if(i==ar.length - 1 && j==ar[0].length-1){
            return true;
        }

        //down right
        int[][] dir = new int[][]{{1,0},{0,1}};
        boolean check = false;
        for(int[] d:dir){
            check = check  || dfs(ar,i+d[0],j+d[1]);
        }
        return check;

    }
}
