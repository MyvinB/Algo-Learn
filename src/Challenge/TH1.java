package Challenge;/*
 @author Myvin Barboza
 01/08/20 1:41 PM 
 */

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TH1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String ch[]=br.readLine().split("");
        String ar[]=br.readLine().split("");
        int num[][]=new int[10][3];
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(ar[i]);
            String cha=ch[i];
            if(cha.equals("R"))num[val][0]++;
            if(cha.equals("B"))num[val][1]++;
            if(cha.equals("G"))num[val][2]++;
        }
        System.out.println(Arrays.deepToString(num));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            String cha=ch[i];
            int val=-1;
            if(cha.equals("R"))val=0;
            if(cha.equals("B"))val=1;
            if(cha.equals("G"))val=2;
            for(int j=9;j>=0;j--){
                if(num[j][val]!=0){
                    num[j][val]--;
                    sb.append(j);
                    break;
                }
            }
        }
        System.out.println(sb.toString());

//        for(int i=0;i<n;i++){
//            if(ch[i].equals("R"))red++;
//            else if(ch[i].equals("G"))green++;
//            else blue++;
//        }
//        int rArr[]=new int[red+1];
//        int gArr[]=new int[green+1];
//        int bArr[]=new int[blue+1];
//        int r=0,g=0,b=0;
//        for(int i=0;i<n;i++){
//            if(ch[i].equals("R")){
//                if(rArr[r]<ar[i]){
//                    rArr[r+1]=rArr[r];
//                    rArr[r]=ar[i];
//                }
//            }
//            if(ch[i].equals("B")){
//                if(bArr[b]<ar[i]){
//                    rArr[r+1]=rArr[r];
//                    rArr[r]=ar[i];
//                }
//            }
//        }

//        HashMap<String,PriorityQueue<Integer>> map=new HashMap<>();
//        for(int i=0;i<n;i++){
//            ar[i]=Integer.parseInt(br.readLine());
//            if(ch[i].equals("R") && red>=2 || ch[i].equals("G") && green>=2 || ch[i].equals("B") && blue>=2){
//               PriorityQueue<Integer> pqTemp=map.getOrDefault(ch[i],new PriorityQueue<>((a,b)->(b-a)));
//               pqTemp.offer(ar[i]);
//                map.put(ch[i],pqTemp);
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<n;i++){
//            if(map.containsKey(ch[i])){
//                PriorityQueue temp=map.get(ch[i]);
//                sb.append(temp.poll());
//                map.put(ch[i],temp);
//            }else sb.append(ar[i]);
//        }
      //  System.out.println(sb.toString());



    }




}
