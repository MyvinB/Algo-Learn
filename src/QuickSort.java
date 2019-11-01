import java.util.Arrays;

public class QuickSort {
    static int partiton(int p,int r,int a[]){

        int mid=a[r];

       int temp;
       int j=p;
       for (int i = p; i <r ;i++) {
           if(a[i]<mid){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }

        }
        a[r]=a[j];
        a[j]=mid;

        return j;

        }

        static void sort(int p,int r,int arr[]){

            if(p<r){
                int q=partiton(p,r,arr);
                sort(p,q-1,arr);
                sort(q+1,r,arr);
            }
        }

    public static void main(String[] args) {
       int [] a={1,3,5,7,2,4,6,8};
       sort(0,a.length-1,a);
        System.out.println(Arrays.toString(a));
    }
}
