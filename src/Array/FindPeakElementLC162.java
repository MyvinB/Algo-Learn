package Array;

/*
 @author Myvin Barboza
 23/04/20 5:46 PM 
 */public class FindPeakElementLC162 {

// 65 78 75 73 84 65
    static int findPeakElement(int[] A) {
        if(A.length==1) return 0;
        int n=A.length/2;
        int index=0;
        if(A[n]>A[n-1]){
            int max=A[n];
            index=n;
            for (int i = n+1; i <A.length ; i++) {
                if(A[i]>max) { index=i;max=A[i];}
            }
        }
        else{
            int max=A[n];
            index=n;
            for (int i = A.length-1; i >=0 ; i--) {
                if(A[i]>max){max=A[i]; index=i;}
            }
        }
        return index;
    }


    public static void main(String[] args) {
        //[1,2,1,3,5,6,4]
        int num[]={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(num));
    }
}