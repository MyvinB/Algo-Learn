package practise;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a ={1,4,3,2};
        int temp;
        System.out.println(a.length);
        for(int i=0;i<(a.length/2);i++){
            temp=a[i];
            a[i]=a[a.length-i-1];
            a[a.length-1-i]=temp;

        }
        System.out.println(Arrays.toString(a));
    }
}
