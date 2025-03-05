import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        testEqual(reverseString("apple"), "elppa");
        testEqual(reverseString("x"), "x");
        testEqual(reverseString("1234567890"), "0987654321");
    }

    public static String reverseString(String original) {
        // Variables
        String reverse = "";
        Stack<Character> reverseStack = new Stack<>();

        // Main
        for (int i = 0; i < original.length(); i++) {
            reverseStack.push(original.charAt(i));
        }
        
        while (!reverseStack.isEmpty()) {
            reverse += reverseStack.pop();
        }
        
        // Output
        return reverse;
    }

    public static void testEqual(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.printf("%s and %s are equal.%n", str1, str2);
        } else {
            System.out.printf("%s and %s are not equal.%n", str1, str2);
        }
    }
}
