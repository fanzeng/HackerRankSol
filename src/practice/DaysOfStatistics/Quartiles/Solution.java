package practice.DaysOfStatistics.Quartiles;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int getMedian(int[] arr, int N) {
        return (int)(N % 2 == 0 ? 0.5*(arr[N/2] + arr[N/2-1]) : arr[N/2]);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            arr[i] = val;
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        double median = getMedian(arr, N);
        double firstQuartile = getMedian(Arrays.copyOfRange(arr, 0, N/2), N/2);
        double thirdQuartile = getMedian(Arrays.copyOfRange(arr, (N%2==0?N/2:N/2+1), N-1), N/2);
        System.out.println((int)firstQuartile);
        System.out.println((int)median);
        System.out.print((int)thirdQuartile);
    }
}

