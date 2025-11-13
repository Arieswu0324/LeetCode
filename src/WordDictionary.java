class WordDictionary {

    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (cur.children[index] == null) {
                cur.children[index] = new WordDictionary();
            }

            cur = cur.children[index];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        return backTracking(0, word, this);
    }

    private boolean backTracking(int start, String word, WordDictionary node) {
        if (start == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(start);
        if (c != '.') {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            return backTracking( + 1, word, node.children[index]);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (backTracking(start + 1, word, node.children[i])) {
                        return true;
                    }
                }
            }

        }

        return false;
    }
}
