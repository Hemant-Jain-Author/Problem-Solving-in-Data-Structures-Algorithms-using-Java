import java.util.ArrayDeque;
import java.util.Stack;

public class Tree {
	private Node root;

	private static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int v, Node l, Node r) {
			value = v;
			left = l;
			right = r;
		}

		public Node(int v) {
			value = v;
			left = null;
			right = null;
		}
	}

	public Tree() {
		root = null;
	}
	/* Other methods */

	public void createCompleteBinaryTree(int[] arr) {
		root = createCompleteBinaryTree(arr, 0);
	}

	public Node createCompleteBinaryTree(int[] arr, int start) {
		int size = arr.length;
		Node curr = new Node(arr[start]);

		int leftIndex = 2 * start + 1;
		int rightIndex = 2 * start + 2;

		if (leftIndex < size)
			curr.left = createCompleteBinaryTree(arr, leftIndex);
		if (rightIndex < size)
			curr.right = createCompleteBinaryTree(arr, rightIndex);

		return curr;
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value, null, null);
		} else {
			if (node.value > value) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		return node;
	}

	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}

	private void printPreOrder(Node node) { /* pre order */
		if (node != null) {
			System.out.print(node.value + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	public void nthPreOrder(int index) {
		int[] counter = { 0 };
		nthPreOrder(root, index, counter);
	}

	private void nthPreOrder(Node node, int index, int[] counter) { /* pre order */
		if (node != null) {
			counter[0]++;
			if (counter[0] == index) {
				System.out.println(node.value);
			}
			nthPreOrder(node.left, index, counter);
			nthPreOrder(node.right, index, counter);
		}
	}

	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}

	private void printPostOrder(Node node) { /* post order */
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.value + " ");
		}
	}

	public void nthPostOrder(int index) {
		int[] counter = { 0 };
		nthPostOrder(root, index, counter);
	}

	private void nthPostOrder(Node node, int index, int[] counter) { /* post order */
		if (node != null) {
			nthPostOrder(node.left, index, counter);
			nthPostOrder(node.right, index, counter);
			counter[0]++;
			if (counter[0] == index) {
				System.out.println(node.value);
			}
		}
	}

	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}

	private void printInOrder(Node node) { /* In order */
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.value + " ");
			printInOrder(node.right);
		}
	}

	public void nthInOrder(int index) {
		int[] counter = { 0 };
		nthInOrder(root, index, counter);
	}

	private void nthInOrder(Node node, int index, int[] counter) {

		if (node != null) {
			nthInOrder(node.left, index, counter);
			counter[0]++;
			if (counter[0] == index) {
				System.out.println(node.value);
			}
			nthInOrder(node.right, index, counter);
		}
	}

	public void printBreadthFirst() {
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		Node temp;
		if (root != null)
			que.add(root);

		while (que.isEmpty() == false) {
			temp = que.remove();
			System.out.print(temp.value + " ");

			if (temp.left != null)
				que.add(temp.left);
			if (temp.right != null)
				que.add(temp.right);
		}
	}

	public void printDepthFirst() {
		Stack<Node> stk = new Stack<Node>();
		Node temp;

		if (root != null)
			stk.push(root);

		while (stk.isEmpty() == false) {
			temp = stk.pop();
			System.out.print(temp.value + " ");

			if (temp.left != null)
				stk.push(temp.left);
			if (temp.right != null)
				stk.push(temp.right);
		}
	}

	void printLevelOrderLineByLine() {
		ArrayDeque<Node> que1 = new ArrayDeque<Node>();
		ArrayDeque<Node> que2 = new ArrayDeque<Node>();
		Node temp = null;
		if (root != null)
			que1.add(root);
		while (que1.size() != 0 || que2.size() != 0) {
			while (que1.size() != 0) {
				temp = que1.remove();
				System.out.print(temp.value + " ");
				if (temp.left != null)
					que2.add(temp.left);
				if (temp.right != null)
					que2.add(temp.right);
			}
			System.out.println("");

			while (que2.size() != 0) {
				temp = que2.remove();
				System.out.print(temp.value + " ");
				if (temp.left != null)
					que1.add(temp.left);
				if (temp.right != null)
					que1.add(temp.right);
			}
			System.out.println();
		}
	}

	void printLevelOrderLineByLine2() {
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		Node temp = null;
		int count = 0;

		if (root != null)
			que.add(root);
		while (que.size() != 0) {
			count = que.size();
			while (count > 0) {
				temp = que.remove();
				System.out.print(temp.value + " ");
				if (temp.left != null)
					que.add(temp.left);
				if (temp.right != null)
					que.add(temp.right);
				count -= 1;
			}
			System.out.println();
		}
	}

	void printSpiralTree() {
		Stack<Node> stk1 = new Stack<Node>();
		Stack<Node> stk2 = new Stack<Node>();

		Node temp;
		if (root != null)
			stk1.push(root);
		while (stk1.size() != 0 || stk2.size() != 0) {
			while (stk1.size() != 0) {
				temp = stk1.pop();
				System.out.print(temp.value + " ");
				if (temp.right != null)
					stk2.push(temp.right);
				if (temp.left != null)
					stk2.push(temp.left);
			}
			while (stk2.size() != 0) {
				temp = stk2.pop();
				System.out.print(temp.value + " ");
				if (temp.left != null)
					stk1.push(temp.left);
				if (temp.right != null)
					stk1.push(temp.right);
			}
		}
		System.out.println();
	}

	public boolean find(int value) {
		Node curr = root;

		while (curr != null) {
			if (curr.value == value) {
				return true;
			} else if (curr.value > value) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return false;
	}

	public boolean find2(int value) {
		Node curr = root;
		while (curr != null && curr.value != value)
			curr = (curr.value > value) ? curr.left : curr.right;
		return curr != null;
	}

	public int findMin() {
		Node node = root;
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	public int findMax() {
		Node node = root;
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	public Node findMaxNode(Node curr) {
		Node node = curr;
		if (node == null) {
			return null;
		}

		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public Node findMinNode(Node curr) {
		Node node = curr;
		if (node == null) {
			return null;
		}

		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public void free() {
		root = null;
	}

	public void deleteNode(int value) {
		root = deleteNode(root, value);
	}

	private Node deleteNode(Node node, int value) {
		if (node != null) {
			if (node.value == value) {
				if (node.left == null && node.right == null) {
					return null;
				} else {
					if (node.left == null) {
						return node.right;
					}

					if (node.right == null) {
						return node.left;
					}
					Node minNode = findMinNode(node.right);
					int minValue = minNode.value;
					node.value = minValue;
					node.right = deleteNode(node.right, minValue);
				}
			} else {
				if (node.value > value) {
					node.left = deleteNode(node.left, value);
				} else {
					node.right = deleteNode(node.right, value);
				}
			}
		}
		return node;
	}

	public int treeDepth() {
		return treeDepth(root);
	}

	private int treeDepth(Node curr) {
		if (curr == null)
			return 0;
		else {
			int lDepth = treeDepth(curr.left);
			int rDepth = treeDepth(curr.right);

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
			return (isEqualUtil(node1.left, node2.left) && isEqualUtil(node1.right, node2.right)
					&& (node1.value == node2.value));
	}

	public Node ancestor(int first, int second) {
		if (first > second) {
			int temp = first;
			first = second;
			second = temp;
		}
		return ancestor(root, first, second);
	}

	private Node ancestor(Node curr, int first, int second) {
		if (curr == null) {
			return null;
		}

		if (curr.value > first && curr.value > second) {
			return ancestor(curr.left, first, second);
		}
		if (curr.value < first && curr.value < second) {
			return ancestor(curr.right, first, second);
		}
		return curr;
	}

	public Tree copyTree() {
		Tree tree2 = new Tree();
		tree2.root = copyTree(root);
		return tree2;
	}

	private Node copyTree(Node curr) {
		Node temp;
		if (curr != null) {
			temp = new Node(curr.value);
			temp.left = copyTree(curr.left);
			temp.right = copyTree(curr.right);
			return temp;
		} else
			return null;
	}

	public Tree copyMirrorTree() {
		Tree tree2 = new Tree();
		tree2.root = copyMirrorTree(root);
		return tree2;
	}

	private Node copyMirrorTree(Node curr) {
		Node temp;
		if (curr != null) {
			temp = new Node(curr.value);
			temp.right = copyMirrorTree(curr.left);
			temp.left = copyMirrorTree(curr.right);
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
			return (1 + numNodes(curr.right) + numNodes(curr.left));
	}

	public int numFullNodesBT() {
		return numFullNodesBT(root);
	}

	public int numFullNodesBT(Node curr) {
		if (curr == null)
			return 0;

		int count = numFullNodesBT(curr.right) + numFullNodesBT(curr.left);
		if (curr.right != null && curr.left != null)
			count++;
		return count;
	}

	public int maxLengthPathBT() {
		return maxLengthPathBT(root);
	}

	private int maxLengthPathBT(Node curr) { // diameter
		int max;
		int leftPath, rightPath;
		int leftMax, rightMax;

		if (curr == null)
			return 0;

		leftPath = treeDepth(curr.left);
		rightPath = treeDepth(curr.right);
		max = leftPath + rightPath + 1;
		leftMax = maxLengthPathBT(curr.left);
		rightMax = maxLengthPathBT(curr.right);

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
		if (curr.left == null && curr.right == null)
			return 1;
		else
			return (numLeafNodes(curr.right) + numLeafNodes(curr.left));
	}

	public int sumAllBT() {
		return sumAllBT(root);
	}

	private int sumAllBT(Node curr) {
		if (curr == null)
			return 0;

		return (curr.value + sumAllBT(curr.left) + sumAllBT(curr.right));
	}

	public void iterativePreOrder() {
		Stack<Node> stk = new Stack<Node>();
		Node curr;

		if (root != null)
			stk.add(root);

		while (stk.isEmpty() == false) {
			curr = stk.pop();
			System.out.print(curr.value + " ");

			if (curr.right != null)
				stk.push(curr.right);

			if (curr.left != null)
				stk.push(curr.left);
		}
		System.out.println();
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
				if (curr.right != null) {
					stk.push(curr.right);
					visited.push(0);
				}
				if (curr.left != null) {
					stk.push(curr.left);
					visited.push(0);
				}
			}
		}
		System.out.println();
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
				if (curr.right != null) {
					stk.push(curr.right);
					visited.push(0);
				}
				stk.push(curr);
				visited.push(1);
				if (curr.left != null) {
					stk.push(curr.left);
					visited.push(0);
				}
			}
		}
		System.out.println();
	}

	public boolean isBST3() {
		return isBST3(root);
	}

	private boolean isBST3(Node root) {
		if (root == null)
			return true;
		if (root.left != null && findMaxNode(root.left).value > root.value)
			return false;
		if (root.right != null && findMinNode(root.right).value <= root.value)
			return false;
		return (isBST3(root.left) && isBST3(root.right));
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node curr, int min, int max) {
		if (curr == null)
			return true;

		if (curr.value < min || curr.value > max)
			return false;

		return isBST(curr.left, min, curr.value) && isBST(curr.right, curr.value, max);
	}

	public boolean isBST2() {
		int[] count = new int[1];
		return isBST2(root, count);
	}

	private boolean isBST2(Node root, int[] count) { /* in order traversal */
		boolean ret;
		if (root != null) {
			ret = isBST2(root.left, count);
			if (!ret)
				return false;

			if (count[0] > root.value)
				return false;
			count[0] = root.value;

			ret = isBST2(root.right, count);
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
			if (temp.left != null) {
				if (noChild == 1)
					return false;
				que.add(temp.left);
			} else
				noChild = 1;

			if (temp.right != null) {
				if (noChild == 1)
					return false;
				que.add(temp.right);
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
		return isCompleteTreeUtil(curr.left, index * 2 + 1, count)
				&& isCompleteTreeUtil(curr.right, index * 2 + 2, count);
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
		return (isHeapUtil(curr.left, curr.value) && isHeapUtil(curr.right, curr.value));
	}

	boolean isHeap() {
		int infinite = -9999999;
		return (isCompleteTree() && isHeapUtil(root, infinite));
	}

	boolean isHeapUtil2(Node curr, int index, int count, int parentValue) {
		if (curr == null)
			return true;
		if (index > count)
			return false;
		if (curr.value < parentValue)
			return false;
		return isHeapUtil2(curr.left, index * 2 + 1, count, curr.value)
				&& isHeapUtil2(curr.right, index * 2 + 2, count, curr.value);
	}

	boolean isHeap2() {
		int count = numNodes();
		int parentValue = -9999999;
		return isHeapUtil2(root, 0, count, parentValue);
	}

	public Node treeToListRec() {
		return treeToListRec(root);
	}

	private Node treeToListRec(Node curr) {
		Node Head = null, Tail = null;
		if (curr == null)
			return null;

		if (curr.left == null && curr.right == null) {
			curr.left = curr;
			curr.right = curr;
			return curr;
		}

		if (curr.left != null) {
			Head = treeToListRec(curr.left);
			Tail = Head.left;

			curr.left = Tail;
			Tail.right = curr;
		} else
			Head = curr;

		if (curr.right != null) {
			Node tempHead = treeToListRec(curr.right);
			Tail = tempHead.left;

			curr.right = tempHead;
			tempHead.left = curr;
		} else
			Tail = curr;

		Head.left = Tail;
		Tail.right = Head;
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

		if (curr.left == null && curr.right == null) {
			System.out.println(stk);
			stk.pop();
			return;
		}

		printAllPathUtil(curr.right, stk);
		printAllPathUtil(curr.left, stk);
		stk.pop();
	}

	public int lca(int first, int second) {
		Node ans = lca(root, first, second);
		if (ans != null)
			return ans.value;
		else
			return Integer.MIN_VALUE;
	}

	private Node lca(Node curr, int first, int second) {
		Node left, right;

		if (curr == null)
			return null;

		if (curr.value == first || curr.value == second)
			return curr;

		left = lca(curr.left, first, second);
		right = lca(curr.right, first, second);

		if (left != null && right != null)
			return curr;
		else if (left != null)
			return left;
		else
			return right;
	}

	public int lcaBST(int first, int second) {
		int result;
		if (first > second)
			result = lcaBST(root, second, first);
		else
			result = lcaBST(root, first, second);

		if (result == Integer.MAX_VALUE)
			System.out.println("lca does not exist");
		else
			System.out.println("lca is :" + result);
		return result;
	}

	private int lcaBST(Node curr, int first, int second) {
		if (curr == null) {
			return Integer.MAX_VALUE;
		}

		if (curr.value > second) {
			return lcaBST(curr.left, first, second);
		}
		if (curr.value < first) {
			return lcaBST(curr.right, first, second);
		}
		if (find(first) && find(second))
			return curr.value;
		return Integer.MAX_VALUE;
	}

	public void trimOutsideRange(int min, int max) {
		trimOutsideRange(root, min, max);
	}

	private Node trimOutsideRange(Node curr, int min, int max) {
		if (curr == null)
			return null;

		curr.left = trimOutsideRange(curr.left, min, max);
		curr.right = trimOutsideRange(curr.right, min, max);

		if (curr.value < min) {
			return curr.right;
		}

		if (curr.value > max) {
			return curr.left;
		}

		return curr;
	}

	public void printInRange(int min, int max) {
		printInRange(root, min, max);
		System.out.println();
	}

	private void printInRange(Node root, int min, int max) {
		if (root == null)
			return;

		printInRange(root.left, min, max);

		if (root.value >= min && root.value <= max)
			System.out.print(root.value + " ");

		printInRange(root.right, min, max);
	}

	public int floorBST(double val) {
		Node curr = root;
		int floor = Integer.MAX_VALUE;

		while (curr != null) {
			if (curr.value == val) {
				floor = curr.value;
				break;
			} else if (curr.value > val) {
				curr = curr.left;
			} else {
				floor = curr.value;
				curr = curr.right;
			}
		}
		return floor;
	}

	public int ceilBST(double val) {
		Node curr = root;
		int ceil = Integer.MIN_VALUE;

		while (curr != null) {
			if (curr.value == val) {
				ceil = curr.value;
				break;
			} else if (curr.value > val) {
				ceil = curr.value;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return ceil;
	}

	public int findMaxBT() {
		int ans = findMaxBT(root);
		return ans;
	}

	private int findMaxBT(Node curr) {
		if (curr == null)
			return Integer.MIN_VALUE;

		int max = curr.value;
		int leftmax = findMaxBT(curr.left);
		int rightmax = findMaxBT(curr.right);

		if (leftmax > max)
			max = leftmax;
		if (rightmax > max)
			max = rightmax;
		return max;
	}

	public boolean searchBT(int value) {
		return searchBTUtil(root, value);
	}

	public boolean searchBTUtil(Node curr, int value) {
		if (curr == null)
			return false;

		if ((curr.value == value) || searchBTUtil(curr.left, value) || searchBTUtil(curr.right, value))
			return true;

		return false;
	}

	public void createBinarySearchTree(int[] arr) {
		root = createBinarySearchTree(arr, 0, arr.length - 1);
	}

	private Node createBinarySearchTree(int[] arr, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node curr = new Node(arr[mid]);
		curr.left = createBinarySearchTree(arr, start, mid - 1);
		curr.right = createBinarySearchTree(arr, mid + 1, end);
		return curr;
	}

	boolean isBSTArray(int preorder[]) {
		int size = preorder.length;
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

public static void main1() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createCompleteBinaryTree(arr);
	t.printPreOrder();
	// 1 2 4 8 9 5 10 3 6 7 

	t.printPostOrder();
	// 8 9 4 10 5 2 6 7 3 1 

	t.printInOrder();
	// 8 4 9 2 10 5 1 6 3 7 

	t.iterativePreOrder();
	// 1 2 4 8 9 5 10 3 6 7 

	t.iterativePostOrder();
	// 8 9 4 10 5 2 6 7 3 1 

	t.iterativeInOrder();
	// 8 4 9 2 10 5 1 6 3 7 

	t.printBreadthFirst();
	// 1 2 3 4 5 6 7 8 9 10 

	t.printDepthFirst();
	// 1 3 7 6 2 5 10 4 9 8

	t.printLevelOrderLineByLine();
	/*
	1 
	2 3 
	4 5 6 7 
	8 9 10 
	*/

	t.printLevelOrderLineByLine2();
	/*
	1 
	2 3 
	4 5 6 7 
	8 9 10 
	*/

	t.printSpiralTree();
	// 1 2 3 7 6 5 4 8 9 10 

	t.nthInOrder(2);
	t.nthPostOrder(2);
	t.nthPreOrder(2);

	/*
	4
	9
	2
	*/

	t.printAllPath();

	/*
[1, 3, 7]
[1, 3, 6]
[1, 2, 5, 10]
[1, 2, 4, 9]
[1, 2, 4, 8]
	*/
}

public static void main2() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createCompleteBinaryTree(arr);

	System.out.println(t.numNodes());
	// 10

	System.out.println(t.sumAllBT());
	// 55

	System.out.println(t.numLeafNodes());
	// 5

	System.out.println(t.numFullNodesBT());
	// 4

	System.out.println(t.searchBT(9));
	// true

	System.out.println(t.findMaxBT());
	// 10

	System.out.println(t.treeDepth());
	// 4

	System.out.println(t.maxLengthPathBT());
	// 6
}

public static void main3() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createCompleteBinaryTree(arr);

	Tree t2 = t.copyTree();
	t2.printInOrder();
	/*
8 4 9 2 10 5 1 6 3 7 
	*/
	Tree t3 = t.copyMirrorTree();
	t3.printInOrder();
	/*
7 3 6 1 5 10 2 9 4 8
	*/
	System.out.println(t.isEqual(t2));
	/*
	true
	*/
	System.out.println(t.isHeap());
	System.out.println(t.isHeap2());
	System.out.println(t.isCompleteTree());
	System.out.println(t.isCompleteTree2());
	/*
	true
	true
	true
	true
	*/
}

public static void main4() {
	Tree t = new Tree();
    t.insert(6);
    t.insert(4);
    t.insert(2);
    t.insert(5);
    t.insert(1);
    t.insert(3);
    t.insert(8);
    t.insert(7);
    t.insert(9);
    t.insert(10);
	t.printInOrder();

	/*
	1 2 3 4 5 6 7 8 9 10 

	*/
	System.out.println(t.find(3));
	System.out.println(t.find(16));
	/*
	true
	false
	*/
	System.out.println(t.isBST());
	System.out.println(t.isBST2());
	System.out.println(t.isBST3());
	/*
	true
	true
	true
	*/

}

public static void main8() {
	Tree t = new Tree();
	t.insert(2);
	t.insert(1);
	t.insert(3);
	t.insert(4);

	System.out.println("Before delete operation.");
	t.printInOrder();
	t.deleteNode(2);
	System.out.println("After delete operation.");
	t.printInOrder();
}
/*
Before delete operation.
1 2 3 4 
After delete operation.
1 3 4 
*/

public static void main5() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createBinarySearchTree(arr);
	System.out.println(t.findMin());
	System.out.println(t.findMax());
	t.lcaBST(3, 4);
	t.lcaBST(1, 4);
	t.lcaBST(10, 4);
}

/*
1
10
lca is :3
lca is :2
lca is :5
*/

public static void main6() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createBinarySearchTree(arr);
	t.printInOrder();
	t.printInRange(4, 7);
	t.trimOutsideRange(4, 7);
	t.printInOrder();
}

/*
1 2 3 4 5 6 7 8 9 10 
4 5 6 7 
4 5 6 7 
*/

public static void main7() {
	Tree t = new Tree();
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	t.createBinarySearchTree(arr);
	System.out.println(t.ancestor(1, 10).value);
	// 5

	System.out.println(t.ceilBST(5.5));
	// 6

	System.out.println(t.floorBST(5.5));
	// 5

	int[] arr1 = { 5, 2, 4, 6, 9, 10 };
	int[] arr2 = { 5, 2, 6, 4, 7, 9, 10 };
	System.out.println(t.isBSTArray(arr1));
	System.out.println(t.isBSTArray(arr2));
	/*
	true
	false
	*/
}

public static void main(String[] args) {
	main1();
	main2();
	main3();
	main4();
	main5();
	main6();
	main7();
}
}