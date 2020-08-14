package LeetCode.BackTracking;/*
 @author Myvin Barboza
 14/08/20 12:33 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC1286IteratorforCombination {

    class CombinationIterator {
        private List<String> combinationsList;
        public CombinationIterator(String characters, int combinationLength) {
            combinationsList=new ArrayList<>();
            StringBuilder sb=new StringBuilder();
            generate(0,characters,combinationsList,combinationLength,sb);
            System.out.println(combinationsList);

        }

        public String next() {
            return combinationsList.remove(0);
        }

        public boolean hasNext() {
            return !combinationsList.isEmpty();
        }

        public void generate(int start,String characters,List<String> combinationsList,int k,StringBuilder sb){
            if(k==0){
                combinationsList.add(sb.toString());
                return;
            }

            for(int i=start;i<characters.length()-k+1;i++){
                sb.append(characters.charAt(i));
                generate(i+1,characters,combinationsList,k-1,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}

