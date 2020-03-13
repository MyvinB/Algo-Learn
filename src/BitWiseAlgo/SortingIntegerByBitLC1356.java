package BitWiseAlgo;/*
 @author Myvin Barboza
 3/13/2020 10:51 AM
 */



import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SortingIntegerByBitLC1356 {

    static int[] sortByBits(int[] arr) {
        Integer a[] = new Integer[arr.length];
        for (int i = 0; i <arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bitA = Integer.bitCount(a);
                int bitB = Integer.bitCount(b);
                if (bitA == bitB) {
                    return a - b;
                }
                return bitA - bitB;
            }
        });

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(a[i]);
            arr[i]=a[i];
        }
        return arr;
    }

    static int[] sortByLamBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b));
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }




    public static void main(String[] args) {
    int a[]={0,1,2,3,4,5,6,7,8};
    a=sortByBits(a);
    Arrays.toString(a);
    }
}
