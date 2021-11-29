package practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:27 PM 11/29/2021
 */
public class LCP212 {

    public static void main(String[] args) {

    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,root,i,j,res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, TrieNode p,int i,int j,List<String> res){
        if(i<0 || j<0 || i>= board.length || j>=board[0].length) return;
        char c = board[i][j];
        if(c=='*' || p.next[c-'a']==null) return;
        p = p.next[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word =null;
        }
        board[i][j] = '*';
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d:dir){
            dfs(board,p,i+d[0],j+d[1],res);
        }
        board[i][j] = c;
    }
    public TrieNode buildTrie(String[] ar){
        TrieNode root = new TrieNode();
        for(String s:ar){
            TrieNode p = root;
            for(char ch:s.toCharArray()){
                int i = ch -'a';
                if(p.next[i]==null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
