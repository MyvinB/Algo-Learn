package LeetCodeChallenge.JUNE2022;

public class LC7 {

    public static void main(String[] args) {

    }

    public int reverse(int x) {
        int res =0;
        while(x!=0){
            int tail = x%10;
            int newResult = res *10+tail;
            if((newResult-tail)/10 !=res){
                return 0;
            }
            res = newResult;
            x =x/10;
        }
        return res;
    }
}
