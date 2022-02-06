package LeetCodeChallenge.Feb2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 8:09 AM 2/6/2022
 * Time Taken:
 */
public class LCContestW1 {

    public static void main(String[] args) {
        int[] t = new int[]{36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34};
        System.out.println(smallestNumber(-7605));
    }


    public static int[] sortEvenOdd(int[] nums) {

        if(nums!=null && nums.length<=2) return nums;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-2;j++){
                if(j%2==0 && nums[j]>nums[j+2]){
                    swap(nums,j,j+2);
                }else if (j%2!=0 && nums[j]<nums[j+2]){
                    swap(nums,j,j+2);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] A, int x,int y){
        int temp = A[x];
        A[x]= A[y];
        A[y]= temp;
    }

    public static long smallestNumber(long num) {
        int[] t = new int[10];
        long res=0;
        long temp = num;
        while(temp!=0){
            long index = temp%10;
            if(index<0) index = index *-1;
            t[(int) (index)]++;
            temp=temp/10;
        }


        if(num<0){
            for(int i=9;i>=0;){
                if(t[i]!=0){
                    res = res*10+i;
                    t[i]--;
                }else i--;
            }
            return -res;
        }else {
            for(int i=1;i<=9;){
                if(res!=0 && t[0]!=0){
                    t[0]--;
                    res = res*10;
                }
                else if(t[i]!=0){
                    res = res*10+i;
                    t[i]--;
                }else i++;
            }
        }

        return res;

    }

    class Bitset {

        int[] t;

        public Bitset(int size) {
            t = new int[size];
        }

        public void fix(int idx) {
            t[idx] = 1;
        }

        public void unfix(int idx) {
            t[idx]=0;
        }

        public void flip() {
            for(int i=0;i<t.length;i++){
                t[i] = t[i]^1;
            }
        }

        public boolean all() {
            for(int i=0;i<t.length;i++){
                if(t[i]!=1) return false;
            }
            return true;
        }

        public boolean one() {
            for(int i=0;i<t.length;i++){
                if(t[i]==1) return true;
            }
            return false;
        }

        public int count() {
            int count=0;
            for(int i=0;i<t.length;i++){
                if(t[i]==1) count++;
            }
            return count;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<t.length;i++){
                sb.append(t[i]+"");
            }
            return sb.toString();
        }
    }

}
