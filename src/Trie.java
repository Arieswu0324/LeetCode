import java.util.LinkedList;
import java.util.List;

class Trie {

    List<Trie> children;
    boolean end;
    char c;

    public Trie(char c) {
        this.c = c;
        this.end = false;
        this.children = new LinkedList<>();
    }

    public Trie() {
        this.c = '0';//root node
        this.end = false;
        this.children = new LinkedList<>();
    }

    public void insert(String word) {
        List<Trie> children = this.children;
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Trie n = null;
            for (Trie node : children) {
                if (node.c == ch[i]) {
                    n = node;//找到
                    break;
                }
            }
            if (n == null) {
                Trie newNode = new Trie(ch[i]);
                if (i == ch.length - 1) {
                    newNode.end = true;
                }
                children.addLast(newNode);
                children = newNode.children;
            } else {
                if (i == ch.length - 1) {
                    n.end = true;
                }
                children = n.children;
            }
        }

    }

    public boolean search(String word) {
        Trie n = findLast(word);

        return n != null && n.end;

    }

    public boolean startsWith(String prefix) {
        return findLast(prefix) != null;

    }

    private Trie findLast(String word) {
        List<Trie> children = this.children;
        char[] ch = word.toCharArray();
        Trie n = null;
        for (char value : ch) {
            n = null;
            for (Trie node : children) {
                if (node.c == value) {
                    n = node;//找到
                    children = n.children;
                    break;
                }
            }

            if (n == null) {
                break;
            }
        }
        return n;
    }


}

