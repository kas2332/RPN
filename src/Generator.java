public class Generator {
    public static void main(String[] args) {
        String[] operations = {"+", "-", "x", "/"};
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int numsLength = nums.length, operationsLength = operations.length;
        int numberOfOperations = Integer.parseInt(args[0]);
        boolean RPL = args[1].equals("true");

        if (RPL) {
            for (int i = 0; i < numberOfOperations; i++) {
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
                StdOut.print(operations[StdRandom.uniformInt(operationsLength - 1)] + " ");
            }
        } else {
            StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
            for (int i = 0; i < numberOfOperations; i++) {
                StdOut.print(operations[StdRandom.uniformInt(operationsLength - 1)] + " ");
                StdOut.print(nums[StdRandom.uniformInt(numsLength - 1)] + " ");
            }
        }


    }
}
