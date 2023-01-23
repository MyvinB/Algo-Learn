package Year2023.Jan;

public class LC997 {

    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        int[] ownerAr = new int[n+1];
        for(int[] t:trust){
            int u = t[0];
            int v = t[1];
            ownerAr[u]--;
            ownerAr[v]++;
        }
        for(int i=1;i<n;i++){
            if(ownerAr[i]==n-1) return i;
        }
        return -1;
    }
}
