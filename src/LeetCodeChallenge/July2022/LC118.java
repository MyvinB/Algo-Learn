package LeetCodeChallenge.July2022;

import Challenge.A;

import java.util.ArrayList;
import java.util.List;

public class LC118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            temp = new ArrayList<>();
            if(i==0) temp.add(1);
            else if(i==1) {temp.add(1);temp.add(1);}
            else{
                temp.add(1);
                //-1 cause we are doing j+1 so do not want a null pointer there
                for(int j=0;j<i-1;j++){
                    int f = res.get(i-1).get(j);
                    int s = res.get(i-1).get(j+1);
                    temp.add(f+s);
                }
                temp.add(1);
;            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
