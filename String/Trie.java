public class Trie {
    private static final int CharCount = 26;
    Node root = null;

    private class Node {
        boolean isLastChar;
        Node[] child;

        public Node(char c) {
            child = new Node[CharCount];
            for (int i = 0; i < CharCount; i++) {
                child[i] = null;
            }
            isLastChar = false;
        }
    };

    public Trie() {
        root = new Node(' ');// first node with dummy value.
    }

    Node add(String str) {
        if (str == null) {
            return root;
        }
        return add(root, str.toLowerCase(), 0);
    }

    Node add(Node curr, String str, int index) {
        if (curr == null) {
            curr = new Node(str.charAt(index - 1));
        }

        if (str.length() == index) {
            curr.isLastChar = true;
        } else {
            curr.child[str.charAt(index) - 'a'] = add(curr.child[str.charAt(index) - 'a'], str, index + 1);
        }
        return curr;
    }

    void remove(String str) {
        if (str == null) {
            return;
        }
        str = str.toLowerCase();
        remove(root, str, 0);
    }

    void remove(Node curr, String str, int index) {
        if (curr == null) {
            return;
        }
        if (str.length() == index) {
            if (curr.isLastChar) {
                curr.isLastChar = false;
            }
            return;
        }
        remove(curr.child[str.charAt(index) - 'a'], str, index + 1);
    }

    boolean find(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        return find(root, str, 0);
    }

    boolean find(Node curr, String str, int index) {
        if (curr == null) {
            return false;
        }
        if (str.length() == index) {
            return curr.isLastChar;
        }
        return find(curr.child[str.charAt(index) - 'a'], str, index + 1);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String a = "hemant";
        String b = "heman";
        String c = "hemantjain";
        String d = "jain";
        t.add(a);
        t.add(d);
        System.out.println(t.find(a));
        t.remove(a);
        t.remove(d);
        System.out.println(t.find(a));
        System.out.println(t.find(c));
        System.out.println(t.find(d));
    }
}