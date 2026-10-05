package ChatBot;

import java.util.Scanner;

public class ChatBot {
    @SuppressWarnings({"all", "UseOfSystemOutOrSystemErr"})
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String botName = "Bob";
    int birthYear = 2026;

    System.out.println("Hello! My name is " + botName + ".");
    System.out.println("I was created in " + birthYear + ".");
    System.out.println("Please, remind me your name.");

    String yourName = scanner.nextLine();

    System.out.println("What a great name you have, " + yourName + "!");
    System.out.println("Let me guess your age.");
    System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

    int remainder3 = scanner.nextInt();
    int remainder5 = scanner.nextInt();
    int remainder7 = scanner.nextInt();
    int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

    System.out.println("Your age is " + age + "; that's a good time to start programming!");
    System.out.println("Now I will prove to you that I can count to any number you want!");

    int number = scanner.nextInt();

    for (int i = 0; i <= number; i++) {
        System.out.println(i + " !");
    }

        System.out.println("Why are methods used in Java?");
        System.out.println("1. To make code longer and more complicated.");
        System.out.println("2. To repeat the same code multiple times.");
        System.out.println("3. To organize code into reusable blocks.");
        System.out.println("4. Because it's required by the compiler.");

        int answer;
        boolean correctAnswer = false;

        while (!correctAnswer) {
            answer = scanner.nextInt();
            scanner.nextLine();

            if (answer == 3) {
                correctAnswer = true;
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
            }
        }

        System.out.println("Goodbye, have a nice day!");

        scanner.close();
    }
}