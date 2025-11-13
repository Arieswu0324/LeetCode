public class UnionFind {

    int[] parent = new int[100];

    UnionFind() {
        for (int i = 0; i < 100; i++) {
            parent[i] = i;
        }
    }
//只有通过连接根节点，才能确保集合中的所有元素（包括那些已经连接到根节点的元素）都包含在新合并的集合中。
//parent[a] = b; 只连接了两个元素，而忽略了它们的整个子树。
    public void join(int a, int b) {
        //错误写法，并不是要a和b相连，而是要a的根与b的根相连
        //这样结构会退化成单链表
        if (isSameSet(a, b)) {
            return;
        }
        parent[a] = b;
    }

    public void correctedJoin(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a != b) {
            parent[a] = b;
        }
    }

    public boolean isSameSet(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        return pa == pb;
    }

    //路径未压缩
    private int findParent(int a) {
        if (a == parent[a]) {
            return a;
        }
        return findParent(parent[a]);
    }

    //路径压缩
    private int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        //这里对parent[a] 进行了改变
        parent[a] = find(parent[a]);
        return parent[a];
    }

}
