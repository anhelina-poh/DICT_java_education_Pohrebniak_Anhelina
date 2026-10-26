package MatrixProcessing;

import java.util.Scanner;

@SuppressWarnings("all")
public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] values;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int r, int c) {
        return values[r][c];
    }

    public void set(int r, int c, double val) {
        values[r][c] = val;
    }

    public static Matrix read(Scanner scanner) {
        int r = Integer.parseInt(scanner.next());
        int c = Integer.parseInt(scanner.next());
        Matrix matrix = new Matrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String token = scanner.next().replace(',', '.');
                matrix.set(i, j, Double.parseDouble(token));
            }
        }
        return matrix;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double val = values[i][j];
                if (Math.abs(val - Math.round(val)) < 1e-9) {
                    System.out.print((long) Math.round(val));
                } else {
                    double rounded = Math.round(val * 100.0) / 100.0;
                    System.out.print(rounded);
                }
                if (j < cols - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            return null;
        }
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(i, j, this.get(i, j) + other.get(i, j));
            }
        }
        return res;
    }

    public Matrix multiply(double constant) {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(i, j, this.get(i, j) * constant);
            }
        }
        return res;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            return null;
        }
        Matrix res = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.get(i, k) * other.get(k, j);
                }
                res.set(i, j, sum);
            }
        }
        return res;
    }

    public Matrix transposeMainDiagonal() {
        Matrix res = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(j, i, this.get(i, j));
            }
        }
        return res;
    }

    public Matrix transposeSideDiagonal() {
        Matrix res = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(cols - 1 - j, rows - 1 - i, this.get(i, j));
            }
        }
        return res;
    }

    public Matrix transposeVertical() {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(i, cols - 1 - j, this.get(i, j));
            }
        }
        return res;
    }

    public Matrix transposeHorizontal() {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.set(rows - 1 - i, j, this.get(i, j));
            }
        }
        return res;
    }

    public boolean isSquare() {
        return rows == cols;
    }

    public double determinant() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        return computeDet(this.values);
    }

    private static double computeDet(double[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        if (n == 2) return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];

        double det = 0;
        for (int j = 0; j < n; j++) {
            double[][] minor = getMinor(mat, 0, j);
            double sign = (j % 2 == 0) ? 1.0 : -1.0;
            det += sign * mat[0][j] * computeDet(minor);
        }
        return det;
    }

    public static double[][] getMinor(double[][] mat, int skipRow, int skipCol) {
        int n = mat.length;
        double[][] minor = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == skipRow) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == skipCol) continue;
                minor[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }

    public Matrix inverse() {
        if (!isSquare()) return null;
        double det = determinant();
        if (Math.abs(det) < 1e-9) return null;

        int n = rows;
        Matrix cofactors = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] minor = getMinor(this.values, i, j);
                double cofactor = computeDet(minor);
                double sign = ((i + j) % 2 == 0) ? 1.0 : -1.0;
                cofactors.set(i, j, sign * cofactor);
            }
        }

        Matrix adjugate = cofactors.transposeMainDiagonal();
        return adjugate.multiply(1.0 / det);
    }
}