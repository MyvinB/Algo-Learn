package LeetCode.Graph;/*
 @author Myvin Barboza
 28/09/20 11:19 AM 
 */

import java.util.*;

public class LC399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> map=buildGraph(equations,values);
        double result[]=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String start=queries.get(i).get(0);
            String end=queries.get(i).get(1);

            result[i]=dfsGetAnswer(start,end,new HashSet<>(),map);
        }
        return result;
    }



    static double dfsGetAnswer(String start,String end, Set<String> visited,HashMap<String, HashMap<String,Double>> map){
        if(!map.containsKey(start)) return -1;

        if(map.get(start).containsKey(end))
            return map.get(start).get(end);

        visited.add(start);

        for(String key:map.get(start).keySet()){
            if(!visited.contains(key)){
                double productWeight=dfsGetAnswer(key,end,visited,map);
                if(productWeight!=-1)
                    return map.get(start).get(key)*productWeight;
            }
        }
        return -1;
    }


    static HashMap<String, HashMap<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String, HashMap<String,Double>> map=new HashMap<>();

        for(int i=0;i<values.length;i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            map.putIfAbsent(a,new HashMap<>());
            map.get(a).put(b,values[i]);
            map.putIfAbsent(b,new HashMap<>());
            map.get(b).put(a,1/values[i]);

        }
        return map;
    }

}
