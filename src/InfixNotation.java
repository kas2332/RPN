import java.util.Stack;

public class InfixNotation {
    public static String calculate(String expression) {
        //create stack object
        Stack<String> numbers = new Stack<>();
        Stack<String> ops = new Stack<>();
        //read input
        String[] line = expression.split(" ");
        //make an array to hold operations for easy logical comparisons
        final String[] operations = {"+", "-", "*", "/"};
        //loop through each element of the input
        for (String element : line) {
            try {
                //try to push a double; operations will cause an error
                numbers.push(String.valueOf(Double.parseDouble(element)));
            } catch (NumberFormatException e) {
                //only takes this branch if attempted to push operation
                ops.push(element);
            }
            //checks to see if there is at least 2 numbers and an operation
            if ((numbers.size() > 1) && !ops.isEmpty()) {
                String s = ops.pop();
                Double second = Double.parseDouble(numbers.pop()), first = Double.parseDouble(numbers.pop());
                //check which operation to use and push result
                switch (s) {
                    case "+": {
                        numbers.push(String.valueOf(first + second));
                        break;
                    }
                    case "-": {
                        numbers.push(String.valueOf(first - second));
                        break;
                    }
                    case "*": {
                        numbers.push(String.valueOf(first * second));
                        break;
                    }
                    case "/": {
                        if (second == 0) {
                            second ++;
                        }
                        numbers.push(String.valueOf(first / second));
                        break;
                    }
                }
            }
        }
        //print out the result
        return numbers.pop();
    }
}
