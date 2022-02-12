package LeetCodeChallenge.Feb2022.practise;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 6:38 PM 2/12/2022
 * Time Taken:
 */
public class LC126 {

    public static void main(String[] args) {

        //"hit"
        //"cog"
        //["hot","dot","dog","lot","log","cog"]
        List<String> res = Arrays.asList("hot","dot","dog","lot","log");
        findLadders("hit","cog",res);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> visited = new HashMap<>();
        HashMap<String,List<String>> adjList = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.put(beginWord,0);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.poll();
                for(int j=0;j<word.length();j++){
                    for (int k= 'a';k<='z';k++){
                        char[] wordAr = word.toCharArray();
                        wordAr[j] = (char)k;
                        String temp = new String(wordAr);
                        if(set.contains(temp) && visited.get(temp)==null ){
                            //+1 for child node
                            visited.put(temp,level+1);
                            List<String> tempList = adjList.getOrDefault(word,new ArrayList<>());
                            tempList.add(temp);
                            adjList.put(word,tempList);
                            queue.add(temp);
                        }else if(set.contains(temp) && visited.get(word)+1==visited.get(temp)){
                            List<String> tempList = adjList.getOrDefault(word,new ArrayList<>());
                            tempList.add(temp);
                            adjList.put(word,tempList);
                        }
                    }
                }

            }
            level++;
        }
        //Adjency list formed only on parent to child relationship
        System.out.println(adjList);
        List<List<String>> res = new ArrayList<>();
        dfsToGetList(beginWord,endWord,adjList,new ArrayList<>(),res);
        System.out.println(res);
        return res;
    }

    public static void dfsToGetList(String beginWord,String endWord,HashMap<String,List<String>> adjList,List<String> temp,List<List<String>> res){
        temp.add(beginWord);
        if(beginWord.equals(endWord)){
            res.add(new ArrayList<>(temp));
            temp.remove(beginWord);
            return;
        }
        //if case to avoid null pointer in a loop
        if(adjList.get(beginWord)!=null){
            for(String l : adjList.get(beginWord)){
                dfsToGetList(l,endWord,adjList,temp,res);
            }
        }

        temp.remove(temp.size()-1);
    }
}
