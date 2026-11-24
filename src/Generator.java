public class Generator {
    public static String[] generateString(int numberOfOperations) {
        //define possible entries
        String[] operations = {"+", "-", "*", "/"};
        Double[] nums = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0,};

        //specific vars to help avoid cost of fining lengths of arrays
        int numsLength = nums.length, operationsLength = operations.length;

        //prepare array to hold expressions
        //0 is RPL; 1 is Infix
        String[] result = new String[2];
        result[0] = "";
        result[1] = "";


        //adds out one random number to start expression
        double num1 = nums[StdRandom.uniformInt(numsLength)];
        result[0] += num1 + " ";
        result[1] += num1 + " ";

        //adds to each expression
        //0 = RPL in format "number " + "number operation "
        //1 = Infix in format "number " + "operation number "
        for (int i = 0; i < numberOfOperations; i++) {
            double num2 = nums[StdRandom.uniformInt(numsLength)];
            String op = operations[StdRandom.uniformInt(operationsLength)];
            result[0] += num2 + " " + op + " ";
            result[1] += op + " " + num2 + " ";
        }
        //returns same expression in two formats
        return result;
    }
}
