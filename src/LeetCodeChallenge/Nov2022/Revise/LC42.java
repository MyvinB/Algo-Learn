package LeetCodeChallenge.Nov2022.Revise;

public class LC42 {

    public static void main(String[] args) {

    }

    public int trap(int[] A) {
        int n = A.length;
        int l=0,r=n-1;
        int leftMax = Integer.MIN_VALUE,rightMax = Integer.MIN_VALUE,res=0;
        while(l<r){
            if(A[l]<=A[r]){
                if(A[l]>leftMax) leftMax = A[l];
                else res+= leftMax-A[l++];
            }else{
                if(A[r]>rightMax) rightMax = A[r];
                else res+=rightMax-A[r--];
            }
        }
        return res;
    }
}
