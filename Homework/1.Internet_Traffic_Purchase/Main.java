import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final int PRICE_PER_1GB = 5_000;

    Scanner scanner = new Scanner(System.in);

    double balance;
    System.out.print("Enter your balance in Tomans: ");
    while (true) {
      if (scanner.hasNextDouble()) {
        double value = scanner.nextDouble();
        if (Double.isFinite(value) && value != -0 && value >= 0) {
          balance = value;
          break;
        }
      } else {
        scanner.next();
      }

      System.out.println("Invalid input.");
      System.out.print("Enter a valid number: ");
    }
    System.out.println("Your balance is " + getLocalizedPrice(balance) + ".");

    int trafficInGBs;
    System.out.print("Enter the requested internet traffic in GBs: ");
    while (true) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        if (value > 0) {
          trafficInGBs = value;
          break;
        }
      } else {
        scanner.next();
      }

      System.out.println("Invalid input.");
      System.out.print("Enter a positive integer:");
    }
    System.out.println("You requested " + getTrafficAmount(trafficInGBs) + ".");

    System.out.println("====================");

    int discountPercentage = trafficInGBs > 10 ? 15 : 0;
    double finalPrice = PRICE_PER_1GB * trafficInGBs * ((100.0 - discountPercentage) / 100.0);

    if (balance >= finalPrice) {
      System.out.println(
        "You successfully purchased " + getTrafficAmount(trafficInGBs) + " for " + getLocalizedPrice(finalPrice) + "."
      );

      if (trafficInGBs > 10) {
        System.out.println("Base price: " + getLocalizedPrice(PRICE_PER_1GB * trafficInGBs) + ".");
        System.out.println(
          "You received a discount of " + discountPercentage + "% for purchasing more than 10 GBs of internet traffic."
        );
      }

      System.out.println("Your remaining balance is " + getLocalizedPrice((balance - finalPrice)) + ".");
    } else {
      double shortage = finalPrice - balance;
      System.out.println(
        "Your balance is " +
        getLocalizedPrice(balance) +
        ", which is not enough for purchasing " +
        getTrafficAmount(trafficInGBs) +
        ". The shortage is " + getLocalizedPrice(shortage) + "."
      );
      System.out.println("The final price is " + getLocalizedPrice(finalPrice) + ".");
    }

    scanner.close();
  }

  public static String getTrafficAmount(int trafficInGBs) {
    return trafficInGBs + (trafficInGBs > 1 ? " GBs" : " GB") + " of internet traffic";
  }

  public static String getLocalizedPrice(double price) {
    return formatNumber(price) + (price > 1 ? " Tomans" : " Toman");
  }

  public static String formatNumber(double number) {
    return String.format(Locale.US, "%,.1f", number);
  }
}
