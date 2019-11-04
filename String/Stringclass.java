
public class Stringclass {

    public Stringclass() {
        // TODO Auto-generated constructor stub

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "Hello";

        System.out.println("str1 equals str2 :" + str1.equals(str2));
        System.out.println("str1 equals str3 :" + str1.equals(str3));

    }

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "Hello";

        System.out.println("str1 equals str2 :" + str1.equals(str2));
        System.out.println("str1 equals str3 :" + str1.equals(str3));
        /*
         * String str; String text = "Hello, World!"; char[] array = text.toCharArray();
         * 
         * System.out.println(text.charAt(7));
         * 
         * 
         * char[] arr = {'H','e','l','l','o', ',' ,' ','W','o','r','l','d','!'}; String
         * hello = new String(arr);
         * 
         * hello.length(); String first = "Hello, "; String second = "World!"; //String
         * helloworld = first + second; String helloworld = first.concat(second);
         */
    }
}
