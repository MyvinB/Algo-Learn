package LeetCodeChallenge.Oct2022.Recursion;

public class LC1306 {

    public static void main(String[] args) {

    }

    public boolean canReach(int[] arr, int start) {
        //base case
        if(start<0 || start>=arr.length) return false;
        if(arr[start]<0) return false;
        if(arr[start]==0) return true;
        //logic
        arr[start] = -arr[start];
        return canReach(arr,start+arr[start]) || canReach(arr,start-arr[start]);

    }
}
