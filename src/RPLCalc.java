import java.util.Stack;

public class RPLCalc {
    public static void main(String[] args) {
        //create stack object
        Stack<String> stack = new Stack<>();
        //read input
        String[] line = args[0].split(" ");
        //make an array to hold operations for easy logical comparisons
        final String[] operations = {"+", "-", "*", "/"};
        //loop through each element of the input
        for (String element : line) {
            try {
                //try to push a double; operations will cause an error
                stack.push(String.valueOf(Double.parseDouble(element)));
            } catch (NumberFormatException e) {
                //only takes this branch if attempted to push operation
                for (String s : operations) {
                    //loop through the operations to ensure that the non-number is a valid operation
                    if (s.equals(element)) {
                        try {
                            //put into try for error correction
                            double second = Double.parseDouble(stack.pop());
                            double first = Double.parseDouble(stack.pop());
                            //compare the operation and push the result back onto the stack
                            switch (s) {
                                case "+": {
                                    stack.push(String.valueOf(first + second));
                                    break;
                                }
                                case "-": {
                                    stack.push(String.valueOf(first - second));
                                    break;
                                }
                                case "*": {
                                    stack.push(String.valueOf(first * second));
                                    break;
                                }
                                case "/": {
                                    stack.push(String.valueOf(first / second));
                                    break;
                                }
                            }
                        } catch (NumberFormatException e1) {
                            //error if non number is nonvalid operation
                            System.out.println(e1.getMessage());
                        }
                    }
                }
            }
        }
        //print out the result
        System.out.println(stack.pop());
    }
}
