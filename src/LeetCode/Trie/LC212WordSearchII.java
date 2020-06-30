package LeetCode.Trie;/*
 @author Myvin Barboza
 30/06/20 4:41 PM 
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LC212WordSearchII {


    static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

   static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        //border conditions
        if(i<0 ||j<0 || i>=board.length || j>=board[0].length) return;
        char c=board[i][j];
        if(c=='#' ||p.next[c-'a']==null) return;
       p=p.next[c-'a'];
        //adding to result
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
            return;
        }

        board[i][j]='#';
        dfs(board,i+1,j,p,res);
        dfs(board,i-1,j,p,res);
        dfs(board,i,j+1,p,res);
        dfs(board,i,j-1,p,res);
        board[i][j]=c;
    }

    static TrieNode buildTrie(String[] words) {
            TrieNode root=new TrieNode();
            for (String word:words){
                TrieNode p=root;
                for(char c:word.toCharArray()){
                    int index=c-'a';
                    if(p.next[index]==null) p.next[index]=new TrieNode();
                    p=p.next[index];
                }
                p.word=word;
            }
            return root;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        char a[][] = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};
        System.out.println(findWords(a,words));

    }

}
