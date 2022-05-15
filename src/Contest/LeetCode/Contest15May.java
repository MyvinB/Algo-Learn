package Contest.LeetCode;

import java.util.*;

public class Contest15May {

    public static void main(String[] args) {
//        String[] words = new String[]{"a","b","c","d","e"};
//        System.out.println(removeAnagrams(words));
        System.out.println(maxConsecutive(10,30,new int[]{19,10,15}));
    }


    public static List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        res.add(words[0]);
        for(int i=1;i<n;i++){
            if(!checkAna(res.get(res.size()-1),words[i])){
                res.add(words[i]);
            }
        }
        return res;
    }

    private static boolean checkAna(String s,String p){
        int[] ch = new int[26];
        for(int i=0;i<s.length();i++) ch[s.charAt(i)-'a']++;
        for(int j=0;j<p.length();j++) ch[p.charAt(j)-'a']--;
        for(int i=0;i<26;i++){
            if(ch[i]!=0) return false;
        }
        return true;
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
//        Set<Integer> set = new HashSet<>();
//        for(int i:special) set.add(i);
//        int max = 0;
//        int count = 0;
//        for(int i=bottom;i<=top+1;i++){
//            if(set.contains(i) || i==top+1){
//                max =Math.max(count,max);
//                count = 0;
//            }
//            else count++;
//        }
//        return max;
        Arrays.sort(special);
       int count = 0;
       count = Math.max(count,special[0] - bottom);
       bottom = special[0];
       for(int i=1;i<special.length;i++){
           count = Math.max(special[i]-bottom-1,count);
           bottom = special[i];

       }
       count = Math.max(count,top-bottom);
       return count;
    }


    class CountIntervals {
       List<int[]> intervals;
        public CountIntervals() {
            intervals = new ArrayList<>();
        }

        public void add(int left, int right) {
            intervals.add(new int[]{left,right});
        }

        public int count() {
            mergeIntervals();
            int total = 0;
            for(int i=0;i<intervals.size();i++){
                int t[] = intervals.get(i);
                total += (t[1]-t[0]+1);
            }
            return total;
        }

        private void mergeIntervals(){
            Collections.sort(intervals,(a,b)->a[0]-b[0]);
            List<int[]> list =new ArrayList<>();
            int[] current_interval=intervals.get(0);
            list.add(current_interval);
            for(int[] interval:intervals){

                int current_end=current_interval[1];
                int next_begin=interval[0];
                int next_end=interval[1];
                if(current_end>=next_begin){
                    current_interval[1]=Math.max(current_end,next_end);
                }
                else {
                    current_interval=interval;
                    list.add(current_interval);
                }

            }
            intervals = list;
        }
    }

}
