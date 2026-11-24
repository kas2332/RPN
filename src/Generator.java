public class Generator {
    public static String[] generateString(int numberOfOperations, boolean RPL) {
        //define possible entries
        String[] operations = {"+", "-", "*", "/"};
        Double[] nums = {1.0, 2.0, 3.0, 4.0};
        //specific var
        int numsLength = nums.length, operationsLength = operations.length;
        String[] result = new String[2];
        result[0] = "";
        result[1] = "";


        //prints out two random numbers followed by a random operation
        double num1 = nums[StdRandom.uniformInt(numsLength)];
        result[0] += num1 + " ";
        result[1] += num1 + " ";
        for (int i = 0; i < numberOfOperations; i++) {
            double num2 = nums[StdRandom.uniformInt(numsLength)];
            String op = operations[StdRandom.uniformInt(operationsLength)];
            result[0] += num2 + " " + op + " ";
            result[1] += op + " " + num2 + " ";
        }
        return result;
    }
}
