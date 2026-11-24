import java.util.Stack;

public class InfixNotation {
    public static String calculate(String expression) {
        //create stack object
        Stack<String> numbers = new Stack<>();
        Stack<String> ops = new Stack<>();

        //read input
        String[] line = expression.split(" ");

        //loop through each element of the input
        //this
        for (String element : line) {
            try {

                //try to push a double; operations will cause an error, revert back to string to add to stack
                numbers.push(String.valueOf(Double.parseDouble(element)));
            } catch (NumberFormatException e) {

                //only takes this branch if attempted to push operation
                //push to operation stack instead
                ops.push(element);
            }

            //checks to see if there is at least 2 numbers
            if (numbers.size() > 1) {
                //gets the three values: 2 numbers and 1 operation
                //first pop returns second number since stack is LIFO
                Double second = Double.parseDouble(numbers.pop()), first = Double.parseDouble(numbers.pop());
                String s = ops.pop();

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
                        //prevent divide by 0 by essentially ignoring the operation
                        if (second == 0) {
                            second++;
                        }
                        numbers.push(String.valueOf(first / second));
                        break;
                    }
                }
            }
        }
        //return the result
        return numbers.pop();
    }
}