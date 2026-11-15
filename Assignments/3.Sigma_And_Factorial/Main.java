import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int integer;
    System.out.print("Enter an integer: ");
    while (true) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        if (value >= 0) {
          integer = value;
          break;
        }
      } else {
        scanner.next();
      }

      System.out.println("Invalid input.");
      System.out.print("Enter a non-negative integer: ");
    }
    scanner.close();

    int sigma = 0;
    for (int index = 1; index <= integer; index++) {
      sigma += index;
    }
    System.out.println("The sum of integers from 0 to " + integer + " is: " + sigma);

    int factorial = 1;
    for (int index = 1; index <= integer; index++) {
      factorial *= index;
    }
    System.out.println("The factorial of " + integer + " is: " + factorial);
  }
}
