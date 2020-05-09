//https://www.youtube.com/watch?v=TIbUeeksXcI
package LeetCode.Graph;/*
 @author Myvin Barboza
 3/3/2020 2:03 PM
 */


import java.util.*;


public class PrintingGraph {

    static HashMap<Character, LinkedList<Character>> map = new HashMap<>();


    static void dfsprint(Character A) {
        Stack<Character> stack = new Stack<Character>();
        Set<Character> set = new HashSet<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            Character cur = stack.pop();
            //printing
            if (!set.contains(cur)) {
                set.add(cur);
                System.out.print(cur);
            }
            //
            for (Character a : map.get(cur)) {
                if (!set.contains(a))
                    stack.push(a);
            }
        }


    }

    static void bfsprint(Character A) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            if (!set.contains(cur)) {
                set.add(cur);
                System.out.print(cur);
            }

            for (Character ch : map.get(cur)) {
                if (!set.contains(ch)) {
                    queue.add(ch);
                }
            }
        }
    }


    static void addEdge(Character source, Character des) {
        if (!map.containsKey(source)) {
            LinkedList<Character> linkedList = new LinkedList<>();
            linkedList.add(des);
            map.put(source, linkedList);

        } else {
            LinkedList linkedList = map.get(source);
            linkedList.add(des);
            map.put(source, linkedList);
        }
    }

    public static void main(String[] args) {
        addEdge('A', 'B');
        addEdge('A', 'C');
        addEdge('A', 'D');
        addEdge('A', 'E');
        addEdge('B', 'G');
        addEdge('B', 'C');
        addEdge('B', 'A');
        addEdge('C', 'A');
        addEdge('C', 'D');
        addEdge('C', 'B');
        addEdge('D', 'C');
        addEdge('D', 'A');
        addEdge('D', 'E');
        addEdge('D', 'H');
        addEdge('E', 'D');
        addEdge('E', 'A');
        addEdge('E', 'F');
        addEdge('F', 'E');
        addEdge('F', 'H');
        addEdge('F', 'G');
        addEdge('G', 'F');
        addEdge('G', 'B');
        addEdge('H', 'F');
        addEdge('H', 'D');

        dfsprint('A');
        System.out.println();
        bfsprint('A');

    }

}
