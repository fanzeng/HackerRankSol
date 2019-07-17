package practice.thebombermangame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String replaceChar(String s, int pos, char c) {
//        return s.substring(0, pos) + c + s.substring(pos+1);
        char[] cArr = s.toCharArray();
        cArr[pos] = c;
        return new String(cArr);
    }
    
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        int time = 2;
        int r = grid.length;
        int c = grid[0].length();
        int[][] timeSincePlanted = new int[r][c];
        char[][] charGrid = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i].charAt(j) == 'O') {
                    timeSincePlanted[i][j] = time-1;
                    charGrid[i][j] = 'O';
                } else {
                    charGrid[i][j] = '.';
                }
            }
        }
        
        // This is required to satisfy the time limit. 
        // An important realisation here is the the pattern is repetitive w.r.t. time.
        if (n > 6) {
            n = n % 4 + 4;
        }
        
        while(time <= n) {

            System.out.println("time = " + time);
            
            // The problem description didn't make very clear what happens
            // first in even numbered steps.
            // According to the answers, apparently planting happens before detonations.
            
            if (time%2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (charGrid[i][j] == '.') {
//                            grid[i]= replaceChar(grid[i], j, 'O');
                            charGrid[i][j] = 'O';
                            timeSincePlanted[i][j] = -1;
                        }
                    }
                }
            } 
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (charGrid[i][j] == 'O') {
                        timeSincePlanted[i][j]++;
                    } 
                }
            }
            
            // detonate the bombs
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (timeSincePlanted[i][j] == 3) {
//                      grid[i]= replaceChar(grid[i], j, '.');
                        charGrid[i][j] = '.';  
                        if (i > 0) {
//                            grid[i-1]= replaceChar(grid[i-1], j, '.');
                            charGrid[i-1][j] = '.';
                        }
                        if (i < r-1) {
//                            grid[i+1]= replaceChar(grid[i+1], j, '.');
                            charGrid[i+1][j] = '.';
                        }
                        if (j > 0) {
//                            grid[i]= replaceChar(grid[i], j-1, '.');
                            charGrid[i][j-1] = '.';
                        }
                        if (j < c-1) {
//                            grid[i]= replaceChar(grid[i], j+1, '.');
                            charGrid[i][j+1] = '.';
                        }
                    } 
                }
            }
            
            // Clear the timers. Timers needs to be cleared after all the
            // detonations have occured, because the bombs go off simultaneously.
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (charGrid[i][j] == '.') {
                        timeSincePlanted[i][j] = 0;
                    }
                }
            }
            
            // The following is just for printing.
            for (int i = 0; i < r; i++) {
               grid[i] = new String(charGrid[i]);
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(timeSincePlanted[i][j]);
                }
                System.out.println("");
            }
            
            System.out.println("");

            for (int i = 0; i < r; i++) {
                System.out.println(grid[i]);
            }
            System.out.println("");
            // The above is just for printing.
     
            time++;
        }
        
        for (int i = 0; i < r; i++) {
            grid[i] = new String(charGrid[i]);
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
