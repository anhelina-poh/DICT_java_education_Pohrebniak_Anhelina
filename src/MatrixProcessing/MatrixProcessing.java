package MatrixProcessing;

import java.util.Scanner;

@SuppressWarnings("all")
public class MatrixProcessing {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Matrix a = Matrix.read(scanner);
        Matrix b = Matrix.read(scanner);

        Matrix result = a.add(b);
        if (result == null) {
            System.out.println("ERROR");
        } else {
            result.print();
        }
        scanner.close();
    }
}