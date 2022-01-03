package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 11:46 AM 1/3/2022
 */
public class LC997 {

    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3}};
        System.out.println(findJudge(3,trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] degree = new int[n+1];
        for(int[] t :trust){
            //outdegree
            degree[t[0]]--;
            //inDegree
            degree[t[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==n-1){
              return i;
            }
        }
        return -1;
    }
}
