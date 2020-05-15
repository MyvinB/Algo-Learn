package LeetCode.Trie;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;

/*
 @author Myvin Barboza
 14/05/20 12:34 PM 
 */
public class Trie {

    TrieNode root;
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        char ch;
        boolean endNode;
    }

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current=root;
        for (int i = 0; i <word.length() ; i++) {
            char ch=word.charAt(i);
            TrieNode node=current.children[ch-'a'];
            if(node==null){
                node=new TrieNode();
                node.ch=ch;
                current.children[ch-'a']=node;
            }
            current=node;
        }
        current.endNode=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current=root;
        for (int i = 0; i <word.length() ; i++) {
            char ch=word.charAt(i);
            TrieNode node=current.children[ch-'a'];
            if(node!=null){
                current=node;
            }
            else return false;

        }
        return current.endNode;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for (int i = 0; i <prefix.length() ; i++) {
            char ch=prefix.charAt(i);
            TrieNode node=current.children[ch-'a'];
            if(node!=null){
                current=node;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //[null,null,null,null,null,null,null,false,true,true,false,false,false,false,true,true,false,true,true,false,false,true,true,true,true]
        //[null,null,null,null,null,null,null,false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
        //["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
        //[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println( trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true


    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */