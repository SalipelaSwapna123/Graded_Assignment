import java.util.Arrays;
public class CummulativeMulOfArray {
  
    public static void main(String[] args) {
        int[] arrNum = {5, 3, 4, 2, 0, 8};

        try {
            calculateCumulativeMultiple(arrNum);
            System.out.println("Output: arrNum = " + Arrays.toString(arrNum));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void calculateCumulativeMultiple(int[] arr) {
        int cumulativeMultiple = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cumulativeMultiple = 0; // Reset cumulativeMultiple if the current element is 0
            } else {
                cumulativeMultiple *= arr[i]; // Calculate the cumulative multiple
            }
            arr[i] = cumulativeMultiple; // Update the array element with the cumulative multiple
        }
    }
}
