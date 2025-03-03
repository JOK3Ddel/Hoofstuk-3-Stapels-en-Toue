// Libraries
import java.util.Stack;
import java.lang.Character;

public class InfixToPostfix {
    public static void main(String[] args) {
        // Variables
        String expression = "5+2/(3-8)^5^2";

        // Main
        System.out.println(infToPostf(expression));
    }

    // Check for operands
    private static boolean letterOrDigit(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        } else {
            return false;
        }
    }

    // Get operand precedence
    private static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        } else {
            return -1;
        }
    }

    // Test operand left ---> right associativity
    private static boolean hasLeftAssociativity(char cha) {
        if (cha == '+' || cha == '-' || cha == '/' || cha == '*') {
            return true;
        } else {
            return false;
        }
    }

    // Convert infix to postfix
    public static String infToPostf(String expression) {
        // Variables
            // Stack
            Stack<Character> charStack = new Stack<>();

            // Final expression String
            String output = new String("");

        // Iterate through characters in expression
        for (int i = 0; i < expression.length(); ++i) {
            // Find char at index
            char c = expression.charAt(i);

            // Test for operand, if true, add to output
            if (letterOrDigit(c)) {
                output += c;
            } else if (c == '(') {      // Check for brackets and push to stack if true
                charStack.push(c);
            } else if (c == ')') {      // if closing bracket pop and append char until opening bracket is found or end of experession
                while (!charStack.isEmpty() && charStack.peek() != '(') {
                    output += charStack.pop();
                }
                
                charStack.pop();
            } else {        // If operand is found take action based on precedence of operator
                while (!charStack.isEmpty() && getPrecedence(c) <= getPrecedence(charStack.peek()) && hasLeftAssociativity(c)) {
                    output += charStack.pop();
                }

                charStack.push(c);
            }
        }

        // Pop remaining operators to output
        while (!charStack.isEmpty()) {
            if (charStack.peek() == '(') {
                return "This experession is invalid";
            }

            output +=  charStack.pop();
        }

        return output;

    }
    
}