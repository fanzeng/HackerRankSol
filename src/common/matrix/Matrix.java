package common.matrix;

public class Matrix {
    double[][] arr;
    public int rows, cols;
    
    public Matrix(double[][] a) {
        arr = a;
        rows = a.length;
        cols = a[0].length;
    }
    
    public Matrix(int _rows, int _cols) {
        arr = new double[_rows][_cols];
        rows = _rows;
        cols = _cols;
    }
    public Matrix transpose() {
        Matrix t = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.arr[j][i] = arr[i][j];
            }
        }
        return t;
    }
    public Matrix minor(int i, int j) throws Exception {
        if (rows < 2 || cols < 2) {
            throw new Exception(
                "cannot take minor for matrix of size "
                 + rows + "x" + cols + "."
            );
        }
        Matrix minor = new Matrix(rows-1, cols-1);
        int kSkip = 0;
        int lSkip;
        
        for (int k = 0; k < minor.rows; k++) {
            if (k >= i) {
                kSkip = 1;
            }
            lSkip = 0;
            for (int l = 0; l < minor.cols; l++) {
                if (l == j) {
                    lSkip = 1;
                } 
                minor.arr[k][l] = arr[k+kSkip][l+lSkip];
            }
        }
        return minor;
    }
    
    public double det() throws Exception {
        if (rows != cols) {
            throw new Exception("cannot take det for non-square matrix.");
        }
        if (rows == 1) {
            return arr[0][0];
        }
        double d = 0;
        int coefficient;

        for (int j = 0; j < cols; j++) {
            Matrix minor = minor(0, j);
            if (j % 2 == 1) {
                coefficient = -1;
            } else {
                coefficient = 1;
            }
            d += coefficient*arr[0][j]*minor.det();
        }
        return d;
    }
    
    public Matrix block(int r0, int r1, int c0, int c1) throws Exception {
        int new_rows = r1 - r0;
        int new_cols = c1 - c0;
        if(new_rows <= 0 || new_cols <= 0) {
            throw new Exception("invalid block size.");
        }
        Matrix b = new Matrix(new_rows, new_cols);
        for (int i = 0; i < b.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                b.arr[i][j] = arr[r0+i][c0+j];
            }
        }
        return b;
    }
    
    public Matrix adjugate() throws Exception {
        return cofactor().transpose();
    }
    
    public Matrix cofactor() throws Exception {
        Matrix cof = new Matrix(rows, cols);
        for (int i = 0; i < cof.rows; i++) {
            for (int j = 0; j < cof.cols; j++) {
            int coefficient;
            if ((i+j) % 2 == 1) {
                coefficient = -1;
            } else {
                coefficient = 1;
            }
                cof.arr[i][j] = coefficient*minor(i, j).det();
            }
        }
        return cof;
    }
    
    public Matrix inv() throws Exception {
        double det = det();
        if (det == 0) {
            throw new Exception("not invertable, det = 0.");
        }
        return adjugate().scale(1./det());
    }
    
    public Matrix mul(Matrix other) {
        Matrix p = new Matrix(rows, other.cols);
        for (int i = 0; i < p.rows; i++) {
            for (int j = 0; j < p.cols; j++) {
                p.arr[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    p.arr[i][j] += arr[i][k]*other.arr[k][j];
                }
            }
        }
        return p;
    }
    
    public Matrix scale(double d) {
        Matrix s = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s.arr[i][j] = arr[i][j]*d;
            }
        }
        return s;
    }
    
    public double[][] toArray() {
        return arr;
    }
    
    public double[][] arr() {
        return arr;
    }
    
    // convert vector to 1d array
    public double[] toArray1D() throws Exception {
        double[] arr1D;

        if (rows == 1) {
            arr1D = arr[0];
        } else if (cols == 1) {
            arr1D = new double[rows];
            for (int i = 0; i < rows; i++) {
                arr1D[i] = arr[i][0];
            }
        } else {
            throw new Exception(
                "only 1d vectors can be converted to 1d array."
                + "size of matrix = " + rows + "x" + cols + "."
            );
        }
        return arr1D;
    }
    
    @Override
    public String toString() {
        String s = "\n[\t";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s += Double.toString(arr[i][j]) + "\t";
            }
            s += "\n\t";
        }
        s += "]";
        return s;
    }
    
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 4);
        Matrix n = new Matrix(4, 2);

        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                m.arr[i][j] = x++;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                n.arr[i][j] = x++;
            }
        }
        System.out.println("test matrix m = " + m);
        System.out.println("test matrix n = " + n);
        System.out.println("m.transpose() ="  + m.transpose());
        System.out.println("m.mul(n) ="  + m.mul(n));
        try {
            System.out.println("m.minor(1,1) = "  + m.minor(1,1));
            System.out.println("m.minor(2,3) = "  + m.minor(2,3));
            System.out.println("m.block(1, 3, 2, 4) = " + m.block(1, 3, 2, 4));
            System.out.println("m.block(1, 3, 2, 4).det() = "  + m.block(1, 3, 2, 4).det());
            System.out.println("m.block(0, 3, 1, 4) = "  + m.block(0, 3, 1, 4));
            System.out.println("m.block(0, 3, 1, 4).det() = "  + m.block(0, 3, 1, 4).det());
            System.out.println("m.block(0, 3, 1, 4).cofactor() = "  + m.block(0, 3, 1, 4).cofactor());
            System.out.println("m.block(0, 3, 1, 4).adjugate() = "  + m.block(0, 3, 1, 4).adjugate());
            System.out.println("m.mul(n).block(0, 2, 0, 2) = "  + m.mul(n).block(0, 2, 0, 2).inv());

            // lines below are supposed to cause exceptions.
            System.out.println("new Matrix(1, 2).minor(1,1) = "  + new Matrix(1, 2).minor(1,1));
            System.out.println("m.det() = "  + m.det());
            System.out.println("m.block(0, 3, 1, 3).inv() = "  + m.block(0, 3, 1, 4).inv());

        } catch(Exception e) {
            System.out.println(e.toString());
        }

    }
}
