public class Generator {
    public static void main(String[] args) {
        //define possible entries
        String[] operations = {"+", "-", "x", "/"};
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //specific var
        int numsLength = nums.length, operationsLength = operations.length;
        int numberOfOperations = Integer.parseInt(args[0]);
        //boolean for RPL or infix
        boolean RPL = args[1].equals("true");

        if (RPL) {
            //prints out two random numbers followed by a random operation
            for (int i = 0; i < numberOfOperations; i++) {
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
                StdOut.print(operations[StdRandom.uniformInt(operationsLength - 1)] + " ");
            }
        } else {
            //prints out a number to start expression
            StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
            //prints out an operation and number
            for (int i = 0; i < numberOfOperations; i++) {
                StdOut.print(operations[StdRandom.uniformInt(operationsLength - 1)] + " ");
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
            }
        }


    }
}
