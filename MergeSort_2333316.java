import java.util.Arrays;
import java.util.Scanner;

class MergeSort_2333316 {

    // get input from the user
    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // get output of the program
    public static void getOutput(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // mergeing two sorted arrays
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }

    // method to sort the array using merge sort
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] array = getInput();
        // Sort the array using merge sort
        array = mergeSort(array);
        // Display the sorted array
        getOutput(array);
    }
}