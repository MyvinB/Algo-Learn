package LeetCode.Array;
/*
 @author Myvin Barboza
 10/05/20 4:29 PM 
 */

public class LC997FindTheTownJudge {

    //++1 for trusting someone
    public int findJudge(int N, int[][] trust) {
        int a[]=new int[N+1]; //people
        int b[]=new int[N+1]; // possible town people
        for(int i=0;i<trust.length;i++){
            a[trust[i][0]]++;
            b[trust[i][1]]++;
        }

        for(int i=1;i<=N;i++){
            //if the town people have increments of following of everyone -1 ie that is their self
            //and they never followed anyone
            if(b[i]==N-1 && a[i]==0) return i;
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}