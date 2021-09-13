public class MinMaxValueTest {
    public static void main(String args[]) {

        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;

        short maxShort = Short.MAX_VALUE;
        short minShort = Short.MIN_VALUE;

        int maxInteger = Integer.MAX_VALUE;
        int minInteger = Integer.MIN_VALUE;

        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;

        float maxFloat = Float.MAX_VALUE;
        float minFloat = Float.MIN_VALUE;

        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;

        System.out.println("Range of byte :: " + minByte + " to " + maxByte + ".");
        System.out.println("Range of short :: " + minShort + " to " + maxShort + ".");
        System.out.println("Range of integer :: " + minInteger + " to " + maxInteger + ".");
        System.out.println("Range of long :: " + minLong + " to " + maxLong + ".");
        System.out.println("Range of float :: " + minFloat + " to " + maxFloat + ".");
        System.out.println("Range of double :: " + minDouble + " to " + maxDouble + ".");
    }
}

/* 
Range of byte :: -128 to 127.
Range of short :: -32768 to 32767.
Range of integer :: -2147483648 to 2147483647.
Range of long :: -9223372036854775808 to 9223372036854775807.
Range of float :: 1.4E-45 to 3.4028235E38.
Range of double :: 4.9E-324 to 1.7976931348623157E308.
 */