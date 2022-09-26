package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC990 {

    public static void main(String[] args) {

    }
    //Easy union find problem
    int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++) uf[i] = i;
        for(String s:equations){
            if(s.charAt(1)=='='){
                uf[find(s.charAt(0)-'a')] = find(s.charAt(3)-'a');
            }
        }
        /*After putting all similar in same set then we can decide if they are in the same set or no*/
        for(String s:equations){
            if(s.charAt(1)=='!' && find(s.charAt(0)-'a')==find(s.charAt(3)-'a')){
                return  false;
            }
        }
        return true;
    }

    public int find(int x){
        if(x!=uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}
