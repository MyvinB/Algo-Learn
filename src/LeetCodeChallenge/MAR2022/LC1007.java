package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 11:47 AM 3/20/2022
 * Time Taken:
 */
public class LC1007 {

    public static void main(String[] args) {
        int[] t = new int[]{3,5,1,2,3};
        int[] b = new int[]{3,6,3,3,4};
        System.out.println(minDominoRotations(t,b));
    }


    //Naive no same check
    public  static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = bottoms.length;
        int[] t = new int[7];
        int[] b = new int[7];
        for(int i=0;i<n;i++){
            t[tops[i]]++;
            b[bottoms[i]]++;
        }
        int e = 0;
        int max = 0;
        for(int i=1;i<=6;i++){
           if(t[i]+b[i]>= n){
              e=i;
              max = Math.max(t[i],b[i]);
           }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(t[e]>=b[e] && tops[i]!=e && bottoms[i] == e){
                count++;
            }else if(b[e]>t[e] && bottoms[i]!=e && tops[i] == e){
                count++;
            }
        }

        return count+max==n?count:-1;

    }

    static int minDominoRotationsOpti(int[] tops, int[] bottoms) {
        int n = bottoms.length;
        int[] t = new int[7];
        int[] b = new int[7];
        int[] same = new int[7];
        for(int i=0;i<n;i++){
            t[tops[i]]++;
            b[bottoms[i]]++;
            if(tops[i]==bottoms[i])
                same[tops[i]]++;
        }

        for(int i=1;i<7;i++){
            if(t[i]+b[i]-same[i] == n) return n-Math.max(t[i],b[i]);
        }
        return -1;
    }



}
