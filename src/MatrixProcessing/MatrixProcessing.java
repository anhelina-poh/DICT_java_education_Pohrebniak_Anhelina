package MatrixProcessing;

import java.util.Scanner;

@SuppressWarnings("all")
public class MatrixProcessing {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = Matrix.read(scanner);
        double constant = scanner.nextDouble();

        Matrix result = matrix.multiply(constant);
        result.print();

        scanner.close();
    }
}