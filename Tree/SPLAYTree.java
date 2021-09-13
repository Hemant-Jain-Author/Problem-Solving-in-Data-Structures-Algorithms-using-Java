import java.util.ArrayDeque;

public class SPLAYTree {
    private Node root;

    private static class Node {
        int data;
        Node left, right, parent;
        public Node(int d, Node l, Node r) {
            data = d;
            left = l;
            right = r;
            parent = null;
        }
    }

    public SPLAYTree() {
        root = null;
    }
    
    public void printTree() {
        printTree(root, "", false);
        System.out.println();
    }

    private void printTree(Node node, String indent, boolean isLeft) {
        if (node == null)
            return;
        if (isLeft) {
            System.out.print(indent + "L:");
            indent += "|  ";
        } else {
            System.out.print(indent + "R:");
            indent += "   ";
        }

        System.out.println(node.data );
        printTree(node.left, indent, true);
        printTree(node.right, indent, false);
    }


    // Function to right rotate subtree rooted with x
    Node rightRotate(Node x) {
        Node y = x.left;
        Node T = y.right;
 
        // Rotation
        y.parent = x.parent;
        y.right = x;
        x.parent = y;
        x.left = T;
        if(T != null)
            T.parent = x;

        if(y.parent != null && y.parent.left == x)
            y.parent.left = y;
        else if(y.parent != null && y.parent.right == x)
            y.parent.right = y;
        // Return new root
        return y;
    }

    // Function to left rotate subtree rooted with x
    Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T = y.left;
 
        // Rotation
        y.parent = x.parent;
        y.left = x;
        x.parent = y;
        x.right = T;
        if(T != null)
            T.parent = x;

        if(y.parent != null && y.parent.left == x)
            y.parent.left = y;
        else if(y.parent != null && y.parent.right == x)
            y.parent.right = y;
        // Return new root
        return y;
    }

    Node parent(Node node){
        if(node == null || node.parent == null)
            return null;
        return node.parent;
    }

    public void splay(Node node){
        Node parent, grand;
        while(node != root){
            parent = parent(node);
            grand = parent(parent);
            if(parent == null) { // rotations had created new root, always last condition.
                root = node;
            } else if(grand == null){ // single rotation case.
                if(parent.left == node){
                   node = rightRotate(parent);
                } else {
                    node = leftRotate(parent);
                }
            } else if(grand.left == parent && parent.left == node) { // Zig Zig case.
                rightRotate(grand);
                node = rightRotate(parent);
            } else if(grand.right == parent && parent.right == node) { // Zag Zag case.
                leftRotate(grand);
                node = leftRotate(parent);
            } else if(grand.left == parent && parent.right == node) { //Zig Zag case.
                leftRotate(parent);
                node = rightRotate(grand);
            } else if(grand.right == parent && parent.left == node) { // Zag Zig case.
                rightRotate(parent);
                node = leftRotate(grand);
            }
        }
    }

    public boolean find(int data) {   
        Node curr = root;
        while (curr != null) {
            if (curr.data == data) {
                splay(curr);
                return true;
            } else if (curr.data > data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }

    public void insert(int data) {
        Node newNode = new Node(data, null, null);
        if (root == null) {
            root = newNode;
            return;
        }
        
        Node node = root;
        Node parent = null;
        while(node != null){
            parent = node;
            if (node.data > data) {
                node = node.left;
            } else if(node.data < data) {
                node = node.right;
            } else {
                splay(node); // duplicate insertion not allowed but splaying for it.
                return;
            }
        }

        newNode.parent = parent;
        if(parent.data > data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        splay(newNode); 
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
    
    public void delete(int data) {
        Node node = root;
        Node parent = null;
        Node next = null;
        while(node != null){
            if (node.data == data){
                parent = node.parent;
                if(node.left == null && node.right == null){
                    next = null;
                } else if (node.left == null) {
                    next = node.right;
                } else if(node.right == null) {
                    next = node.left;
                } 

                if(node.left == null || node.right == null){
                    if(node == root){
                        root = next;
                        return ;
                    }
                    if(parent.left == node){
                        parent.left = next;
                    } else {
                        parent.right = next;
                    }
                    if(next != null)
                        next.parent = parent;
                    break;
                }

                Node minNode = findMinNode(node.right);
                data = minNode.data;
                node.data = data;
                node = node.right;
                
            } else if(node.data > data) {
                parent = node;
                node = node.left;
            } else {
                parent = node;
                node = node.right;
            }
        }
        splay(parent); // Splaying for the parent of the node deleted.
    }
    
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    
    private void printInOrder(Node node)/* In order */
    {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }
    
    public static void main(String[] arg) {
        SPLAYTree tree = new SPLAYTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.printTree();
        
        System.out.println("Value 2 found: " + tree.find(2));
        tree.delete(2);
        tree.delete(5);
        tree.printTree();
    }
}

/*
R:3
   L:2
   |  L:1
   R:6
      L:4
      |  R:5

Value 2 found: true
R:4
   L:3
   |  L:1
   R:6 
*/




