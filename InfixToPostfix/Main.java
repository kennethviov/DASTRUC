public class Main {
    public static void main(String[] args) {
        String infix = "6+8*7/5*8+4/6-4*7";

        System.out.println(toPostfix(infix));
        
        System.out.println(evalPostfix(toPostfix(infix)));
    }

    static String toPostfix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            if (isOperand(infix.charAt(i))) {
                postfix = postfix + infix.charAt(i);
            } else if (isOperator(infix.charAt(i))) {
                while (!stack.isEmpty() && 
                       comparePrecedence(stack.peek(), infix.charAt(i)) != 2) {
                    postfix = postfix + stack.pop();
                }
                stack.push(infix.charAt(i));
            }
        }
        int limit = stack.getCount();
        for (int i = 0; i < limit; i++) {
            postfix = postfix + stack.pop();
        }
        return postfix;
    }

    static double evalPostfix(String postfix) {
        Stack<Double> operands = new Stack<Double>();
        
        for (int i = 0; i < postfix.length(); i++) {
            if (isOperand(postfix.charAt(i))) {
                operands.push((double)Character.getNumericValue(postfix.charAt(i)));
            } else if (isOperator(postfix.charAt(i))) {
                double op2 = operands.pop();
                double op1 = operands.pop();
                if        (postfix.charAt(i) == '/') {
                    operands.push(op1 / op2);
                } else if (postfix.charAt(i) == '*') {
                    operands.push(op1 * op2);
                } else if (postfix.charAt(i) == '+') {
                    operands.push(op1 + op2);
                } else if (postfix.charAt(i) == '-') {
                    operands.push(op1 - op2);
                }
            }
        }

        return operands.peek();
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private static boolean isOperand(char c) {
        return c >= '0' && c <= '9';
    }

    private static int comparePrecedence(char c1, char c2) {
        int op1 = getPrecedence(c1);
        int op2 = getPrecedence(c2);

        if (op1 > op2)
            return 1;  // op1 has higher percedence
        else if (op1 < op2)
            return 2; // op2 has higher precedence
        else
            return 0; // equal precedence
    }

    private static int getPrecedence(char c) {
        switch (c) {
            case '*': case '/':
                return 2; // highest precedence
            case '+': case '-':
                return 1; // lowest precedence
            default:
                return 0;
        }
    }
}
