package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC821 {


    public static void main(String[] args) {

    }
    //using two pointer technique
    public int[] shortestToChar(String s, char c) {
        int n = s.length(); int pos= -n ; int[] res = new int[n];
        //Distance from left
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c)pos = i;
            res[i] = i-pos;
        }
        //Distance from right take min of both and start from last pos so we do not get minus value
        for(int i=pos-1;i>=0;i--){
            if(s.charAt(i)==c) pos = i;
            res[i] = Math.min(res[i],pos-i);
        }
        return res;
    }
}
