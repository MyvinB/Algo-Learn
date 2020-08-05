package LeetCode.Trie;/*
 @author Myvin Barboza
 05/08/20 4:06 PM 
 */

import java.util.LinkedList;
import java.util.Queue;

public class LC211AddAndSearchWordDatastructuredesign {


    /*
    * A MORE SIMPLE approach WOULD BE TO S
    * store the len of the character in a hashmap and then have a list for the words with that size accordingly if list found compare the word with the word you have
    * you have to wrtie a sperate compare function taking into account that you have . that is considered similar
    * */
    class TrieNode{
        TrieNode children[]=new TrieNode[26];
        boolean isWord;
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public LC211AddAndSearchWordDatastructuredesign() {
        root=new TrieNode();

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if( node.children[word.charAt(i)-'a']==null){
                node.children[word.charAt(i)-'a']=new TrieNode();
            }
            node=node.children[word.charAt(i)-'a'];
        }
        node.isWord=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node=root;
        return partSearch(word,root);
    }

    public boolean partSearch(String word,TrieNode node){

        boolean res=false;
        for(int i=0;i<word.length();){
            if(word.charAt(i)=='.'){
                for(int j=0;j<node.children.length;j++){
                    if(node.children[j]!=null){
                        res=partSearch(word.substring(i+1),node.children[j]);
                        if(res) return true;
                    }
                }
                return false;

            }
            else if(node.children[word.charAt(i)-'a']!=null){
                node=node.children[word.charAt(i)-'a'];
                i++;
            }
            else return false;

        }
        return node.isWord;
    }



    public static void main(String[] args) {
        LC211AddAndSearchWordDatastructuredesign a=new LC211AddAndSearchWordDatastructuredesign();
       System.out.println(a.search(".at"));
        a.addWord("at");
        a.addWord("and");
        a.addWord("an");
        a.addWord("add");
        a.addWord("a");
        System.out.println(a.search(".at"));
        a.addWord("bat");
        System.out.println(a.search(".a."));
    }

}
