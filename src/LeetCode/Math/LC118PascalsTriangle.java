package LeetCode.Math;/*
 @author Myvin Barboza
 20/08/20 10:50 AM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            temp.add(0,1);
            for(int j=1;j<temp.size()-1;j++){
                temp.set(j,temp.get(j)+temp.get(j+1));
            }
            res.add(new ArrayList<>(temp));

        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(numRows<=0) return res;
        //for one element
        list.add(1);
        res.add(new ArrayList<>(list));
        if(numRows>=2){
            list.add(1);
            res.add(list);

            for(int i=2;i<numRows;i++){
                list=new ArrayList<>();
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        list.add(1);
                    }else{
                        int a=res.get(i-1).get(j-1);
                        int b=res.get(i-1).get(j);
                        list.add(a+b);
                    }
                }
                res.add(list);
            }

        }
        return res;



    }
}
