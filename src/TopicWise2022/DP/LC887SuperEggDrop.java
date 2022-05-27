package TopicWise2022.DP;

public class LC887SuperEggDrop {

    public static void main(String[] args) {

    }

    public int superEggDrop(int e, int n) {
        int T[][] = new int[e+1][n+1];
        for(int i=0;i<=n;i++){
            T[1][i] = i;
        }
        for(int i=2;i<=e;i++){
            for(int j=1;j<=n;j++){
                if(i>j) T[i][j] = T[i-1][j];

                else {
                    int l =1,h=j;
                    int min = Integer.MAX_VALUE;
                    while(l<h){
                        int mid = l+(h-l)/2;
                        int eggBreak = T[i-1][mid-1];
                        int eggNoBreak = T[i][j-mid];
                        int trialAtMid = 1+ Math.max(eggNoBreak,eggBreak);
                        min = Math.min(min,trialAtMid);
                        if(eggBreak==eggNoBreak) break;
                        else if(eggBreak<eggNoBreak) l=mid+1;
                        else h=mid;
                    }
                    T[i][j] = min;
                }
            }
        }
        return T[e][n];
    }
}
