import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double cost;
    System.out.print("Enter the group subscription cost in Tomans: ");
    while (true) {
      try {
        double value = Double.parseDouble(scanner.nextLine());
        if (Double.isFinite(value) && value >= 0) {
          cost = Math.abs(value);
          break;
        } else {
          System.out.println("The cost cannot be negative or infinity.");
        }
      } catch (NumberFormatException exception) {
        System.out.println("Invalid input.");
      }

      System.out.print("Enter a valid number: ");
    }
    System.out.println("The group subscription cost is " + getLocalizedPrice(cost) + ".");

    int membersCount;
    System.out.print("Enter the number of group members: ");
    while (true) {
      try {
        int value = Integer.parseInt(scanner.nextLine());
        if (value < 0) {
          System.out.println("The number cannot be negative.");
        } else if (value == 0) {
          System.out.println("The number cannot be zero.");
        } else {
          membersCount = value;
          break;
        }
      } catch (NumberFormatException exception) {
        System.out.println("Invalid value.");
      }

      System.out.print("Enter a positive integer: ");
    }
    System.out.println("The group has " + membersCount + " members.");

    System.out.println("====================");

    double costPerMember = cost / membersCount;
    System.out.println("Each group member must pay " + getLocalizedPrice(costPerMember) + " for the group subscription.");

    scanner.close();
  }

  public static String getLocalizedPrice(double price) {
    return formatNumber(price) + (price > 1 ? " Tomans" : " Toman");
  }

  public static String formatNumber(double number) {
    return String.format(Locale.US, "%,.3f", number);
  }
}
