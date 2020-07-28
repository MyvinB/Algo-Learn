package LeetCode.Array;/*
 @author Myvin Barboza
 28/07/20 4:13 PM 
 */

public class LC621TaskScheduler {

    static int leastInterval(char[] tasks, int n) {
       int counter[]=new int[26];
       int max=0;
       int maxCount=0;
       for(char ch:tasks){
           counter[ch-'A']++;
           if(max==counter[ch-'A']){
               maxCount++;
           }else if(max<counter[ch-'A']){
               max=counter[ch-'A'];
               maxCount=1;
           }
       }
      //  int total=(n+1)*(max-1)+maxCount;   return total>tasks.length?total:tasks.length;
       int partCount=max-1;
       int partLength=n-(maxCount-1);
       int empty=partCount*partLength;
       int availableTask= tasks.length-max*maxCount;
       int idle=Math.max(0,empty-availableTask);

       return tasks.length+idle;
    }

    public static void main(String[] args) {
        char ch[]={'A','A','A','B','B','B'};
        System.out.println(leastInterval(ch,0));
    }

}
