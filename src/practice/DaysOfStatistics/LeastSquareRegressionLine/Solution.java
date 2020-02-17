package practice.DaysOfStatistics.LeastSquareRegressionLine;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import common.matrix.*;

public class Solution {
    public static double[] leastSquareRegressionSimpleFit(
            ArrayList<Double> x_in,
            ArrayList<Double> y_in
    ) {
        Matrix x = new Matrix(x_in.size(), 2);
        Matrix y = new Matrix(y_in.size(), 1);
        for (int i = 0; i < x.rows; i++) {
            x.arr()[i][0] = 1;
            x.arr()[i][1] = x_in.get(i);
        }

        for (int i = 0; i < y.rows; i++) {
            y.arr()[i][0] = y_in.get(i);
        }
        Matrix xtx = x.transpose().mul(x);
        Matrix beta = new Matrix(y_in.size(), 1);
        try {
            beta = xtx.inv().mul(x.transpose().mul(y));
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return new double[] { beta.arr()[0][0], beta.arr()[1][0] };
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();

        while(sc.hasNextLine()) {
            x.add(sc.nextDouble());
            y.add(sc.nextDouble());
        }
        double[] beta = leastSquareRegressionSimpleFit(x, y);
//        System.out.println("beta = " + beta[0] + ", " + beta[1]);
        System.out.printf("%.3f", beta[0] + 80*beta[1]);
    }
}

