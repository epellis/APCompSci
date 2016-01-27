import java.util.*;

public class MergeSorterTwo {
    public static void main(String[] args) {

        int arrg[] = new int [2000000];

        // Setup Arrays and print initial array
        populate(arrg);
        System.out.print("Before Sorting: ");
        System.out.println(Arrays.toString(arrg));
        long startTime = System.nanoTime();

        mergeSort(arrg);

        System.out.print("After Sorting: ");
        System.out.println(Arrays.toString(arrg));
        long endTime = System.nanoTime();
        System.out.println("");
        long totalTime = (endTime - startTime);
        System.out.println("Sort Duration: "+totalTime+" nanoseconds");
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

    public static void populate(int[] arrg){
        for (int i = 0; i < arrg.length; i++){
            arrg[i] = (int)(Math.random() * 100);
        }
    }
}