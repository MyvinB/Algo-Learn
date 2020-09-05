package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class LC763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list=new ArrayList<>();
        int map[]=new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']=i;
        }
        int start=0;
        int last=0;
        for(int i=0;i<S.length();i++){
            last=Math.max(last,map[S.charAt(i)-'a']);
            if(last==i){
                list.add(last-start+1);
                start=last+1;
            }
        }
        return list;
    }
}
