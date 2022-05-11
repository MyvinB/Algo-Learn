package LeetCodeChallenge.MAY2022;

public class LC1641 {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {
        if(n<1){
            return 0;
        }
        return countVowelStrings(n, 0);
    }

    private static int countVowelStrings(int n, int i){
        if(n == 1){
            return 5-i;
        }
        int count=0;
        for(int j=i;j<5;j++){
            count += countVowelStrings(n-1,j);
        }
        return count;
    }
}
