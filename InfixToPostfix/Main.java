import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String infix = validString("Enter an infix expression: ", scan);

        System.out.println(infixToPostfix(infix));
        
    }

    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>(null);
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            if (isOperand(infix.charAt(i))) {
                postfix = postfix + infix.charAt(i);
            } else if (isOperator(infix.charAt(i))) {
                if (stack.head == null || comparePrecedence(stack, infix.charAt(i)) == 2) {
                    stack.push(infix.charAt(i));
                } else if (comparePrecedence(stack, infix.charAt(i)) == 0 || 
                           comparePrecedence(stack, infix.charAt(i)) == 1) {
                    postfix = postfix + stack.pop();
                    stack.push(infix.charAt(i));
                } 
            }
        }

        for (int i = 0; i < stack.getCount(); i++) {
            postfix = postfix + stack.pop();
        }
        return postfix;
    }

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    static boolean isOperand(char c) {
        return c >= '0' && c <= '9';
    }

    static int comparePrecedence(Stack<Character> stack, char c) {
        int op1 = getPrecedence(stack.peek());
        int op2 = getPrecedence(c);

        if (op1 > op2)
            return 1;  // op1 has higher percedence
        else if (op1 < op2) {
            return 2; // op2 has higher precedence
        } else 
            return 0;
    }

    private static int getPrecedence(char c) {
        switch (c) {
            case '*':
            case '/':
                return 2; // highest precedence
            case '+':
            case '-':
                return 1; // lowest precedence
            default:
                return 0;
        }
    }

    static String validString(String prompt, Scanner scan) {
        String str = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(prompt);
                str = scan.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.err.println("Error! Input should be a string");
            }
        }

        return str;
    }
}
