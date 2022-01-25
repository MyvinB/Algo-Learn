package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 10:53 AM 1/25/2022
 */
public class LC941 {

    public static void main(String[] args) {
        int test[] = new int[]{3,7,6,4,3,0,1,0};
        System.out.println(validMountainArray(test));
    }


    public static boolean validMountainArray(int[] arr) {
        int i=0;
       for(i=0;i<arr.length-1;i++){
           if(arr[i]>=arr[i+1]){
               break;
           }
       }
       if(i==0 ||i==arr.length-1) return false;
       for(int j=arr.length-1;j>i;){
           if(arr[j]<arr[j-1]){
               j--;
           }else return false;
       }
       return true;
    }

    public static boolean validMountainArray1(int[] arr){
        //Same concept just missed the different loops
        int n= arr.length;
        int i=0;int j=n-1;
        while(i+1<n && arr[i]<arr[i+1])i++;
        while(j>0 && arr[j-1]>arr[j])j--;
        return i>0 && i==j && j<n-1;
    }
}
