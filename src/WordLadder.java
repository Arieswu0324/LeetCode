import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {
    //从beginWord开始，对每个位置变化26个字母，查询是否存在在wordList中
    //存在时，保存到当前word的路径->Map<K,V>,同时保证word被访问过不再访问
    //广度优先搜索，直到队列为空，则搜索完毕。如果在搜索过程中newWord==endWord，此时返回的为最短路径
    //没找到则返回0

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Map<String, Integer> visited = new HashMap<>();
        List<String> queue = new ArrayList<>();

        queue.addLast(beginWord);
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.removeFirst();

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String newWord = changeWord(word, i, (char) (j + 'a'));
                    if (dict.contains(newWord) && !visited.containsKey(newWord)) {
                        if (newWord.equals(endWord)) {
                            return visited.get(word) + 1;
                        }

                        visited.put(newWord, visited.get(word) + 1);
                        queue.addLast(newWord);
                    }
                }
            }


        }
        return 0;

    }

    private String changeWord(String word, int index, char c) {
       StringBuilder builder = new StringBuilder(word);
        builder.setCharAt(index, c);
        return builder.toString();
    }

    public static void main(String[] args) {
        WordLadder instance = new WordLadder();

        System.out.println(instance.changeWord("dog",0,'c'));
    }

}
