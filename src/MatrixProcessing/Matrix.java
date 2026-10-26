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
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        Matrix matrix = new Matrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix.set(i, j, scanner.nextDouble());
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
                    System.out.print(val);
                }
                if (j < cols - 1) System.out.print(" ");
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
}