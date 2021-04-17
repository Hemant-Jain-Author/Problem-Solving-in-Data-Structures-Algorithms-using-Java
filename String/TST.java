public class TST {
    Node root;

    private class Node {
        char data;
        boolean isLastChar;
        Node left, equal, right;

        private Node(char d) {
            data = d;
            isLastChar = false;
            left = equal = right = null;
        }
    };

    public void add(String word) {
        root = add(root, word, 0);
    }

    private Node add(Node curr, String word, int wordIndex) {
        if (curr == null)
            curr = new Node(word.charAt(wordIndex));
        if (word.charAt(wordIndex) < curr.data)
            curr.left = add(curr.left, word, wordIndex);
        else if (word.charAt(wordIndex) > curr.data)
            curr.right = add(curr.right, word, wordIndex);
        else {
            if (wordIndex < word.length() - 1)
                curr.equal = add(curr.equal, word, wordIndex + 1);
            else
                curr.isLastChar = true;
        }
        return curr;
    }

    private boolean find(Node curr, String word, int wordIndex) {
        if (curr == null)
            return false;
        if (word.charAt(wordIndex) < curr.data)
            return find(curr.left, word, wordIndex);
        else if (word.charAt(wordIndex) > curr.data)
            return find(curr.right, word, wordIndex);
        else {
            if (wordIndex == word.length() - 1)
                return curr.isLastChar;
            return find(curr.equal, word, wordIndex + 1);
        }
    }

    public boolean find(String word) {
        boolean ret = find(root, word, 0);
        return ret;
    }

    public static void main(String[] args) {
        TST tt = new TST();
        tt.add("banana");
        tt.add("apple");
        tt.add("mango");
        System.out.println("Apple Found : " + tt.find("apple"));
        System.out.println("Banana Found : " + tt.find("banana"));
        System.out.println("Grapes Found : " + tt.find("grapes"));
    }
}
/*
Apple Found : true
Banana Found : true
Grapes Found : false
*/