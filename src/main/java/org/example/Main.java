package org.example;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];
        // taking array inputs
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        selectionSort(arr);
       // printing the array
        System.out.println("After selection sort:");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the largest element with the current element
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    }

