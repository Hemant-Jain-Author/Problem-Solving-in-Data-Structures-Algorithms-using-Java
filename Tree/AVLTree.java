import java.util.ArrayDeque;

public class AVLTree {
    private Node root;

    private static class Node {
        private int data;
        private Node left;
        private Node right;
        private int height;

        public Node(int d, Node l, Node r) {
            data = d;
            left = l;
            right = r;
            height = 0;
        }
    }

    public AVLTree() {
        root = null;
    }

    int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    int getBalance(Node node) {    
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    private Node insert(Node node, int data) {
        if (node == null)
            return new Node(data, null, null);
        
        if (node.data > data) {
            node.left = insert(node.left, data);
        } 
        else if(node.data < data) {
            node.right = insert(node.right, data);
        }
        else { // Duplicate data not allowed
            return node;
        }

        node.height = max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        
        if (balance > 1) {
            if (data < node.left.data) // Left Left Case
            {    
                return rightRotate(node);
            }
            if (data > node.left.data) // Left Right Case
            {
                return leftRightRotate(node);
            }
        }

        if (balance < -1 ) {
            if (data > node.right.data) // Right Right Case
            {    
                return leftRotate(node);
            }
            if (data < node.right.data) // Right Left Case
            {    
                return rightLeftRotate(node);
            }
        }
        return node;
    }

    // Function to right rotate subtree rooted with x
    Node rightRotate(Node x) {
        Node y = x.left;
        Node T = y.right;
 
        // Rotation
        y.right = x;
        x.left = T;
 
        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }

    // Function to left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T = y.left;
 
        // Rotation
        y.left = x;
        x.right = T;
 
        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }

    // Function to right then left rotate subtree rooted with x
    Node rightLeftRotate(Node x) {
        x.right = rightRotate(x.right);
        return leftRotate(x);
    }

    // Function to left then right rotate subtree rooted with x
    Node leftRightRotate(Node x) {
        x.left = leftRotate(x.left);
        return rightRotate(x);
    } 

    public void delete(int data) {
        root = delete(root, data);
    }
    
    private Node delete(Node node, int data) {
        if (node == null)
            return null;

        if (node.data == data) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right; // no need to modify height
            } else if (node.right == null) {
                return node.left; // no need to modify height
            } else {
                Node minNode = findMin(node.right);
                node.data = minNode.data;
                node.right = delete(node.right, minNode.data);
            }
        } else {
            if (node.data > data) {
                node.left = delete(node.left, data);
            } else {
                node.right = delete(node.right, data);
            }
        }

        node.height = max(height(node.left), height(node.right)) + 1; 
        int balance = getBalance(node);     
     
        if(balance > 1) {
            if( data >= node.left.data) // Left Left Case 
            {
                return rightRotate(node); 
            }
            if(data < node.left.data) // Left Right Case
            {
                return leftRightRotate(node);
            }    
        }

        if(balance < -1) {
            if( data <= node.right.data) // Right Right Case 
            {    
                return leftRotate(node); 
            }
            if(data > node.right.data) // Right Left Case
            {
                return rightLeftRotate(node);
            }
        }
        return node;
    }

    public Node findMin(Node curr) {
        Node node = curr;
        if (node == null) {
            return null;
        }
    
        while (node.left != null) {
            node = node.left;
        }
        return node;
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

        System.out.println(node.data + "(" + node.height + ")");
        printTree(node.left, indent, true);
        printTree(node.right, indent, false);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] arg) {
        AVLTree t = new AVLTree();
        t.insert(1); 
        t.insert(2); 
        t.insert(3); 
        t.insert(4); 
        t.insert(5); 
        t.insert(6); 
        t.insert(7); 
        t.insert(8); 
        t.printTree();
        
        /*
 R:4(3)
   L:2(1)
   |  L:1(0)
   |  R:3(0)
   R:6(2)
      L:5(0)
      R:7(1)
         R:8(0)

        */

        t.delete(5);
        t.printTree();

        /*
 R:4(2)
   L:2(1)
   |  L:1(0)
   |  R:3(0)
   R:7(1)
      L:6(0)
      R:8(0)

       */

        t.delete(1);
        t.printTree();

        /*
R:4(2)
   L:2(1)
   |  R:3(0)
   R:7(1)
      L:6(0)
      R:8(0)

        */

        t.delete(2);
        t.printTree();

        /*
R:4(2)
   L:3(0)
   R:7(1)
      L:6(0)
      R:8(0) 
        */
    }
}