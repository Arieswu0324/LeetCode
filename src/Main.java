import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }


    public static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        int flag = 1;

        char[] chars = s.toCharArray();
        int startIndex = 0;
        int endIndex = numRows - 1;

        int i = startIndex;

        for (char c : chars) {
            list.get(i).add(c);
            if (i == endIndex) {
                flag = -1;
            } else if (i == startIndex) {
                flag = 1;
            }

            i += flag;
        }

        return list.stream().flatMap(List::stream).map(String::valueOf).collect(Collectors.joining());
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] splts = s.split(" ");
        List<String> words = new ArrayList<>();
        for (String str : splts) {
            str = str.trim();
            if (!str.isBlank()) {
                words.add(str);
            }
        }
        return String.join(" ", words.reversed());
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //node -> copy
        Map<Node, Node> copyMap = new HashMap<>();


        Node cur = head;
        Node copyHead = new Node(cur.val);
        copyMap.put(head, copyHead);
        Node copyCur = copyHead;

        //先复制链表
        while (cur.next!= null) {
            cur = cur.next;
            Node curNode = new Node(cur.val);
            copyMap.put(cur, curNode);
            copyCur.next = curNode;
            copyCur = copyCur.next;
        }

        //再复制随机指针
        cur = head;
        copyCur = copyHead;
        while (cur!= null) {
            Node random =cur.random;
            if(random==null){
                copyCur.random=null;
            }else {
                Node copyNode = copyMap.get(random);
                copyCur.random = copyNode;
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return copyHead;
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
