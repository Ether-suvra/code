package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Implementing Merge Sort...");
        mergesort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array using Merge Sort: " + Arrays.toString(arr));

        System.out.println("Implementing Quick Sort...");
        quicksort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array using Quick Sort: " + Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        mergesort(arr, low, mid); // left half
        mergesort(arr, mid + 1, high); // right half
        merge(arr, low, high, mid); // merging both arrays
    }

    public static void merge(int[] arr, int low, int high, int mid) {
        int[] tempArr = new int[high - low + 1];
        int i = 0; // tempArr index navigator
        int left = low; // left half
        int right = mid + 1; // right half

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempArr[i] = arr[left];
                i++;
                left++;
            } else {
                tempArr[i] = arr[right];
                i++;
                right++;
            }
        }

        while (left <= mid) {
            tempArr[i] = arr[left];
            i++;
            left++;
        }

        while (right <= high) {
            tempArr[i] = arr[right];
            i++;
            right++;
        }

        if (high + 1 - low >= 0) System.arraycopy(tempArr, 0, arr, low, high + 1 - low);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int partitionIndex = partition(arr, low, high);
        quicksort(arr, low, partitionIndex - 1);
        quicksort(arr, partitionIndex + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
