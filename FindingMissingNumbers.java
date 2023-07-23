import java.util.ArrayList;
import java.util.List;

public class FindingMissingNumbers {
    public static void main(String[] args) {
        int[] arrNum1 = {1, 2, 4, 5, 6};
        int[] arrNum2 = {1, 2, 3, 5, 6, 8, 10, 11, 14};

        System.out.println("Output 1: " + findMissingNumbers(arrNum1));
        System.out.println("Output 2: " + findMissingNumbers(arrNum2));
    }

    public static List<Integer> findMissingNumbers(int[] arr) {
        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i] - 1;
            if (diff > 0) {
                for (int j = 1; j <= diff; j++) {
                    missingNumbers.add(arr[i] + j);
                }
            }
        }

        return missingNumbers;
    }
}

    

