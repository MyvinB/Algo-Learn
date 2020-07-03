package LeetCode.Array;/*
 @author Myvin Barboza
 03/07/20 3:51 PM 
 */

import java.util.Arrays;
import java.util.HashMap;

public class LC957PrisonCellsAfterNDays {

    static int[] prisonAfterNDays(int[] cells, int N) {

        HashMap<String,Integer> map=new HashMap<>();

       while(N>0){
           int temp[]=new int[8];
           map.put(Arrays.toString(cells),N--);
           for(int i=1;i<7;i++){
               if(cells[i-1]==cells[i+1]){
                   temp[i]=1;
               }else temp[i]=0;
           }

           cells=temp;
           if(map.containsKey(Arrays.toString(cells))){
               N=N%map.get(Arrays.toString(cells))-N;
           }
       }


            // System.out.println(Arrays.toString(cells));


        return cells;
    }


    static int[] prisonAfterNDaysMOD(int[] cells, int N) {
        N=N%14==0?14:N%14;
        System.out.println(N);
        for(int j=0;j<N;j++){
            int temp[]=new int[8];
            for(int i=1;i<7;i++){
                if(cells[i-1]==cells[i+1]){
                    temp[i]=1;
                }else temp[i]=0;
            }

            cells=temp;
           // System.out.println(Arrays.toString(cells));
        }

        return cells;
    }

    public static void main(String[] args) {


        int cells[]={0,1,0,1,1,0,0,1};
        System.out.println(prisonAfterNDays(cells,788566492));
    }



}
