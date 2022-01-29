package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 4:10 PM 1/29/2022
 */
public class LC211 {
    public static void main(String[] args) {
    WordDictionary a = new WordDictionary();


        a.addWord("a");
        a.addWord("a");
//        System.out.println(a.search("."));
//        System.out.println(a.search("a"));
//        System.out.println(a.search("aa"));
//        System.out.println(a.search("a"));
        System.out.println(a.search(".a"));

//
////        System.out.println(a.search("sa."));
////        System.out.println(a.search(".ad"));
//////        System.out.println(a.search("ba"));
//////        System.out.println(a.search("s.d"));
////        System.out.println(a.search("b.."));
////        System.out.println(a.search("pad"));
//        System.out.println(a.search("."));
//        System.out.println(a.search(".a"));
//        System.out.println(a.search("a."));
//        System.out.println(a.search("aa"));
//        System.out.println(a.search("a"));

    }



    static class WordDictionary {

        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
        }
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String s) {
            TrieNode curNode = root;
            for(int i=0;i<s.length();i++){
                if(curNode.children[s.charAt(i)-'a']==null){
                    curNode.children[s.charAt(i)-'a'] = new TrieNode();
                }
                curNode = curNode.children[s.charAt(i)-'a'];
            }
            curNode.isWord = true;
        }

        public boolean search(String s) {
           return search(s,root);
        }

        private boolean search(String s,TrieNode curNode){
            for(int i=0;i<s.length();){
                char ch = s.charAt(i);
                if(ch=='.'){
                    for(int j=0;j< curNode.children.length;j++){
                        if(curNode.children[j]!=null && search(s.substring(i+1),curNode.children[j])){
                            return true;
                        }
                    }
                    //if the whole search is over for . and there is nothi
                    return false;
                }
                else if(curNode.children[ch-'a']!=null){
                    curNode = curNode.children[ch-'a'];
                    i++;
                } else return false;

            }
            return  curNode.isWord;
        }
    }
}
