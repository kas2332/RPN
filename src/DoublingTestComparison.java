public class DoublingTestComparison {
    public static void main(String[] args) {

        //start at max, half until some specified min number of operations
        //max seems decent around 10_000
        //at 100_000, takes very long time
        //a bit too fast at 1_000
        //concern is primarily how long Generator.generateString takes
        int max = Integer.parseInt(args[0]);

        //create vars
        double timeRPL, timeInfix;
        String[] string;

        //create expression with max operations
        //each loop, create expression with half as many operations
        for (int i = max; i > 1_000; i /= 2) {

            //create the expression
            string = Generator.generateString(i);

            //start with RPL
            //start the stopwatch
            Stopwatch swRPL = new Stopwatch();

            //loop is to increase time for the calculator
            //increasing max makes Generator.generateString take too long
            //10_000 is good here, normally takes about a minute
            //< 10_000 is a bit too fast, harder to see time differences
            for (int j = 0; j < 10_000; j++) {
                RPLCalc.calculate(string[0]);
            }
            timeRPL = swRPL.elapsedTime();

            //repeat process with Infix
            Stopwatch swInfix = new Stopwatch();
            for (int j = 0; j < 10_000; j++) {
                InfixNotation.calculate(string[1]);
            }
            timeInfix = swInfix.elapsedTime();

            //print results
            StdOut.printf("%8d Operations \tRPL: %10.2f seconds \tInfix: %10.2f seconds\n", i, timeRPL, timeInfix);
        }
    }
}
