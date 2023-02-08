package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,String::compareTo);
        List<String> list=new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            int j=i;
            while (j + 1 < folder.length && folder[j + 1].startsWith(folder[i]+"/")) {
                j++;
            }
            list.add(folder[i]);
            i=j;
        }
        return list;
    }

    public List<String> removeSubfolders02(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<String>();
        dfs(folder, ans, root);
        return ans;
    }

    public List<String> split(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }
    class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            ref = -1;
            children = new HashMap<String, Trie>();
        }
    }
}


