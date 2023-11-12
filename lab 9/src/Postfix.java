public class Postfix {

    public static double evaluate(String[] expression) throws StackException {
        Stack<String> stack  = new Stack();
        try {

            for (int x = 0; x < expression.length; x++) {
                if (!expression[x].equals("+") && !expression[x].equals("-") && !expression[x].equals("*") && !expression[x].equals("/")) {
                    stack.push(expression[x]);
                } else {
                    double num1 = Double.parseDouble(stack.pop());
                    double num2 = Double.parseDouble(stack.pop());
                    if (expression[x].equals("+")) {
                        stack.push(Double.toString(num1 + num2));
                    }
                    if (expression[x].equals("-")) {
                        stack.push(Double.toString(num2 - num1));
                    }
                    if (expression[x].equals("/")) {
                        stack.push(Double.toString(num2 / num1));
                    }
                    if (expression[x].equals("*")) {
                        stack.push(Double.toString(num1 * num2));
                    }
                }
            }
            return Double.parseDouble(stack.node.getData());
        }
        catch (StackException e){
            System.out.println(e.getSize());

        }
        return 0.0;
    }

}