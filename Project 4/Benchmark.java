// Jacob Auclair
// CS 253 Project 4
// Benchmarks different sorting algorithms

import java.util.*;

public class Benchmark
{
    public static void main (String args[])
    {
        /////////////////Insertion Sort/////////////////////////////////
        int testarray[] = new int[25000];
        Random rand = new Random();
        for (int i = 0; i < testarray.length; i++){
            testarray[i] = rand.nextInt();
        }
        int[] testarray1 = testarray.clone();
        long start = System.currentTimeMillis();
        for (int x = 1; x < testarray1.length; x++)
        {
            int key = testarray1[x];
            int j = x-1;
            while (j >= 0 && testarray1[j] > key)
            {
                testarray1[j+1] = testarray1[j];
                j = j-1;
            }
            testarray1[j+1] = key;
        }
        long stop = System.currentTimeMillis();
        System.out.println ("Sort Method:\t\tRandom array:\t\tSorted array:\n");
        System.out.println ("Insertion Sort:\t\t"+(stop-start)+"\t\t");
        for (int x = 0; x < testarray1.length; x+=100){
            testarray1[x] = rand.nextInt();
        }
        start = System.currentTimeMillis();
        for (int x = 1; x < testarray1.length; x++)
        {
            int key = testarray1[x];
            int j = x-1;
            while (j >= 0 && testarray1[j] > key)
            {
                testarray1[j+1] = testarray1[j];
                j = j-1;
            }
            testarray1[j+1] = key;
        }
        stop = System.currentTimeMillis();
        System.out.println ((stop-start)+"\n");
        ///////////////Selection Sort/////////////////////////////////////////////
        int[] testarray2 = testarray.clone();
        start = System.currentTimeMillis();
        for (int i = 0; i < testarray2.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < testarray2.length; j++){
                if (testarray2[j] < testarray[min]){
                    min = j;
                }
            }
            int temp = testarray2[min];
            testarray2[min] = testarray2[i];
            testarray2[i] = temp;
        }
        stop = System.currentTimeMillis();
        System.out.println ("Selection Sort:\t\t"+(stop-start)+"\t\t");
        for (int x = 0; x < testarray2.length; x+=100){
            testarray2[x] = rand.nextInt();
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < testarray2.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < testarray2.length; j++){
                if (testarray2[j] < testarray[min]){
                    min = j;
                }
            }
            int temp = testarray2[min];
            testarray2[min] = testarray2[i];
            testarray2[i] = temp;
        }
        stop = System.currentTimeMillis();
        System.out.println ((stop-start)+"\n");
        //////////////Merge sort/////////////////////////////////////////////////
        int[] testarray3 = testarray.clone();
        start = System.currentTimeMillis();
        mergesort(testarray3, 0, testarray3.length-1);
        stop = System.currentTimeMillis();
        System.out.println ("Merge Sort:\t\t"+(stop-start)+"\t\t");
        for (int x = 0; x < testarray3.length; x+=100){
            testarray3[x] = rand.nextInt();
        }
        start = System.currentTimeMillis();
        mergesort(testarray3, 0, testarray3.length-1);
        stop = System.currentTimeMillis();
        System.out.println ((stop-start)+"\n");
        /////////////Quicksort////////////////////////////////////////////
        int[] testarray4 = testarray.clone();
        start = System.currentTimeMillis();
        quicksort(testarray4, 0, testarray4.length-1);
        stop = System.currentTimeMillis();
        System.out.println ("Quick Sort:\t\t"+(stop-start)+"\t\t");
        for (int x = 0; x < testarray4.length; x+=100){
            testarray4[x] = rand.nextInt();
        }
        start = System.currentTimeMillis();
        quicksort(testarray4, 0, testarray4.length-1);
        stop = System.currentTimeMillis();
        System.out.println ((stop-start)+"\n");
    }

    static void quicksort(int testarray4[], int low, int high)
    {
        if (low < high)
        {
            int x = quick(testarray4, low, high);
            quick(testarray4, low, x-1);
            quick(testarray4, x+1, high);
        }
    }
    
    static int quick(int testarray4[], int low, int high)
    {
        int t = testarray4[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (testarray4[j] <= t)
            {
                i++;
                int temp = testarray4[i];
                testarray4[i] = testarray4[j];
                testarray4[j] = temp;
            }
        }
        int temp = testarray4[i+1];
        testarray4[i+1] = testarray4[high];
        testarray4[high] = temp;
        return i+1;
    }

    static void mergesort(int testarray3[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergesort(testarray3, l, m);
            mergesort(testarray3 , m+1, r);
            merge(testarray3, l, m, r);
        }
    }

    static void merge(int testarray3[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i){
            L[i] = testarray3[l + i];
        }
        for (int j=0; j<n2; ++j){
            R[j] = testarray3[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                testarray3[k] = L[i];
                i++;
            }
            else
            {
                testarray3[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            testarray3[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            testarray3[k] = R[j];
            j++;
            k++;
        }
    }
}



    Sort Method:		Random array:		Sorted array:
    Insertion Sort:     141                 2
    Selection Sort:		281			        424
    Merge Sort:		    4			        5
    Quick Sort:		    2   			    1









