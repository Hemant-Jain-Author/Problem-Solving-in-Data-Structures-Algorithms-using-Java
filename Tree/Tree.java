import java.util.ArrayDeque;
import java.util.Stack;

public class Tree {
    private Node root;

    private static class Node {
        private int value;
        private Node lChild;
        private Node rChild;

        public Node(int v, Node l, Node r) {
            value = v;
            lChild = l;
            rChild = r;
        }

        public Node(int v) {
            value = v;
            lChild = null;
            rChild = null;
        }
    }

    public Tree() {
        root = null;
    }
    /* Other methods */

    public void levelOrderBinaryTree(int[] arr) {
        root = levelOrderBinaryTree(arr, 0);
    }

    public Node levelOrderBinaryTree(int[] arr, int start) {
        int size = arr.length;
        Node curr = new Node(arr[start]);

        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left < size)
            curr.lChild = levelOrderBinaryTree(arr, left);
        if (right < size)
            curr.rChild = levelOrderBinaryTree(arr, right);

        return curr;
    }

    public void InsertNode(int value) {
        root = InsertNode(root, value);
    }

    private Node InsertNode(Node node, int value) {
        if (node == null) {
            node = new Node(value, null, null);
        } else {
            if (node.value > value) {
                node.lChild = InsertNode(node.lChild, value);
            } else {
                node.rChild = InsertNode(node.rChild, value);
            }
        }
        return node;
    }

    public void PrintPreOrder() {
        PrintPreOrder(root);
    }

    private void PrintPreOrder(Node node)/* pre order */
    {
        if (node != null) {
            System.out.print(" " + node.value);
            PrintPreOrder(node.lChild);
            PrintPreOrder(node.rChild);
        }
    }

    public void NthPreOrder(int index) {
        int[] counter = { 0 };
        NthPreOrder(root, index, counter);
    }

    private void NthPreOrder(Node node, int index, int[] counter)/* pre order */
    {
        if (node != null) {
            counter[0]++;
            if (counter[0] == index) {
                System.out.print(node.value);
            }
            NthPreOrder(node.lChild, index, counter);
            NthPreOrder(node.rChild, index, counter);
        }
    }

    public void PrintPostOrder() {
        PrintPostOrder(root);
    }

    private void PrintPostOrder(Node node)/* post order */
    {
        if (node != null) {
            PrintPostOrder(node.lChild);
            PrintPostOrder(node.rChild);
            System.out.print(" " + node.value);
        }
    }

    public void NthPostOrder(int index) {
        int[] counter = { 0 };
        NthPostOrder(root, index, counter);
    }

    private void NthPostOrder(Node node, int index, int[] counter)/* post order */
    {
        if (node != null) {
            NthPostOrder(node.lChild, index, counter);
            NthPostOrder(node.rChild, index, counter);
            counter[0]++;
            if (counter[0] == index) {
                System.out.print(" " + node.value);
            }
        }
    }

    public void PrintInOrder() {
        PrintInOrder(root);
    }

    private void PrintInOrder(Node node)/* In order */
    {
        if (node != null) {
            PrintInOrder(node.lChild);
            System.out.print(" " + node.value);
            PrintInOrder(node.rChild);
        }
    }

    public void NthInOrder(int index) {
        int[] counter = { 0 };
        NthInOrder(root, index, counter);
    }

    private void NthInOrder(Node node, int index, int[] counter) {

        if (node != null) {
            NthInOrder(node.lChild, index, counter);
            counter[0]++;
            if (counter[0] == index) {
                System.out.print(" " + node.value);
            }
            NthInOrder(node.rChild, index, counter);
        }
    }

    public void PrintBredthFirst() {
        ArrayDeque<Node> que = new ArrayDeque<Node>();
        Node temp;
        if (root != null)
            que.add(root);

        while (que.isEmpty() == false) {
            temp = que.remove();
            System.out.print(" " + temp.value);

            if (temp.lChild != null)
                que.add(temp.lChild);
            if (temp.rChild != null)
                que.add(temp.rChild);
        }
    }

    public void PrintDepthFirst() {
        ArrayDeque<Node> stk = new ArrayDeque<Node>();
        Node temp;

        if (root != null)
            stk.push(root);

        while (stk.isEmpty() == false) {
            temp = stk.pop();
            System.out.println(temp.value);

            if (temp.lChild != null)
                stk.push(temp.lChild);
            if (temp.rChild != null)
                stk.push(temp.rChild);
        }
    }

    void PrintLevelOrderLineByLine() {
        ArrayDeque<Node> que1 = new ArrayDeque<Node>();
        ArrayDeque<Node> que2 = new ArrayDeque<Node>();
        Node temp = null;
        if (root != null)
            que1.add(root);
        while (que1.size() != 0 || que2.size() != 0) {
            while (que1.size() != 0) {
                temp = que1.remove();
                System.out.print(" " + temp.value);
                if (temp.lChild != null)
                    que2.add(temp.lChild);
                if (temp.rChild != null)
                    que2.add(temp.rChild);
            }
            System.out.println("");

            while (que2.size() != 0) {
                temp = (Node) que2.remove();
                System.out.print(" " + temp.value);
                if (temp.lChild != null)
                    que1.add(temp.lChild);
                if (temp.rChild != null)
                    que1.add(temp.rChild);
            }
            System.out.println("");
        }
    }

    void PrintLevelOrderLineByLine2() {
        ArrayDeque<Node> que = new ArrayDeque<Node>();
        Node temp = null;
        int count = 0;

        if (root != null)
            que.add(root);
        while (que.size() != 0) {
            count = que.size();
            while (count > 0) {
                temp = que.remove();
                System.out.print(" " + temp.value);
                if (temp.lChild != null)
                    que.add(temp.lChild);
                if (temp.rChild != null)
                    que.add(temp.rChild);
                count -= 1;
            }
            System.out.println("");
        }
    }

    void PrintSpiralTree() {
        Stack<Node> stk1 = new Stack<Node>();
        Stack<Node> stk2 = new Stack<Node>();

        Node temp;
        if (root != null)
            stk1.push(root);
        while (stk1.size() != 0 || stk2.size() != 0) {
            while (stk1.size() != 0) {
                temp = stk1.pop();
                System.out.print(" " + temp.value);
                if (temp.rChild != null)
                    stk2.push(temp.rChild);
                if (temp.lChild != null)
                    stk2.push(temp.lChild);
            }
            while (stk2.size() != 0) {
                temp = stk2.pop();
                System.out.print(" " + temp.value);
                if (temp.lChild != null)
                    stk1.push(temp.lChild);
                if (temp.rChild != null)
                    stk1.push(temp.rChild);
            }
        }
    }

    public boolean Find(int value) {
        Node curr = root;

        while (curr != null) {
            if (curr.value == value) {
                return true;
            } else if (curr.value > value) {
                curr = curr.lChild;
            } else {
                curr = curr.rChild;
            }
        }
        return false;
    }

    public boolean Find2(int value) {
        Node curr = root;
        while (curr != null && curr.value != value)
            curr = (curr.value > value) ? curr.lChild : curr.rChild;
        return curr != null;
    }

    public int FindMin() {
        Node node = root;
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        while (node.lChild != null) {
            node = node.lChild;
        }
        return node.value;
    }

    public int FindMax() {
        Node node = root;
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        while (node.rChild != null) {
            node = node.rChild;
        }
        return node.value;
    }

    public Node FindMaxNode(Node curr) {
        Node node = curr;
        if (node == null) {
            return null;
        }

        while (node.rChild != null) {
            node = node.rChild;
        }
        return node;
    }

    public Node FindMinNode(Node curr) {
        Node node = curr;
        if (node == null) {
            return null;
        }

        while (node.lChild != null) {
            node = node.lChild;
        }
        return node;
    }

    public void Free() {
        root = null;
    }

    public void DeleteNode(int value) {
        root = DeleteNode(root, value);
    }

    private Node DeleteNode(Node node, int value) {
        Node temp = null;

        if (node != null) {
            if (node.value == value) {
                if (node.lChild == null && node.rChild == null) {
                    return null;
                } else {
                    if (node.lChild == null) {
                        temp = node.rChild;
                        return temp;
                    }

                    if (node.rChild == null) {
                        temp = node.lChild;
                        return temp;
                    }
                    Node minNode = FindMinNode(node.rChild);
                    int minValue = minNode.value;
                    node.value = minValue;
                    node.rChild = DeleteNode(node.rChild, minValue);
                }
            } else {
                if (node.value > value) {
                    node.lChild = DeleteNode(node.lChild, value);
                } else {
                    node.rChild = DeleteNode(node.rChild, value);
                }
            }
        }
        return node;
    }

    public int TreeDepth() {
        return TreeDepth(root);
    }

    private int TreeDepth(Node curr) {
        if (curr == null)
            return 0;
        else {
            int lDepth = TreeDepth(curr.lChild);
            int rDepth = TreeDepth(curr.rChild);

            if (lDepth > rDepth)
                return lDepth + 1;
            else
                return rDepth + 1;
        }
    }

    public boolean isEqual(Tree T2) {
        return isEqualUtil(root, T2.root);
    }

    private boolean isEqualUtil(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else
            return (isEqualUtil(node1.lChild, node2.lChild) && isEqualUtil(node1.rChild, node2.rChild)
                    && (node1.value == node2.value));
    }

    public Node Ancestor(int first, int second) {
        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }
        return Ancestor(root, first, second);
    }

    private Node Ancestor(Node curr, int first, int second) {
        if (curr == null) {
            return null;
        }

        if (curr.value > first && curr.value > second) {
            return Ancestor(curr.lChild, first, second);
        }
        if (curr.value < first && curr.value < second) {
            return Ancestor(curr.rChild, first, second);
        }
        return curr;
    }

    public Tree CopyTree() {
        Tree tree2 = new Tree();
        tree2.root = CopyTree(root);
        return tree2;
    }

    private Node CopyTree(Node curr) {
        Node temp;
        if (curr != null) {
            temp = new Node(curr.value);
            temp.lChild = CopyTree(curr.lChild);
            temp.rChild = CopyTree(curr.rChild);
            return temp;
        } else
            return null;
    }

    public Tree CopyMirrorTree() {
        Tree tree2 = new Tree();
        tree2.root = CopyMirrorTree(root);
        return tree2;
    }

    private Node CopyMirrorTree(Node curr) {
        Node temp;
        if (curr != null) {
            temp = new Node(curr.value);
            temp.rChild = CopyMirrorTree(curr.lChild);
            temp.lChild = CopyMirrorTree(curr.rChild);
            return temp;
        } else
            return null;
    }

    public int numNodes() {
        return numNodes(root);
    }

    public int numNodes(Node curr) {
        if (curr == null)
            return 0;
        else
            return (1 + numNodes(curr.rChild) + numNodes(curr.lChild));
    }

    public int numFullNodesBT() {
        return numNodes(root);
    }

    public int numFullNodesBT(Node curr) {
        int count;
        if (curr == null)
            return 0;

        count = numFullNodesBT(curr.rChild) + numFullNodesBT(curr.lChild);
        if (curr.rChild != null && curr.lChild != null)
            count++;

        return count;
    }

    public int maxLengthPathBT() {
        return maxLengthPathBT(root);
    }

    private int maxLengthPathBT(Node curr)// diameter
    {
        int max;
        int leftPath, rightPath;
        int leftMax, rightMax;

        if (curr == null)
            return 0;

        leftPath = TreeDepth(curr.lChild);
        rightPath = TreeDepth(curr.rChild);

        max = leftPath + rightPath + 1;

        leftMax = maxLengthPathBT(curr.lChild);
        rightMax = maxLengthPathBT(curr.rChild);

        if (leftMax > max)
            max = leftMax;

        if (rightMax > max)
            max = rightMax;

        return max;
    }

    public int numLeafNodes() {
        return numLeafNodes(root);
    }

    private int numLeafNodes(Node curr) {
        if (curr == null)
            return 0;
        if (curr.lChild == null && curr.rChild == null)
            return 1;
        else
            return (numLeafNodes(curr.rChild) + numLeafNodes(curr.lChild));
    }

    public int sumAllBT() {
        return sumAllBT(root);
    }

    private int sumAllBT(Node curr) {
        if (curr == null)
            return 0;

        return (curr.value + sumAllBT(curr.lChild) + sumAllBT(curr.lChild));
    }

    public void iterativePreOrder() {
        Stack<Node> stk = new Stack<Node>();
        Node curr;

        if (root != null)
            stk.add(root);

        while (stk.isEmpty() == false) {
            curr = stk.pop();
            System.out.print(curr.value + " ");

            if (curr.rChild != null)
                stk.push(curr.rChild);

            if (curr.lChild != null)
                stk.push(curr.lChild);
        }
    }

    public void iterativePostOrder() {
        Stack<Node> stk = new Stack<Node>();
        Stack<Integer> visited = new Stack<Integer>();
        Node curr;
        int vtd;

        if (root != null) {
            stk.add(root);
            visited.add(0);
        }

        while (stk.isEmpty() == false) {
            curr = stk.pop();
            vtd = visited.pop();
            if (vtd == 1) {
                System.out.print(curr.value + " ");
            } else {
                stk.push(curr);
                visited.push(1);
                if (curr.rChild != null) {
                    stk.push(curr.rChild);
                    visited.push(0);
                }
                if (curr.lChild != null) {
                    stk.push(curr.lChild);
                    visited.push(0);
                }
            }
        }
    }

    public void iterativeInOrder() {
        Stack<Node> stk = new Stack<Node>();
        Stack<Integer> visited = new Stack<Integer>();
        Node curr;
        int vtd;

        if (root != null) {
            stk.add(root);
            visited.add(0);
        }

        while (stk.isEmpty() == false) {
            curr = stk.pop();
            vtd = visited.pop();
            if (vtd == 1) {
                System.out.print(curr.value + " ");
            } else {
                if (curr.rChild != null) {
                    stk.push(curr.rChild);
                    visited.push(0);
                }
                stk.push(curr);
                visited.push(1);
                if (curr.lChild != null) {
                    stk.push(curr.lChild);
                    visited.push(0);
                }
            }
        }
    }

    public boolean isBST3(Node root) {
        if (root == null)
            return true;
        if (root.lChild != null && FindMaxNode(root.lChild).value > root.value)
            return false;
        if (root.rChild != null && FindMinNode(root.rChild).value <= root.value)
            return false;
        return (isBST3(root.lChild) && isBST3(root.rChild));
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(Node curr, int min, int max) {
        if (curr == null)
            return true;

        if (curr.value < min || curr.value > max)
            return false;

        return isBST(curr.lChild, min, curr.value) && isBST(curr.rChild, curr.value, max);
    }

    public boolean isBST2() {

        int[] count = new int[1];
        return isBST2(root, count);
    }

    private boolean isBST2(Node root, int[] count)/* in order traversal */
    {
        boolean ret;
        if (root != null) {
            ret = isBST2(root.lChild, count);
            if (!ret)
                return false;

            if (count[0] > root.value)
                return false;
            count[0] = root.value;

            ret = isBST2(root.rChild, count);
            if (!ret)
                return false;
        }
        return true;
    }

    boolean isCompleteTree() {
        ArrayDeque<Node> que = new ArrayDeque<Node>();
        Node temp = null;
        int noChild = 0;
        if (root != null)
            que.add(root);
        while (que.size() != 0) {
            temp = que.remove();
            if (temp.lChild != null) {
                if (noChild == 1)
                    return false;
                que.add(temp.lChild);
            } else
                noChild = 1;

            if (temp.rChild != null) {
                if (noChild == 1)
                    return false;
                que.add(temp.rChild);
            } else
                noChild = 1;
        }
        return true;
    }

    boolean isCompleteTreeUtil(Node curr, int index, int count) {
        if (curr == null)
            return true;
        if (index > count)
            return false;
        return isCompleteTreeUtil(curr.lChild, index * 2 + 1, count)
                && isCompleteTreeUtil(curr.rChild, index * 2 + 2, count);
    }

    boolean isCompleteTree2() {
        int count = numNodes();
        return isCompleteTreeUtil(root, 0, count);
    }

    boolean isHeapUtil(Node curr, int parentValue) {
        if (curr == null)
            return true;
        if (curr.value < parentValue)
            return false;
        return (isHeapUtil(curr.lChild, curr.value) && isHeapUtil(curr.rChild, curr.value));
    }

    boolean isHeap() {
        int infi = -9999999;
        return (isCompleteTree() && isHeapUtil(root, infi));
    }

    boolean isHeapUtil2(Node curr, int index, int count, int parentValue) {
        if (curr == null)
            return true;
        if (index > count)
            return false;
        if (curr.value < parentValue)
            return false;
        return isHeapUtil2(curr.lChild, index * 2 + 1, count, curr.value)
                && isHeapUtil2(curr.rChild, index * 2 + 2, count, curr.value);
    }

    boolean isHeap2() {
        int count = numNodes();
        int parentValue = -9999999;
        return isHeapUtil2(root, 0, count, parentValue);
    }

    // void DFS(Node head)
    // {
    // Node curr = head, prev;
    // int count = 0;
    // while (curr && ! curr.visited)
    // {
    // count++;
    // if (curr.lChild && ! curr.lChild.visited)
    // {
    // curr= curr.lChild;
    // }
    // else if (curr.rChild && ! curr.rChild.visited)
    // {
    // curr= curr.rChild;
    // }
    // else
    // {
    // System.out.print((" " + curr.value);
    // curr.visited = 1;
    // curr = head;
    // }
    // }
    // System.out.print(("count is : " + count);
    // }

    public Node treeToListRec() {
        Node head = treeToListRec(root);
        Node temp = head;
        return temp;
    }

    private Node treeToListRec(Node curr) {
        Node Head = null, Tail = null;
        if (curr == null)
            return null;

        if (curr.lChild == null && curr.rChild == null) {
            curr.lChild = curr;
            curr.rChild = curr;
            return curr;
        }

        if (curr.lChild != null) {
            Head = treeToListRec(curr.lChild);
            Tail = Head.lChild;

            curr.lChild = Tail;
            Tail.rChild = curr;
        } else
            Head = curr;

        if (curr.rChild != null) {
            Node tempHead = treeToListRec(curr.rChild);
            Tail = tempHead.lChild;

            curr.rChild = tempHead;
            tempHead.lChild = curr;
        } else
            Tail = curr;

        Head.lChild = Tail;
        Tail.rChild = Head;
        return Head;
    }

    public void printAllPath() {
        Stack<Integer> stk = new Stack<Integer>();
        printAllPathUtil(root, stk);
    }

    private void printAllPathUtil(Node curr, Stack<Integer> stk) {
        if (curr == null)
            return;

        stk.push(curr.value);

        if (curr.lChild == null && curr.rChild == null) {
            System.out.println(stk);
            stk.pop();
            return;
        }

        printAllPathUtil(curr.rChild, stk);
        printAllPathUtil(curr.lChild, stk);
        stk.pop();
    }

    public int LCA(int first, int second) {
        Node ans = LCA(root, first, second);
        if (ans != null)
            return ans.value;
        else
            return Integer.MIN_VALUE;
    }

    private Node LCA(Node curr, int first, int second) {
        Node left, right;

        if (curr == null)
            return null;

        if (curr.value == first || curr.value == second)
            return curr;

        left = LCA(curr.lChild, first, second);
        right = LCA(curr.rChild, first, second);

        if (left != null && right != null)
            return curr;
        else if (left != null)
            return left;
        else
            return right;
    }

    public int LcaBST(int first, int second) {
        return LcaBST(root, first, second);
    }

    private int LcaBST(Node curr, int first, int second) {
        if (curr == null) {
            return Integer.MAX_VALUE;
        }

        if (curr.value > first && curr.value > second) {
            return LcaBST(curr.lChild, first, second);
        }
        if (curr.value < first && curr.value < second) {
            return LcaBST(curr.rChild, first, second);
        }
        return curr.value;
    }

    public void trimOutsideRange(int min, int max) {
        trimOutsideRange(root, min, max);
    }

    private Node trimOutsideRange(Node curr, int min, int max) {
        if (curr == null)
            return null;

        curr.lChild = trimOutsideRange(curr.lChild, min, max);
        curr.rChild = trimOutsideRange(curr.rChild, min, max);

        if (curr.value < min) {
            return curr.rChild;
        }

        if (curr.value > max) {
            return curr.lChild;
        }

        return curr;
    }

    public void printInRange(int min, int max) {
        printInRange(root, min, max);
    }

    private void printInRange(Node root, int min, int max) {
        if (root == null)
            return;

        printInRange(root.lChild, min, max);

        if (root.value >= min && root.value <= max)
            System.out.print(root.value + " ");

        printInRange(root.rChild, min, max);
    }

    public int FloorBST(int val) {
        Node curr = root;
        int floor = Integer.MAX_VALUE;

        while (curr != null) {
            if (curr.value == val) {
                floor = curr.value;
                break;
            } else if (curr.value > val) {
                curr = curr.lChild;
            } else {
                floor = curr.value;
                curr = curr.rChild;
            }
        }
        return floor;
    }

    public int CeilBST(int val) {
        Node curr = root;
        int ceil = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.value == val) {
                ceil = curr.value;
                break;
            } else if (curr.value > val) {
                ceil = curr.value;
                curr = curr.lChild;
            } else {
                curr = curr.rChild;
            }
        }
        return ceil;
    }

    public int findMaxBT() {
        int ans = findMaxBT(root);
        return ans;
    }

    private int findMaxBT(Node curr) {
        int left, right;

        if (curr == null)
            return Integer.MIN_VALUE;

        int max = curr.value;

        left = findMaxBT(curr.lChild);
        right = findMaxBT(curr.rChild);

        if (left > max)
            max = left;
        if (right > max)
            max = right;

        return max;
    }

    public boolean searchBT(int value) {
        return searchBTUtil(root, value);
    }

    public boolean searchBTUtil(Node curr, int value) {
        boolean left, right;
        if (curr == null)
            return false;

        if (curr.value == value)
            return true;

        left = searchBTUtil(curr.lChild, value);
        if (left)
            return true;

        right = searchBTUtil(curr.rChild, value);
        if (right)
            return true;
        return false;
    }

    public void CreateBinaryTree(int[] arr) {
        root = CreateBinaryTree(arr, 0, arr.length - 1);
    }

    private Node CreateBinaryTree(int[] arr, int start, int end) {
        Node curr = null;
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        curr = new Node(arr[mid]);
        curr.lChild = CreateBinaryTree(arr, start, mid - 1);
        curr.rChild = CreateBinaryTree(arr, mid + 1, end);
        return curr;
    }

    boolean isBSTArray(int preorder[], int size) {
        Stack<Integer> stk = new Stack<Integer>();
        int value;
        int root = -999999;
        for (int i = 0; i < size; i++) {
            value = preorder[i];

            // If value of the right child is less than root.
            if (value < root)
                return false;
            // First left child values will be popped
            // Last popped value will be the root.
            while (stk.size() > 0 && stk.peek() < value)
                root = stk.pop();
            // add current value to the stack.
            stk.push(value);
        }
        return true;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        t.levelOrderBinaryTree(arr);
        System.out.println("");
        System.out.println(t.isHeap());
        System.out.println(t.isHeap2());
        System.out.println(t.isCompleteTree());

        System.out.println("");
        t.PrintBredthFirst();
        System.out.println("");
        t.PrintPreOrder();
        System.out.println("");
        t.PrintLevelOrderLineByLine();
        System.out.println("");
        t.PrintLevelOrderLineByLine2();
        System.out.println("");
        t.PrintSpiralTree();
        System.out.println("");
        t.printAllPath();
        System.out.println("");
        t.NthInOrder(4);
        System.out.println("");
        t.NthPostOrder(4);
        System.out.println("");
        t.NthPreOrder(4);
        System.out.println("");
        /*
         * t.PrintPostOrder(); System.out.println(); t.iterativePostOrder();
         * t.PrintBredthFirst(); // t.treeToListRec(); t.printAllPath();
         * System.out.println(t.LCA(10, 3)); t.iterativePreOrder(); t.PrintPreOrder();
         * // t.CreateBinaryTree(arr); // System.out.println(t.isBST2());
         */
    }
}