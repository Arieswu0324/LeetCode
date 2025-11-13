import java.util.List;

public class NaryTreeMaxDepth {


    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        List<Node> children = root.children;
        if(children.isEmpty()){
            return 0;
        }else {
            int a = maxDepth(children.getFirst());
            for (int i = 1; i < children.size(); i++) {
                int b = maxDepth(children.get(i));
                a = Math.max(a, b);
            }
            return a + 1;
        }

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
