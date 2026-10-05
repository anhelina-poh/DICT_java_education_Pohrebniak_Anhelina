package ChatBot;

import java.util.Scanner;

public class ChatBot {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String botName = "Bob";
    int birthYear = 2026;

    System.out.println("Hello! My name is " + botName + ".");
    System.out.println("I was created in " + birthYear + ".");
    System.out.println("Please, remind me your name.");

    String yourName = scanner.nextLine();

    System.out.println("What a great name you have, " + yourName + "!");
    }
}
