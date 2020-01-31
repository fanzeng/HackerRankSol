package practice.DaysOfStatistics.PearsonCorrelationCoefficient;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static double get_mean(double[] arr) {
        double sum = 0;
        for (double a : arr) {
            sum += a;
        }
        return sum / arr.length;
    }

    static double get_stdev(double[] arr) {
        double sum_sq = 0;
        double mean = get_mean(arr);
        for (double a : arr) {
            sum_sq += Math.pow(a-mean, 2);
        }
        return Math.sqrt(sum_sq / arr.length);
    }
    
    public static double getPearsonCorrelationCoefficient(double[] a, double[] b) {
        double res = 0;
        double mean_a  = get_mean(a);
        double mean_b = get_mean(b);
        double stdev_a = get_stdev(a);
        double stdev_b = get_stdev(b);

        for (int i = 0; i < a.length; i++) {
            res += (a[i] - mean_a)*(b[i] - mean_b);
        }
        res /= a.length*stdev_a*stdev_b;
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] a = new double[N], b = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextFloat();
        }
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextFloat();
        }
        System.out.printf("%.3f", getPearsonCorrelationCoefficient(a, b));
    }
}
