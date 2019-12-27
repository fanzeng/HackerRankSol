package practice.DaysOfCode.BitwiseAnd;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    static int maxAAndB(int n, int k) {
        int max = 0;
        for (int A = 1; A <= n; A++) {
            for (int B = 1; B < A; B++) {
                int bitwiseAnd = A & B;
                if (bitwiseAnd > max && bitwiseAnd < k) {
                    max = bitwiseAnd;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            System.out.println(maxAAndB(n, k));

        }
        scanner.close();
    }
}
