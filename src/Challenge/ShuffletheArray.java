package Challenge;
/*
 @author Myvin Barboza
 07/06/20 8:12 AM 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuffletheArray {

    static int[] shuffle(int[] a, int n) {
        List<Integer> list=new ArrayList<Integer>();
        int end=n;
        int j=0;
        while(j<end){
            list.add(a[j]);
            list.add(a[n]);
            j++;
            n++;
        }
        int ar[]=new int[a.length];
        for(int i=0;i<list.size();i++)ar[i]=list.get(i);
        return ar;
    }


    public static void main(String[] args) {
   

    }
    }
