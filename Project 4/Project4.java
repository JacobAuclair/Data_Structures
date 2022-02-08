import java.util.*;

public class Project4
{
    public static void main(String[] args) {
        // build array of 10000 random integers.
        Integer[] test = new Integer[30000];
        // populate array with random Integers.
        Random generator = new Random();
        for (int i = 0; i < test.length; i++)
            test[i] = generator.nextInt();
        // start the String
        String string = "Algorithm\t\tRandom Array (ms)\t\t\"Almost\" Sorted Array";
        // benchmark insertion sort for random array
        Integer[] test1 = test.clone();
        long startTime = System.currentTimeMillis();
        insertionSort(test1, test1.length);////////////////////////////////////////
        long endTime = System.currentTimeMillis();
        string += "Insertion Sort\t\t" + (endTime - startTime) + "\t\t\t\t";
        // benchmark insertion sort for "almost sorted" array
        for (int i = 0; i < test1.length; i += 10)
            test1[i] = generator.nextInt();
        startTime = System.currentTimeMillis();
        insertionSort(test1, test1.length);
        endTime = System.currentTimeMillis();
        string += endTime - startTime + "\n";/////////////////////////////////////
        // benchmark selection sort for random array
        Integer[] test2 = test.clone();
        startTime = System.currentTimeMillis();
        selectionSort(test2, test2.length);
        endTime = System.currentTimeMillis();
        string += "Selection Sort\t\t" + (endTime - startTime) + "\t\t\t\t";
        // benchmark selection sort for "almost sorted" array
        for (int i = 0; i < test2.length; i += 10)
            test2[i] = generator.nextInt();
        startTime = System.currentTimeMillis();
        selectionSort(test2, test2.length);
        endTime = System.currentTimeMillis();
        string += endTime - startTime + "\n";/////////////////////////////////////
        // benchmark merge sort for random array
        Integer[] test3 = test.clone();
        startTime = System.currentTimeMillis();
        mergeSort(test3, test3.length);
        endTime = System.currentTimeMillis();
        string += "Merge Sort\t\t" + (endTime - startTime) + "\t\t\t\t";
        // benchmark merge sort for "almost sorted" array
        for (int i = 0; i < test3.length; i += 10)
            test3[i] = generator.nextInt();
        startTime = System.currentTimeMillis();
        mergeSort(test3, test3.length);
        endTime = System.currentTimeMillis();
        string += endTime - startTime + "\n";
        // benchmark quick sort for random array/////////////////////////////////////////////
        Integer[] test4 = test.clone();
        startTime = System.currentTimeMillis();
        quickSort(test4, 0, test4.length - 1);
        endTime = System.currentTimeMillis();
        string += "Quick Sort\t\t" + (endTime - startTime) + "\t\t\t\t";
        // benchmark quick sort for "almost sorted" array
        for (int i = 0; i < test4.length; i += 10)
            test4[i] = generator.nextInt();
        startTime = System.currentTimeMillis();
        quickSort(test4, 0, test4.length - 1);
        endTime = System.currentTimeMillis();
        string += endTime - startTime + "\n";
        System.out.println(string);
    }

    public static <E extends Comparable<E>> void quickSort(E[] data, int low, int high) {
        if (low < high) {
            E pivot = data[high]; // choose last entry for pivot
            int i = low - 1;
            E temp;
            // partition array and place pivot appropriately
            for (int j = low; j < high; j++) {
                if (data[j].compareTo(pivot) > 0) { // entry is greater than pivot
                    i++;
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
            temp = data[i + 1]; // i + 1 is the location of where pivot should go
            data[i + 1] = pivot;
            data[high] = temp;
            // make recursive calls - remember, pivot index = i + 1
            quickSort(data, low, i);
            quickSort(data, i + 2, high);
        }
    }

    public static <E extends Comparable<E>> void mergeSort(E[] data, int size) {
        if (size < 2) // array is trivially sorted.
            return;
        // divide
        int mid = size/2;
        E[] S1 = Arrays.copyOfRange(data, 0, mid);
        E[] S2 = Arrays.copyOfRange(data, mid, size);
        // conquer
        mergeSort(S1, S1.length);
        mergeSort(S2, S2.length);
        // merge results
        merge(S1, S2, data);
    }

    public static <K extends Comparable<K>> void merge(K[] S1, K[] S2, K[] S) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] data, int size) {
        if (size <= 1)
            return;
        for (int pivot = 1; pivot < size; pivot++) {
            E current = data[pivot];
            int walk = pivot;
            while (walk > 0 && current.compareTo(data[walk - 1]) > 0) {
                data[walk] = data[walk - 1];
                walk--;
            }
            data[walk] = current;
        }
    }

    public static <E extends Comparable<E>> void selectionSort(E[] data, int size) {
        if (size <= 1)
            return;
        for (int i = 0; i < size; i++) {
            int max = i;
            for (int j = i; j < size; j++) {
                if (data[j].compareTo(data[max]) > 0)
                    max = j;
            }
            E temp = data[i];
            data[i] = data[max];
            data[max] = temp;
        }
    }
}