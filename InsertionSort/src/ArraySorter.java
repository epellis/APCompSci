
/**
 * Class ArraySorter has an array and can do
 * different sorts on it
 *
 * @author Barb Ericson
 */

public class ArraySorter {
    /// fields ////////////

    /**
     * the array to sort
     */
    private int[] a;

    /**
     * Constructor that takes the array to sort
     *
     * @param theArray the array to sort
     */
    public ArraySorter(int[] theArray) {
        a = theArray;
    }

    /**
     * Get the last valid index in a
     */
    private int getLastIndex() {
        return (a.length - 1);
    }

    /**
     * Method to swap the values at two indices
     * in the array
     *
     * @param i an index in the array
     * @param j another index in the array
     *          i may be equal to j
     */

    private void swap(int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * Method to do a selection sort on the array
     */

    public void selectionSort() {
        int maxCompare = a.length - 1;
        int smallestIndex = 0;
        int numSteps = 0;

        // loop from 0 to one before last item
        for (int i = 0; i < maxCompare; i++) {
            // set smallest index to the one at i
            smallestIndex = i;
            numSteps = 0;

            // loop from i+1 to the end looking for a smaller value
            for (int j = i + 1; j < a.length; j++) {
                numSteps++;
                if (a[j] < a[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            System.out.println("#steps:" + numSteps);

            // swap the one at i with the one at smallest index
            swap(i, smallestIndex);
            this.printArray("after loop body when i = " + i);
        }
    }

    /**
     * Method to do a selection sort on the array
     */
    public void selectionSortLargest() {
        int maxCompare = a.length - 1;
        int largestIndex = 0;
        int numSteps = 0;

        // loop from last to before first
        for (int i = maxCompare; i > 0; i--) {
            // set largest index to the one at i
            largestIndex = i;
            numSteps = 0;

            // loop from i-1 to the front looking for a larger
            for (int j = i - 1; j >= 0; j--) {
                numSteps++;
                if (a[j] > a[largestIndex]) {
                    largestIndex = j;
                }
            }
            System.out.println("#steps:" + numSteps);

            // swap the one at i with the one at largest index
            swap(i, largestIndex);
            this.printArray("after loop body when i = " + i);
        }
    }

    /**
     * Method to test selection sort largest
     */
    public static void testSelectionSortLargest() {
        int[] testArray = {68, 54, 45, 36, 23, 17};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before selection sort with loooking for largest");
        sorter.selectionSortLargest();
        sorter.printArray("After selection sort");
    }

    /**
     * Method to print out the array elements
     *
     * @param message the message to print first
     */
    private void printArray(String message) {
        System.out.println(message);
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    /**
     * Method to test selection sort
     */
    public static void testSelectionSort() {
        int[] testArray = {68, 54, 45, 36, 23, 17};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before selection sort");
        sorter.selectionSort();
        sorter.printArray("After selection sort");
    }

    /**
     * Method to do an insertion sort on the array
     */
    public void insertionSort() {
        int temp = 0;
        int pos = 0;

        // loop from second element on
        for (int i = 1; i < a.length; i++) {
            // save current value at i and set position to i
            temp = a[i];
            pos = i;

            // shift right any larger elements
            while (0 < pos && temp < a[pos - 1]) {
                a[pos] = a[pos - 1];
                pos--;
            }
            a[pos] = temp;
            this.printArray("after loop body when i = " + i);
        }
    }

    public void insertionSort2() {
        int temp = 0;
        int pos = 0;

        // loop from second to end backwards
        for (int i = a.length - 2; i >= 0; i--) {
            // save current value at i and set position to i
            temp = a[i];
            pos = i;

            // shift left any smaller values
            while (pos < a.length - 1 && temp > a[pos + 1]) {
                a[pos] = a[pos + 1];
                pos++;
            }
            a[pos] = temp;
            this.printArray("after loop body when i = " + i);
        }
    }

    /**
     * Method to test insertion sort
     */
    public static void testInsertionSort() {
        int[] testArray = {-3, 8, 25, 6, 15, 2};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before insertion sort");
        sorter.insertionSort();
        sorter.printArray("After insertion sort");
    }

    /**
     * Method to test insertion sort
     */
    public static void testInsertionSort2() {
        int[] testArray = {-32, 6, -5, 18, 55, 3, -80};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before insertion sort");
        sorter.insertionSort2();
        sorter.printArray("After insertion sort");

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
        int[] testArray = {1, 2, 2, 1, 6, 3, 6, 3, 0, 110, 32, 233, 41, 3};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before merge sort");
        sorter.mergeSort(testArray);
        sorter.printArray("After merge sort");
    }

    public void quicksort(int from, int to) {
        System.out.println(" from " + from + " to: " + to);
        // if there are no elements to sort stop
        if (from >= to) return;

        // get the index of the pivot
        int pivotIndex = partition(from, to);

        // do the recursive call on the sub arrays
        quicksort(from, pivotIndex - 1);
        quicksort(pivotIndex + 1, to);
    }

    /**
     * Method to partition the array around a pivot
     * point.
     *
     * @param left  the left index
     * @param right the right index
     * @return the index of the pivot point
     * all element in the array with an index
     * less than the returned index are less
     * than the value at the pivot index and
     * all values in the array with an index
     * the pivot value are to the right of the
     * pivot index
     */

    public int partition(int left, int right) {
        System.out.println("left: " + left + " right: " +
                right);
        // start with pivot at from index
        int pivotIndex = left;
        int pivotValue = a[pivotIndex];

        // put the pivot at the end on right
        swap(pivotIndex, right);

        int storedIndex = left;
        for (int i = left; i <= right - 1; i++) {
            if (a[i] <= pivotValue) {
                swap(storedIndex, i);
                storedIndex++;
            }
        }
        swap(right, storedIndex);
        return storedIndex;
    }

    public static void testQuicksort() {
        int[] testArray = {23, 14, 1, 89, 68, 32, 6};

        ArraySorter sorter = new ArraySorter(testArray);
        sorter.printArray("Before quicksort");
        sorter.quicksort(0, sorter.getLastIndex());
        sorter.printArray("After quicksort");
    }

    public static void main(String[] args) {
        testSelectionSortLargest();
        //testInsertionSort();
        //testInsertionSort2();
        testMergeSort();
        //testQuicksort();
    }
}