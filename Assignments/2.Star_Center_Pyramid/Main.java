import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int rows;
    System.out.print("Enter the number of star rows to be printed: ");
    while (true) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        if (value > 0) {
          rows = value;
          break;
        }
      } else {
        scanner.next();
      }

      System.out.println("Invalid input.");
      System.out.print("Enter a positive integer: ");
    }
    scanner.close();

    for (int index = 1; index <= rows; index++) {
      int spaceRepeatCount = rows - index;
      System.out.print(" ".repeat(spaceRepeatCount));

      int starCount = (2 * index) - 1;
      for (int count = 1; count <= starCount; count++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}
