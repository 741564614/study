package leetcode.leetcode202303;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1032 {
    class StreamChecker {
        ArrayList<Character> list;
        Trie root;

        public StreamChecker(String[] words) {
            root = new Trie(' ');
            list = new ArrayList<>();
            for (String word : words) {
                root.add(word);
            }
        }

        public boolean query(char letter) {
            list.add(letter);
            return root.query(list);
        }
    }

    class Trie {
        Trie[] node;
        boolean isEnd = false;
        char value;

        public Trie(char value) {
            this.value = value;
            this.node = new Trie[26];
        }

        public void add(String word) {
            Trie root = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char a = word.charAt(i);
                int next = a - 'a';
                if (root.node[next] == null) {
                    root.node[next] = new Trie(a);
                }
                root = root.node[next];
                if (i == 0) {
                    root.isEnd = true;
                }
            }
        }

        public boolean query(ArrayList<Character> list) {
            Trie root = this;
            for (int i = list.size() - 1; i >= 0; i--) {
                char a = list.get(i);
                int next = a - 'a';
                if (root.node[next] == null) {
                    return false;
                }
                root = root.node[next];
                if (root.isEnd) {
                    return true;
                }
            }
            return false;
        }
    }


    class StreamChecker02 {
        TrieNode root;
        TrieNode temp;

        public StreamChecker02(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (cur.getChild(index) == null) {
                        cur.setChild(index, new TrieNode());
                    }
                    cur = cur.getChild(index);
                }
                cur.setIsEnd(true);
            }
            root.setFail(root);
            Queue<TrieNode> q = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if(root.getChild(i) != null) {
                    root.getChild(i).setFail(root);
                    q.add(root.getChild(i));
                } else {
                    root.setChild(i, root);
                }
            }
            while (!q.isEmpty()) {
                TrieNode node = q.poll();
                node.setIsEnd(node.getIsEnd() || node.getFail().getIsEnd());
                for (int i = 0; i < 26; i++) {
                    if(node.getChild(i) != null) {
                        node.getChild(i).setFail(node.getFail().getChild(i));
                        q.offer(node.getChild(i));
                    } else {
                        node.setChild(i, node.getFail().getChild(i));
                    }
                }
            }

            temp = root;
        }

        public boolean query(char letter) {
            temp = temp.getChild(letter - 'a');
            return temp.getIsEnd();
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode fail;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode getChild(int index) {
            return children[index];
        }

        public void setChild(int index, TrieNode node) {
            children[index] = node;
        }

        public boolean getIsEnd() {
            return isEnd;
        }

        public void setIsEnd(boolean b) {
            isEnd = b;
        }

        public TrieNode getFail() {
            return fail;
        }

        public void setFail(TrieNode node) {
            fail = node;
        }
    }
}
