public class BitManipulation {
    public static int andEx(int a, int b){
        return a & b;
    }

    public static int orEx(int a, int b){
        return a | b;
    }

    public static int xorEx(int a, int b){
        return a ^ b;
    }

    public static int leftShiftEx(int a){ // multiply by 2
        return a << 1;
    }

    public static int rightShiftEx(int a){ // divide by 2
        return a >> 1;
    }

    public static int bitReversalEx(int a){
        return ~a;
    }

    public static int twoComplementEx(int a){
        return -a;
    }

    public static boolean kthBitCheck(int a, int k){
        return (a & 1<<(k-1)) > 0;
    }

    public static int kthBitSet(int a, int k){
        return (a | 1<<(k-1));
    }

    public static int kthBitReset(int a, int k){
        return (a & ~(1<<(k-1)));
    }

    public static int kthBitToggle(int a, int k){
        return (a ^ (1<<(k-1)));
    }

    public static int rightMostBit(int a){
        return a & -a;
    }

    public static int resetRightMostBit(int a){
        return a & (a - 1);
    }

    public static boolean isPowerOf2(int a){
        if((a & (a - 1)) == 0)
            return true;
        else 
            return false;
    }

    public static int countBits(int a){
        int count = 0;
        while(a > 0){
            count += 1;
            a = a & (a - 1); // reset least significant bit.
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 4; 
        int b = 8;
        /*
        System.out.println(andEx(a, b));
        System.out.println(orEx(a, b));
        System.out.println(xorEx(a, b));
        System.out.println(leftShiftEx(a)); // multiply by 2
        System.out.println(rightShiftEx(a)); // divide by 2
        System.out.println(bitReversalEx(a));
        System.out.println(twoComplementEx(a));
        System.out.println(kthBitCheck(a, 3));
        System.out.println(kthBitSet(a, 2));
        System.out.println(kthBitReset(a, 3));
        System.out.println(kthBitToggle(a, 3));
        System.out.println(rightMostBit(a));
        System.out.println(resetRightMostBit(a));
        System.out.println(isPowerOf2(a));
        */
        for(int i=0;i<10;i++)
            System.out.println(i + " bit count : " + countBits(i));
    }
}

/*
0
12
12
8
2
-5
-4
true
6
0
0
4
0
true
*/

/*
0 bit count : 0
1 bit count : 1
2 bit count : 1
3 bit count : 2
4 bit count : 1
5 bit count : 2
6 bit count : 2
7 bit count : 3
8 bit count : 1
9 bit count : 2
*/