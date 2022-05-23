package TopicWise2022.Array;

public class LC1053PreviousPermutationWithOneSwap {

    public static void main(String[] args) {
        int[] t = new int[]{3,1,1,3};
    }

    public static int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i;
        for(i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1])break;
        }
        if(i==-1) return arr;
        for(int j=n-1;j>i;j--){
            System.out.println(i+" "+j);
            //if there are duplicates we need to take the latest one casue we need previous this does not matter in next greatest as we just need next greatter number in dip
            if(arr[i]>arr[j] && arr[j]!=arr[j-1]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                break;
            }
        }
        return arr;
    }
}
