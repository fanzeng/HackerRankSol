package practice.DaysOfStatistics.MultipleLinearRegression;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import common.matrix.*;

public class Solution {
    public double[] leastSquaresFit(double[][] x_in, double[] y_in) {
        Matrix x = new Matrix(x_in);
        double[][] y_arr = new double[y_in.length][1];
        for (int i = 0; i < y_in.length; i++) {
            y_arr[i][0] = y_in[i];
        }
        
        Matrix y = new Matrix(y_arr);
        Matrix xtx = x.transpose().mul(x);
        Matrix beta;
        double[] beta1D = new double[x_in.length];

        try {
            beta = xtx.inv().mul(x.transpose().mul(y));
//            System.out.print("beta=" + beta);
            beta1D = beta.toArray1D();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        
        return beta1D;
    }
    public double[] leastSquaresEstimate(double[][] x_in, double[] beta_in) {
        Matrix x = new Matrix(x_in);
        double[][] beta_arr = new double[beta_in.length][1];
        for (int i = 0; i < beta_in.length; i++) {
            beta_arr[i][0] = beta_in[i];
        }
        Matrix beta = new Matrix(beta_arr);
        Matrix y = x.mul(beta);
        double[] y_arr = new double[beta_in.length];
        try{
            y_arr = y.toArray1D();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        return y_arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        double[][] x = new double[n][m+1];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            x[i][0] = 1;
            for (int j = 1; j < m+1; j++) {
                x[i][j] = sc.nextDouble();
            }
            y[i] = sc.nextDouble();
        }
        int q = sc.nextInt();
        double[][] xq = new double[q][m+1];
        for (int i = 0; i < q; i++) {
            xq[i][0] = 1;
            for (int j = 1; j < m+1; j++) {
                xq[i][j] = sc.nextDouble();
            }
        }
        Solution s = new Solution();
        double[] beta = s.leastSquaresFit(x, y);
        double[] yq = s.leastSquaresEstimate(xq, beta);
        for (int i = 0; i < yq.length; i++) {
            System.out.printf("%.2f\n", yq[i]);
        }
    }
}

