package practice.DaysOfStatistics.SpearmanRankCorrelationCoefficient;

import java.util.Scanner;

public class Solution {
    static double[] getRank(double[] arr) {
        double[] arrRank = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] < arr[j]) arrRank[i]++;
            }
        }
        return arrRank;
    }
    
    static double getSpearmanRankCorrelationCoefficient(double[] a, double[] b) {
        double[] aRank = getRank(a);
        double[] bRank = getRank(b);
        
        return practice.DaysOfStatistics.PearsonCorrelationCoefficient.
                Solution.getPearsonCorrelationCoefficient(aRank, bRank);
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
        System.out.printf("%.3f", getSpearmanRankCorrelationCoefficient(a, b));


    }
}
