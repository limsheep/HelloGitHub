package learn;

import java.util.StringTokenizer;

/**
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("WARN");
//        System.out.println(System.getenv());
//        System.out.println(System.getProperties());
//        System.out.println(System.getProperty("java.specification.version"));
//        String a = "javaiswhat?";
//        String s = a.substring(2,5);
//        System.out.println(s);

//        String str = "I am yang lin hua~!";
//        for(String word : str.split(" ")){
//            System.out.println(word);
//        }
//        StringTokenizer st = new StringTokenizer("Hello World of Java");
//        while(st.hasMoreTokens()){
//            System.out.println("Token:"+st.nextToken());
//        }
//        String s = "Hello World";
//        for (char ch : s.toCharArray()){
//            System.out.println(ch);
//        }
//       char[] ch = s.toCharArray();
//        for (char c: ch
//             ) {
//            System.out.println(c);
//        }
        String sh = "WARN";
        StringBuilder rev = new StringBuilder(sh).reverse();
        System.out.println(rev);

    }
}
