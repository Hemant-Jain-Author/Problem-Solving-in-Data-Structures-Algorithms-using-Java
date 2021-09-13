public class WildCharMatch {
    public static boolean matchExp(String exp, String str) {
        return matchExpUtil(exp.toCharArray(), str.toCharArray(), 0, 0);
    }

    public static boolean matchExpUtil(char[] exp, char[] str, int m, int n) {
        if (m == exp.length && ( n == str.length || exp[m-1] == '*')) {
            return true;
        }
        if ((m == exp.length && n != str.length) || (m != exp.length && n == str.length)) {
            return false;
        }        
        if (exp[m] == '?' || exp[m] == str[n]) {
            return matchExpUtil(exp, str, m + 1, n + 1);
        }
        if (exp[m] == '*') {
            return matchExpUtil(exp, str, m + 1, n) || matchExpUtil(exp, str, m, n + 1);
        }
        return false;
    }

    public static boolean matchExpDP(String exp, String str) {
        return matchExpUtilDP(exp.toCharArray(), str.toCharArray(), exp.length(), str.length());
    }

    public static boolean matchExpUtilDP(char[] exp, char[] str, int m, int n) {
        boolean[][] lookup = new boolean[m + 1][n + 1];
        lookup[0][0] = true; // empty exp and empty str match.
    
            // 0 row will remain all false. empty exp can't match any str.
        // '*' can match with empty string, column 0 update.
        for (int i = 1; i <= m; i++) {
            if (exp[i - 1] == '*')
                lookup[i][0] = lookup[i - 1][0];
            else
                break;
        }

        // Fill the table in bottom-up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If we see a '*' in pattern:
                // 1) We ignore '*' character and consider 
                // next character in the pattern.
                // 2) We ignore one character in the input str
                // and consider next character.
                if (exp[i - 1] == '*'){
                    lookup[i][j] = lookup[i-1][j] || lookup[i][j-1];
                }
                // Condition when both the pattern and input string
                // have same character. Also '?' match with all the
                // characters.
                else if (exp[i - 1] == '?' || str[j - 1] == exp[i - 1]){
                    lookup[i][j] = lookup[i - 1][j - 1];
                }
                // If characters don't match
                else {
                    lookup[i][j] = false;
                }
            }
        }
        return lookup[m][n];
    }

    public static void main(String[] args) {
        System.out.println(matchExp("*llo,?World?", "Hello, World!"));
        System.out.println(matchExpDP("*llo,?World?", "Hello, World!"));
    }

    public static void main2(String[] args){
        String str = "baaabab";
        String[] pattern = {"*****ba*****ab", "ba*****ab", "ba*ab", 
                            "a*ab","a*****ab", "*a*****ab", "ba*ab****", 
                            "****","*", "aa?ab", "b*b", 
                            "a*a","baaabab", "?baaabab", "*baaaba*"};

        for(String p : pattern) {
            if( matchExp(p, str) != matchExpDP(p, str)) {
                System.out.print(matchExpDP(p, str) + " for ");
                System.out.println(p + " == " + str);
            }            
        }
    }
}