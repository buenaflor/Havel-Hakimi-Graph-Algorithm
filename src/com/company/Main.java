package com.company;

import java.util.Arrays;

public class Main {

    // Remove zeroes from array
    private static int[] removeZeroes(int[] arr) {
        if (arr.length == 0)
            return arr;

        int newArrLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArrLen += 1;
            }
        }
        int[] newArr = new int[newArrLen];
        int newArrIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArr[newArrIdx] = arr[i];
                newArrIdx += 1;
            }
        }
        return newArr;
    }

    // Descending sort of array
    // I choose Selection Sort
    private static int[] sortDescending(int[] arr) {
        if (arr.length <= 1)
            return arr;

        int[] sortedArr = arr.clone();
        for (int i = 0; i < sortedArr.length; i++) {
            for (int j = i; j < sortedArr.length; j++) {
                if (sortedArr[i] < sortedArr[j]) {
                    swap(sortedArr, i, j);
                }
            }
        }
        return sortedArr;
    }

    // Front elimination
    // Subtract -1 of first n elements of arr
    private static int[] frontElimination(int[] arr, int n) {
        int[] newArr = arr.clone();
        for (int i = 0; i < n; i++) {
            newArr[i] -= 1;
        }
        return newArr;
    }

    // Helper function that swaps the position of two elements in an array
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    ////////////////////////////
    // HAVEL HAKIMI ALGORITHM //
    ////////////////////////////

    // Returns true if it's possible that everyone is telling the truth
    private static boolean havelHakimi(int[] arr) {
        int[] removedZeroesArr = removeZeroes(arr);
        if (removedZeroesArr.length == 0)
            return true;

        int[] sortedArr = sortDescending(removedZeroesArr);
        int[] sortedRangedArr = Arrays.copyOfRange(sortedArr, 1, sortedArr.length);
        int n = sortedArr[0];

        if (n > sortedRangedArr.length)
            return false;

        return havelHakimi(frontElimination(sortedRangedArr, n));
    }

    public static void main(String[] args) {
        int[] arr1 = removeZeroes((new int[] { 5, 3, 0, 2, 6, 2, 0, 7, 2, 5 }));
        int[] arr2 = removeZeroes((new int[] { 4, 0, 0, 1, 3 }));
        int[] arr3 = removeZeroes((new int[] { 1, 2, 3 }));
        int[] arr4 = removeZeroes((new int[] { 0, 0, 0 }));

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        int[] sortedArr1 = sortDescending(new int[] { 1, 5, 2, 4, 4, 3, 1 });
        int[] sortedArr2 = sortDescending(new int[] { 0, 0, 4, 0 });
        int[] sortedArr3 = sortDescending(new int[] { 1 });

        System.out.println(Arrays.toString(sortedArr1));
        System.out.println(Arrays.toString(sortedArr2));
        System.out.println(Arrays.toString(sortedArr3));

        int[] frontElimArr1 = frontElimination(new int[] { 5, 4, 3, 2, 1 }, 4);
        int[] frontElimArr2 = frontElimination(new int[] { 14, 13, 13, 13, 12, 10, 8, 8, 7, 7, 6, 6, 4, 4, 2 }, 11);

        System.out.println(Arrays.toString(frontElimArr1));
        System.out.println(Arrays.toString(frontElimArr2));

        int[] havelHakimiArr1 = new int[] { 16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16 };
        int[] havelHakimiArr2 = new int[] { 5, 3, 0, 2, 6, 2, 0, 7, 2, 5 };

        System.out.println(havelHakimi(havelHakimiArr1));
        System.out.println(havelHakimi(havelHakimiArr2));
    }
}
