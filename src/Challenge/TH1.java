package Challenge;/*
 @author Myvin Barboza
 01/08/20 1:41 PM 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TH1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int ar[]=new int[n];
        String ch[]=br.readLine().split("");
        int red=0,blue=0,green=0;

        for(int i=0;i<n;i++){
            if(ch[i].equals("R"))red++;
            else if(ch[i].equals("G"))green++;
            else blue++;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        HashMap<String,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(br.readLine());
            if(ch[i].equals("R") && red>=2 || ch[i].equals("G") && green>=2 || ch[i].equals("B") && blue>=2){
               PriorityQueue<Integer> pqTemp=map.getOrDefault(ch[i],pq);
               pqTemp.offer(ar[i]);
                map.put(ch[i],pqTemp);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(map.containsKey(ch[i])){
                pq=map.get(ch[i]);
                sb.append(pq.poll());
                map.put(ch[i],pq);
            }else sb.append(ar[i]);
        }
        System.out.println(sb.toString());



    }




}
