package practice.twopluses;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int getArea(int size) {
        if (size == 0) return 0;
        return (size-1)*4 + 1;
    }
    
    static boolean isOverlap(int x1, int y1, int size1, int x2, int y2, int size2, int r, int c) {
        int[][] grid = new int[r][c];
        grid[x1][y1] = 1;
        size1--;
        size2--;
        while(size1 >= 0) {
            grid[x1-size1][y1] = 1;
            grid[x1+size1][y1] = 1;
            grid[x1][y1-size1] = 1;
            grid[x1][y1+size1] = 1;
            size1--;
        }
        if (grid[x2][y2] != 0) return true;
        while(size2 >= 0) {
            if (grid[x2-size2][y2] != 0) return true;
            if (grid[x2+size2][y2] != 0) return true;
            if (grid[x2][y2-size2] != 0) return true;
            if (grid[x2][y2+size2] != 0) return true;
            size2--;
        }
        return false;
    }    
    
    static int getMaxProd(int[][] intGrid, int x, int y) {
        int r = intGrid.length;
        int c = intGrid[0].length;
        int maxArea2 = 0;
        int size1 = intGrid[x][y];
        int area1 = getArea(size1);
        int area2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int size2 = intGrid[i][j];
                if (isOverlap(x, y, size1, i, j, size2, r, c)) continue;
                area2 = getArea(intGrid[i][j]);
//                System.out.println("x=" + x + ", y=" + y + ", i=" + i + ", j=" + j + ", area2=" + area2);
                if (area2 > maxArea2) {
                    maxArea2 = area2;
                }
            }
        }
        return area1*maxArea2;
    }
        
    static int getMaxPlus(char[][] charGrid, int i, int j) {
        if (charGrid[i][j] == 'B') return 0;
        int size = 1;
        int r = charGrid.length;
        int c = charGrid[0].length;
        
        while(true) {
            if ((i-size >= 0 && charGrid[i-size][j] == 'G') &&
                (i+size < r  && charGrid[i+size][j] == 'G') &&
                (j-size >= 0 && charGrid[i][j-size] == 'G') &&
                (j+size < c && charGrid[i][j+size] == 'G')) {
              size++;
            } else {
                break;
            }
        }
        return size;
    }
        
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        char[][] charGrid = new char[r][c];
        int[][] maxPlusSize = new int[r][c];
        
        for (int i = 0; i < grid.length; i++) {
            charGrid[i] = grid[i].toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxPlusSize[i][j] = getMaxPlus(charGrid, i, j);
//                System.out.print(maxPlusSize[i][j]);
            }
//            System.out.print("\n");
        }
        int maxProd = 0;
        for (int i = 0; i <= r/2; i++) {
            for (int j = 0; j <= c/2; j++) {
                int maxArea = getMaxProd(maxPlusSize, i, j);
//                System.out.println("i="  + i + ", j=" + j + ", maxArea=" + maxArea);
                if (maxArea > maxProd) maxProd = maxArea;
            }
        }
        return maxProd;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
