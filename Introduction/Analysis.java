import java.lang.*;
import java.lang.Math;

public class Analysis {

    int fun1(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            m += 1;
        }
        return m;
    }
    
    int fun2(int n) {
        int i, j, m = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun3(int n) {
        int i, j, m = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun4(int n) {
        int i, m = 0;
        i = 1;
        while (i < n) {
            m += 1;
            i = i * 2;
        }
        return m;
    }
    
    int fun5(int n) {
        int i, m = 0;
        i = n;
        while (i > 0) {
            m += 1;
            i = i / 2;
        }
        return m;
    }
    
    int fun6(int n) {
        int i, j, k, m = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    m += 1;
                }
            }
        }
        return m;
    }
    
    int fun7(int n) {
        int i, j, k, m = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                m += 1;
            }
        }
        for (i = 0; i < n; i++) {
            for (k = 0; k < n; k++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun8(int n) {
        int i, j, m = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < Math.sqrt(n); j++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun9(int n) {
        int i, j, m = 0;
        for (i = n; i > 0; i /= 2) {
            for (j = 0; j < i; j++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun10(int n) {
        int i, j, m = 0;
        for (i = 0; i < n; i++) {
            for (j = i; j > 0; j--) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun11(int n) {
        int i, j, k, m = 0;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                for (k = j + 1; k < n; k++) {
                    m += 1;
                }
            }
        }
        return m;
    }
    
    int fun12(int n) {
        int i = 0, j = 0, m = 0;
        for (i = 0; i < n; i++) {
            for (; j < n; j++) {
                m += 1;
            }
        }
        return m;
    }
    
    int fun13(int n) {
        int i, j = 0, m = 0;
        for (i = 1; i <= n; i *= 2) {
            for (j = 0; j <= i; j++) {
                m += 1;
            }
        }
        return m;
    }
    
    public static void main(String[] args) {
        Analysis a = new Analysis();
        System.out.println("N = 100, Number of instructions in O(n)::" + a.fun1(100));
        System.out.println("N = 100, Number of instructions in O(n^2)::" + a.fun2(100));
        System.out.println("N = 100, Number of instructions in O(n^2)::" + a.fun3(100));
        System.out.println("N = 100, Number of instructions in O(log(n))::" + a.fun4(100));
        System.out.println("N = 100, Number of instructions in O(log(n))::" + a.fun5(100));
        System.out.println("N = 100, Number of instructions in O(n^3)::" + a.fun6(100));
        System.out.println("N = 100, Number of instructions in O(n^2)::" + a.fun7(100));
        System.out.println("N = 100, Number of instructions in O(n^(3/2))::" + a.fun8(100));
        System.out.println("N = 100, Number of instructions in O(n)::" + a.fun9(100));
        System.out.println("N = 100, Number of instructions in O(n^2)::" + a.fun10(100));
        System.out.println("N = 100, Number of instructions in O(n^3)::" + a.fun11(100));
        System.out.println("N = 100, Number of instructions in O(n)::" + a.fun12(100));
        System.out.println("N = 100, Number of instructions in O(n)::" + a.fun13(100));
    }
}

/*
N = 100, Number of instructions in O(n)::100
N = 100, Number of instructions in O(n^2)::10000
N = 100, Number of instructions in O(n^2)::4950
N = 100, Number of instructions in O(log(n))::7
N = 100, Number of instructions in O(log(n))::7
N = 100, Number of instructions in O(n^3)::1000000
N = 100, Number of instructions in O(n^2)::20000
N = 100, Number of instructions in O(n^(3/2))::1000
N = 100, Number of instructions in O(n)::197
N = 100, Number of instructions in O(n^2)::4950
N = 100, Number of instructions in O(n^3)::166650
N = 100, Number of instructions in O(n)::100
N = 100, Number of instructions in O(n)::134
*/