package practice.almostsorted;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        String ans = "";
        // check swap case
        int big = 0, small = 0;
        boolean bigFound = false, bigResolved = false, sorted = false;
        for (int i = 0; i < arr.length; i++) {
            if (bigFound) {
                if (i+1 < arr.length && arr[i] > arr[i+1]) {
                    i++;
                    if ( (arr[i-1] < arr[big] && (i + 1 >= arr.length || arr[big] < arr[i+1])) &&
                         ((big == 0 || arr[big - 1] < arr[i]) && arr[i] < arr[big + 1]) ) {
                        small = i;
                        bigResolved = true;
                    } else {
                        break;
                    }
                }

            } else {
                if (i + 1 < arr.length && arr[i] > arr[i+1]) {
                    if (bigResolved) {
                        break;
                    } else {
                        big = i;
                        bigFound = true;
                    }
                }
            }
            if ( (!bigFound || (bigFound && bigResolved)) && (i + 1 == arr.length)) {
                sorted = true;
                ans = "yes" + (bigFound ? ("\nswap " + Integer.toString(++big) + " " + Integer.toString(++small)) : "");
            }
        }
        
        if ( ! sorted) {
            // check reverse case
            int l = 0, r = 0;
            boolean revStart = false, revEnd = false;
            int rOrig = -1;
            boolean replaced = false;
            for (int i = 0; i < arr.length; i++) {
                if (revStart) {
                    if (!revEnd && (i + 1 == arr.length || arr[i] < arr[i+1]) ) {
                        r = i;
                        rOrig = arr[r];
                        arr[r] = arr[l];
                        replaced = true;
                        revEnd = true;
                    } else if (revEnd && (arr[i-1] > arr[i] || ( l > 0 && rOrig < arr[l-1]))) {
                        ans = "no";
                        break;
                    }

                } else {
                   if (arr[i] > arr[i + 1]) {
                        revStart = true;
                        l = i;
                    }
                }
            }
            if (replaced) arr[r] = rOrig;
            l++;
            r++;
            if (ans.length() == 0) {
                if (r - l == 1) {
                    ans = "yes\nswap " + l + " " + r;
                } else {
                    ans = "yes\nreverse " + l + " " + r;
                }

            }
        }

        System.out.println(ans);
        try {
            PrintWriter out = new PrintWriter(System.getenv("OUTPUT_PATH"));
            out.println(ans);
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
