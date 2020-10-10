package Challenge;/*
 @author Myvin Barboza
 10/10/20 5:16 PM 
 */

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SG2 {



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class Graph{
        int v;
        LinkedList<Integer> adjList[];

        public Graph(int v){
            this.v=v;
            adjList=new LinkedList[v+1];
            for(int i=0;i<v+1;i++){
                adjList[i]=new LinkedList<>();
            }
        }
        public void addEdge(Graph g,int v,int w){
            g.adjList[v].add(w);
        }
    }
    public static void main(String[] args) {
    FastReader sc=new FastReader();
    int t=sc.nextInt();
    while(t--!=0){
        int n=sc.nextInt();
        Graph graph=new Graph(n);
        for(int i=1;i<n;i++){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            graph.addEdge(graph,src,dest);
        }
        int count[]=new int[n+1];
        for(int i=1;i<count.length;i++){
            countEdge(count, graph.adjList,i,i);
        }
        for (int i = 1; i <count.length ; i++) {
            System.out.print(count[i]+" ");
        }
        System.out.println();


    }

    }

  static void countEdge(int[] count,LinkedList<Integer> adjList[], int v, int index){
        LinkedList<Integer> elements = adjList[index];

        for(int e:elements){
            countEdge(count,adjList,v,e);
            count[v]++;
        }

    }


}
