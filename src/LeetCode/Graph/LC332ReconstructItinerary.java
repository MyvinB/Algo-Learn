package LeetCode.Graph;/*
 @author Myvin Barboza
 29/06/20 2:55 PM 
 */

import Challenge.A;

import java.util.*;

public class LC332ReconstructItinerary {




    static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res=new LinkedList<>();
        createGraph(map,tickets);
        System.out.println(map);
        dfs(res,map,"JFK");
        return res;

    }


    static void dfs(LinkedList<String> res,Map<String, PriorityQueue<String>> map,
                    String from){
        PriorityQueue<String> arrivals=map.get(from);
        //dfs will back track and add all the elements one by one
        while(arrivals!=null && !arrivals.isEmpty()){
            String to=arrivals.poll();
            dfs(res,map,to);
        }

        res.addFirst(from);

    }

    static void createGraph(Map<String,PriorityQueue<String>> map,List<List<String>> tickets){
        for(List<String> ticket :tickets){
            String from=ticket.get(0); String to=ticket.get(1);
            if(!map.containsKey(from)){
                map.put(from,new PriorityQueue<>());
            }
            map.get(from).offer(to);
        }
    }




    public static void main(String[] args) {
    List<List<String>> tickets=new ArrayList<>();
    String[][] s={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    for(String se[] :s){
        List<String> list=new ArrayList<>();
        list.add(se[0]);
        list.add(se[1]);
        tickets.add(new ArrayList<>(list));
    }
        System.out.println(tickets);
        System.out.println(findItinerary(tickets));

    }


}
