package Array;///https://www.youtube.com/watch?v=J9ikRMK8Yhs
import java.util.HashMap;

public class MinSwapToSortAnArray {
    static int minswap(int a[]){
        int swapcount=0;
        boolean visited[]=new boolean[a.length+1];
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=1;i<visited.length;i++){
            map.put(i,a[i-1]);
        }
        for(int i=1;i<map.size();i++){
            if(!visited[i]){
                visited[i]=true;
                if(i!=map.get(i)){
                    int c=map.get(i);
                    while(!visited[c]){
                        visited[c]=true;
                        c=map.get(c);
                        ++swapcount;
                    }
                }
            }
        }
        return swapcount;
    }
    public static void main(String[] args) {
        int a[]={1,4,5,2,3};
        System.out.println(minswap(a));
    }
}
