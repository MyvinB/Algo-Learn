package LeetCode.Array;

/*
 @author Myvin Barboza
 08/03/20 9:41 AM
 Type:Contest
 Link: https://leetcode.com/problems/bulb-switcher-iii/
 */

public class BulbSwitcherIIILC1375 {
    static int numTimesAllBlue(int[] light) {
        int n=light.length;
        int []a= new int[n+1];
        boolean check=false;
        int count=0;
        int temp=0;
        for(int i=0;i<n;i++){
            a[light[i]]++;


            for(int j=light[i];j>0&&j>=temp;j--){
                if(a[j]==1){
                    check=true;
                    temp=temp-1;
                }

                else {
                    temp=j;
                    check=false;
                    break;
                }
            }
            if(check){
                ++count;
                check=false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int a[]={3,2,4,1,5};
        System.out.println(numTimesAllBlue(a));
    }
}