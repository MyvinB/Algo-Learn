package LeetCodeChallenge.Nov2022.Daily;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC212 {

    public static void main(String[] args) {

    }

    class TrieNode{
        TrieNode next[] = new TrieNode[26];
        String word;

    }

    public TrieNode buildTreeNode(String[] words){
        TrieNode root = new TrieNode();
        for(String w:words){
            TrieNode p = root;
            for(char ch:w.toCharArray()){
                int t = ch-'a';
                if(p.next[t]==null){
                    p.next[t] = new TrieNode();
                }
                p = p.next[t];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTreeNode(words);
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,res,root);
            }
        }
        return res;
    }

    public void dfs(char[][] board,int i, int j,List<String> res,TrieNode p) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]=='^') return;
        char ch = board[i][j];
        if(p.next[ch-'a']==null) return;
        p = p.next[ch-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word = null; 
            //if we null a word we do not return think of oat and then oath now since we used oat once we null oat
            //we still need to reach to h in the path
        }
        board[i][j] = '^';
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d:dir){
            dfs(board,i+d[0],j+d[1],res,p);
        }
        board[i][j] = ch;
    }
}
