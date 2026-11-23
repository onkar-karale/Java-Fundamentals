package basics;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args){
        // Create a Scanner object to read input from System.in (keyboard)
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        IO.print("Enter you name: ");
        String name = scanner.nextLine();  // Reads a line of text

        IO.print("Enter your age: ");
        int age = scanner.nextInt();  // Reads an integer

        IO.print("My name is " + name + " and " + "I am " + age + " years old ");

        // Close the Scanner to free resources
        scanner.close();
    }
}
