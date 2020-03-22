package TestHackerEarth;

import java.util.HashMap;

/*
 @author Myvin Barboza
 21/03/20 5:50 PM 
 */public class Similar {

     static int checkSimilar(String s,String t){
         HashMap<Character,Integer> map=new HashMap<>();
         for (int i = 0; i <t.length() ; i++) {
         char ch=s.charAt(i);
          if(map.containsKey(ch)){
              map.put(ch,map.get(ch)+1);
          }
          else map.put(ch,1);
         }
         System.out.println(map);
         int count=0;
         for (int i = 0; i <t.length() ; i++) {
             char ch=t.charAt(i);
             if(map.containsKey(ch) && map.get(ch)>0){
                 count++;
                 map.put(ch,map.get(ch)-1);
             }
         }
         System.out.println(map);
         return count;
     }

    public static void main(String[] args) {
        System.out.println(checkSimilar("bdacdaba","ababd"));
    }
}