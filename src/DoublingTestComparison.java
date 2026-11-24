public class DoublingTestComparison {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        double timeRPL, timeInfix;
        String[] string;
        for (int i = max; i > 1_000; i /= 2) {
            string = Generator.generateString(i, true);
            Stopwatch swRPL = new Stopwatch();
            for (int j = 0; j < 10_000; j++) {
                RPLCalc.calculate(string[0]);
            }
            timeRPL = swRPL.elapsedTime();

            Stopwatch swInfix = new Stopwatch();
            for (int j = 0; j < 10_000; j++) {
                InfixNotation.calculate(string[1]);
            }
            timeInfix = swInfix.elapsedTime();
            StdOut.printf("%8d Operations \tRPL: %10.2f seconds \tInfix: %10.2f seconds\n", i, timeRPL, timeInfix);
        }
    }
}
