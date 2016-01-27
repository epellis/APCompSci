import java.util.Arrays;

public class MergeSorter {

    private int[] a;

    public MergeSorter(int[] theArray) {
        a = theArray;
    }

    private void printArray(String message) {
        System.out.println(message);
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static int[] mergeSort(int[] arrg){

        // Create the base case for the merge
        if  (arrg.length <= 1) {
            return arrg;
        }

        // Split the array into two parts
        int left[] = new int [arrg.length/2];
        int right[] = new int [arrg.length - left.length];

        // Copy the original array to the new array
        System.arraycopy(arrg, 0, left, 0, left.length);
        System.arraycopy(arrg, left.length, right, 0, right.length);

        // Recurse until you reach the base case
        left = mergeSort(left);
        right = mergeSort(right);

        arrg = merge(left, right, arrg);

        return arrg;
    }

    public static int[] merge(int[] left, int[] right, int[] result){
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex] < right[rightIndex]) {
                result[resIndex] = left[leftIndex];
                leftIndex++;
            }
            else {
                result[resIndex] = right[rightIndex];
                rightIndex++;
            }
            resIndex++;

        }

        while (leftIndex < left.length){
            result[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }

        while (rightIndex < right.length){
            result[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }

        return result;
    }

    public static void testMergeSort() {
        int[] testArray = {4, 2};

        MergeSorter sorter = new MergeSorter(testArray);
        sorter.printArray("Before merge sort");
        sorter.mergeSort(testArray);
        sorter.printArray("After merge sort");
    }

    public static void main(String[] args) {
        testMergeSort();
    }
}