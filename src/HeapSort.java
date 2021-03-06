/**
 * This Class Sorts an Array with the Heap Sort Algorithm and returns the values to the Interface Algorithm
 * The HeapSort is not a stable Algorithm
 *
 * @author Philip Jovanovic
 * @version 2.0
 * @since 2021-01-17
 */

public class HeapSort extends Algorithm {
    private long time = 0,
                 storage = 0,
                 comparisons = 0,
                 arrayAccess = 0;

    /**
     * Method sorts array and switches the values in array
     * @param array is inherited from Algorithm with extends
     */
    public void sort(int array[]) {
        int number = array.length;
        storage = number * 32 + 3 * 32;
        long start = System.nanoTime();

        for (int i = number / 2 - 1; i >= 0; i--) {
            heap(array, number, i);
        }

        for (int i = number - 1; i > 0; i--) {
            arrayAccess += 3;
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }

        long end = System.nanoTime();
        time = (long) (end - start);
    }

    /**
     * @param array
     * @param n
     * @param i     checks the values in the array and swaps them correctly
     */
    void heap(int array[], int n, int i) {
        int biggest = i,
            left = 2 * i + 1,
            right = 2 * i + 2;

        storage += 128;
        comparisons++;

        if (left < n && array[left] > array[biggest]) {
            biggest = left;
        }

        comparisons++;

        if (right < n && array[right] > array[biggest]) {
            biggest = right;
        }

        if (biggest != i) {
            arrayAccess += 3;
            int swap = array[i];
            array[i] = array[biggest];
            array[biggest] = swap;
            heap(array, n, biggest);
        }
    }

    /**
     * The value time evaluates the time, that is taken, in order to sort the array.
     * The value in time is then returned through the method getTime to its superclass Algorithm.
     */
    @Override
    public long getTime() {
        return time;
    }

    /**
     * @return The comparisons that the Algorithm made in the array, for example is 1 > 2.
     */
    @Override
    public long getComparison() {
        return comparisons;
    }

    /**
     * @return The times the array was accessed through the Methods
     */
    @Override
    public long getArrayAccess() {
        return arrayAccess;
    }

    /**
     * @return The amount of storage that has been used for this algorithm.
     */
    @Override
    public long getStorage() {
        return storage;
    }
}
