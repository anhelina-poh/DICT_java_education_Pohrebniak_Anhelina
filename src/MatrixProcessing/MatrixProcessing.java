package MatrixProcessing;

import java.util.Scanner;

@SuppressWarnings("all")
public class MatrixProcessing {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            if (!scanner.hasNext()) {
                break;
            }

            int choice = Integer.parseInt(scanner.next());

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter size of first matrix: > ");
                    Matrix m1 = Matrix.read(scanner);
                    System.out.print("Enter size of second matrix: > ");
                    Matrix m2 = Matrix.read(scanner);
                    Matrix res = m1.add(m2);
                    if (res == null) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        System.out.println("The result is:");
                        res.print();
                    }
                }
                case 2 -> {
                    System.out.print("Enter size of matrix: > ");
                    Matrix m = Matrix.read(scanner);
                    System.out.print("Enter constant: > ");
                    String constToken = scanner.next().replace(',', '.');
                    double c = Double.parseDouble(constToken);
                    System.out.println("The result is:");
                    m.multiply(c).print();
                }
                case 3 -> {
                    System.out.print("Enter size of first matrix: > ");
                    Matrix m1 = Matrix.read(scanner);
                    System.out.print("Enter size of second matrix: > ");
                    Matrix m2 = Matrix.read(scanner);
                    Matrix res = m1.multiply(m2);
                    if (res == null) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        System.out.println("The result is:");
                        res.print();
                    }
                }
                case 4 -> {
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: > ");
                    int tChoice = Integer.parseInt(scanner.next());

                    System.out.print("Enter matrix size: > ");
                    Matrix m = Matrix.read(scanner);
                    Matrix res = switch (tChoice) {
                        case 1 -> m.transposeMainDiagonal();
                        case 2 -> m.transposeSideDiagonal();
                        case 3 -> m.transposeVertical();
                        case 4 -> m.transposeHorizontal();
                        default -> null;
                    };

                    if (res != null) {
                        System.out.println("The result is:");
                        res.print();
                    }
                }
                case 5 -> {
                    System.out.print("Enter matrix size: > ");
                    Matrix m = Matrix.read(scanner);
                    if (!m.isSquare()) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        double det = m.determinant();
                        System.out.println("The result is:");
                        if (Math.abs(det - Math.round(det)) < 1e-9) {
                            System.out.println((long) Math.round(det));
                        } else {
                            System.out.println(det);
                        }
                    }
                }
                case 6 -> {
                    System.out.print("Enter matrix size: > ");
                    Matrix m = Matrix.read(scanner);
                    Matrix inv = m.inverse();
                    if (inv == null) {
                        System.out.println("This matrix doesn't have an inverse.");
                    } else {
                        System.out.println("The result is:");
                        inv.print();
                    }
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}