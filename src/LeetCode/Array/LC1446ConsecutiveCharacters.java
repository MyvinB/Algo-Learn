package LeetCode.Array;

public class LC1446ConsecutiveCharacters {

    public static void main(String[] args) {
        String s="abbcccddddeeeeedcba";
        String p="triplepillooooow";
        System.out.println(maxPower(p));
    }

   static int maxPower(String s) {
        int count=1;
        int max=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }
            else{
                max=Math.max(count,max);
                count=1;
            }
        }

       if(count!=1){
           max=Math.max(count,max);
       }

        return max;
    }
}
