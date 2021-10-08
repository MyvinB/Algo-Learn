package practise;

public class LC208 {
    public static void main(String[] args) {
         // return True
    }

    class  Trie {
        TrieNode root;

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            char ch;
            boolean endNode;
        }


        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children[ch - 'a'];
                if (node == null) {
                    node = new TrieNode();
                    node.ch = ch;
                    current.children[ch - 'a'] = node;
                }
                current = node;
            }
            current.endNode = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children[ch - 'a'];
                if (node != null) {
                    current = node;
                } else return false;
            }
            return current.endNode;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TrieNode node = current.children[ch - 'a'];
                if (node != null) {
                    current = node;
                } else return false;
            }
            return true;
        }

    }
}