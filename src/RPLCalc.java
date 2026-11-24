import java.util.Stack;

public class RPLCalc {
    public static String calculate(String expression) {
        //create stack object
        Stack<String> numbers = new Stack<>();

        //read input
        String[] line = expression.split(" ");

        //loop through each element of the input
        for (String element : line) {
            try {

                //try to push a double; operations will cause an error, revert to string
                numbers.push(String.valueOf(Double.parseDouble(element)));
            } catch (NumberFormatException e) {

                //only takes this branch if attempted to push operation
                //only runs if
                if (numbers.size() > 1) {

                    //first pop returns second number since stack is LIFO
                    double second = Double.parseDouble(numbers.pop()), first = Double.parseDouble(numbers.pop());

                    //compare the operation and push the result back onto the numbers
                    switch (element) {
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
        }
        //print out the result
        return numbers.pop();
    }
}