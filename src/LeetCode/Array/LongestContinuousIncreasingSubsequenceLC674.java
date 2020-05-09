package LeetCode.Array;

/*
 @author Myvin Barboza
 26/03/20 10:00 AM 
 */public class LongestContinuousIncreasingSubsequenceLC674 {

    static int findLengthOfLCIS(int[] a) {
        int count=0;
        int max=0;
        for (int i = 0; i <a.length ; i++) {
            count++;
            if(i==a.length-1||(a[i]==a[i+1] || a[i]>a[i+1])){
                if(count>max)max=count;
                count=0;
            }

        }
        return max;
    }

    public static void main(String[] args) {

        int a[]={1,3,5,4,2,3,4,5};
        int b[]={2,2,2,2,2};
        System.out.println(findLengthOfLCIS(a));
        //System.out.println(findLengthOfLCIS(b));

    }
}