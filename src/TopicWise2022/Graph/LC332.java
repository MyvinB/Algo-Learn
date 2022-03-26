package TopicWise2022.Graph;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 4:25 PM 3/26/2022
 * Time Taken:
 */
public class LC332 {
    public static void main(String[] args) {

    }


    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        for(List<String> s:tickets){
            String from = s.get(0);
            String to = s.get(1);
            adjList.computeIfAbsent(from,a->new PriorityQueue<String>()).add(to);
        }
        LinkedList<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            while(adjList.containsKey(stack.peek()) && adjList.get(stack.peek()).size()!=0){
                stack.push(adjList.get(stack.peek()).poll());
            }
            route.addFirst(stack.pop());
        }
        return route;
    }
}
