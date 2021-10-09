package practise;

import java.util.ArrayList;
import java.util.List;

public class LC212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                dfs(board,0,0,root,res);
            }
        }
        return res;
    }

    public void dfs(char[][] board,int i, int j,TrieNode p , List<String> res){
        if(i<0 || j<0 || i >board.length || j> board[0].length ) return;
        char c = board[i][j];
        if(c == '#' ||p.next[c-'a'] == null) return ;
        if(p.word !=null){
            res.add(p.word);
        }
        board[i][j] = '#';
        dfs(board,i+1,j,p,res);
        dfs(board,i-1,j,p,res);
        dfs(board,i,j+1,p,res);
        dfs(board,i,j-1,p,res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String word[]) {
        TrieNode root = new TrieNode();
        for (String w : word) {
            TrieNode p = root;
            for (char ch : w.toCharArray()) {
                int index = ch - 'a';
                if (p.next[index] == null)
                    p.next[index] = new TrieNode();
                p = p.next[index];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
