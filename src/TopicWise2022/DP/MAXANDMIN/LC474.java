package TopicWise2022.DP.MAXANDMIN;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:03 AM 4/7/2022
 * Time Taken:
 */
public class LC474 {

    public static void main(String[] args) {
        String[] sAr = new String[]{"10","0001","111001","1","0"};
        System.out.println(findMaxForm(sAr,5,3));
    }
//Trying Recursion
    public static int findMaxForm(String[] strs, int m, int n) {
        List<int[]> list = new ArrayList<>();
        for(String s:strs){
            int one=0;
            int zero=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') zero++;
                else one++;
            }
            list.add(new int[]{zero,one});
        }
        return dfs(list,0,m,n);

    }

    public static int dfs(List<int[]> countList,int index,int nZero,int nOne){
        //Base condition
        //1) If nZeros is equal to zero or nOne or countList end
        if(index == countList.size() || nZero == 0 && nOne == 0) return 0;
        int[] countAr = countList.get(index);
        //If we do not have the required zeros or ones we skip that element
        if(nZero<countAr[0] || nOne<countAr[1]){
            return dfs(countList,index+1,nZero,nOne);
        }

        int include = 1 + dfs(countList,index+1,nZero-countAr[0],nOne-countAr[1]);
        int exclude = dfs(countList,index+1,nZero,nOne);

        return Math.max(include,exclude);
    }
}
