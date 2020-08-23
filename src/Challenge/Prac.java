package Challenge;/*
 @author Myvin Barboza
 22/08/20 3:33 PM 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prac {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

         for(Iterator<Integer> iterator=list.iterator();iterator.hasNext();){
             Integer number=iterator.next();
             if(number%2==0)iterator.remove();
         }
        System.out.println(list);
    }


}
