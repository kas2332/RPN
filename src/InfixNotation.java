import java.util.Stack;

public class InfixNotation {
    public static void main(String[] args) {
        //create stack object
        Stack<Double> numbers = new Stack<>();
        Stack<String> ops = new Stack<>();
        //read input
        String[] line = args[0].split(" ");
        //make an array to hold operations for easy logical comparisons
        final String[] operations = {"+", "-", "*", "/"};
        //loop through each element of the input
        for (String element : line) {
            try {
                //try to push a double; operations will cause an error
                numbers.push(Double.parseDouble(element));
            } catch (NumberFormatException e) {
                //only takes this branch if attempted to push operation
                ops.push(element);
            }
            //checks to see if there is at least 2 numbers and an operation
            if ((numbers.size() > 1) && !ops.isEmpty()) {
                String s = ops.pop();
                Double first = numbers.pop(), second = numbers.pop();
                //check which operation to use and push result
                switch (s) {
                    case "+": {
                        numbers.push(first + second);
                        break;
                    }
                    case "-": {
                        numbers.push(first - second);
                        break;
                    }
                    case "*": {
                        numbers.push(first * second);
                        break;
                    }
                    case "/": {
                        numbers.push(first / second);
                        break;
                    }
                }
            }
        }
        //print out the result
        System.out.println(numbers.pop());
    }
}
