public class Trie {
    private static final int CharCount = 26;
    Node root = null;

    private class Node {
        boolean isLastChar;
        char ch;
        Node[] child;

        public Node(char c) {
            child = new Node[CharCount];
            for (int i = 0; i < CharCount; i++) {
                child[i] = null;
            }
            isLastChar = false;
            ch = c;
        }
    };

    public Trie() {
        root = new Node(' ');// first node with dummy value.
    }

    Node Insert(String str) {
        if (str == null) {
            return root;
        }
        return Insert(root, str.toLowerCase(), 0);
    }

    Node Insert(Node curr, String str, int index) {
        if (curr == null) {
            curr = new Node(str.charAt(index - 1));
        }

        if (str.length() == index) {
            curr.isLastChar = true;
        } else {
            curr.child[str.charAt(index) - 'a'] = Insert(curr.child[str.charAt(index) - 'a'], str, index + 1);
        }

        return curr;
    }

    void Remove(String str) {
        if (str == null) {
            return;
        }

        str = str.toLowerCase();
        Remove(root, str, 0);
    }

    void Remove(Node curr, String str, int index) {
        if (curr == null) {
            return;
        }

        if (str.length() == index) {
            if (curr.isLastChar) {
                curr.isLastChar = false;
            }
            return;
        }

        Remove(curr.child[str.charAt(index) - 'a'], str, index + 1);
    }

    boolean Find(String str) {
        if (str == null) {
            return false;
        }

        str = str.toLowerCase();
        return Find(root, str, 0);
    }

    boolean Find(Node curr, String str, int index) {
        if (curr == null) {
            return false;
        }

        if (str.length() == index) {
            return curr.isLastChar;
        }

        return Find(curr.child[str.charAt(index) - 'a'], str, index + 1);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String a = "hemant";
        String b = "heman";
        String c = "hemantjain";
        String d = "jain";
        t.Insert(a);
        t.Insert(d);
        System.out.println(t.Find(a));
        t.Remove(a);
        t.Remove(d);
        System.out.println(t.Find(a));
        System.out.println(t.Find(c));
        System.out.println(t.Find(d));
    }
}