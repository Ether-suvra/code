package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get array length from user input
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Taking input for array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Insertion Sort
        System.out.println("Insertion Sort Order:");
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)); // Ascending order

        // Bubble Sort
        System.out.println("Bubble Sort Order:");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr)); // Descending order

        // Selection Sort
        System.out.println("Selection Sort Order:");
        selectionSort(arr);
        System.out.println(Arrays.toString(arr)); // Ascending order
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
