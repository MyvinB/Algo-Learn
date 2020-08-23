package LeetCode.Trie;/*
 @author Myvin Barboza
 23/08/20 6:39 PM 
 */

public class LC1032StreamOfCharacters {
    class TrieNode{
        char val;
        TrieNode[] children=new TrieNode[26];
        boolean isWord;

        TrieNode(){

        }

        TrieNode(char val){
            this.val=val;
        }
    }

    TrieNode root;
    StringBuilder sb;

    public LC1032StreamOfCharacters(String[] words) {
        root=new TrieNode(' ');
        sb=new StringBuilder();
        for(String word:words){
            TrieNode node=root;
            for(int i=word.length()-1;i>=0;i--){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new TrieNode(ch);
                }
                node=node.children[ch-'a'];
            }
            node.isWord=true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node=root;
        for(int i=sb.length()-1;i>=0 && node!=null;i--){
            char ch=sb.charAt(i);
            node=node.children[ch-'a'];
            if(node!=null && node.isWord){
                return true;
            }
        }
        return false;
    }



}
