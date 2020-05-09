package LeetCode.BitWiseAlgo;

/*
 @author Myvin Barboza
 26/04/20 10:30 AM 
 */public class OnebitandTwobitCharacters {

    static boolean isOneBitCharacter(int[] bits) {
     int one=0;
        for (int i = bits.length-2; i >=0 &&bits[i]!=0 ; i--) {
            one++;
        }
        if(one%2>0) return false;
        return true;
    }

     public static void main(String[] args) {
        int bit[]={1,0,1,1,0};
         System.out.println( isOneBitCharacter(bit));
    }
 }