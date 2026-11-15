import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    long balance = 1000000;
    final String[] options = {
      "Balance",
      "Deposit",
      "Withdraw",
      "Exit"
    };
    int successfulTransactions = 0;

    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("==============================");
      System.out.println("WALLET OPTIONS");
      for (int index = 0; index < options.length; index++) {
        System.out.println((index + 1) + ". " + options[index]);
      }
      System.out.println("==============================");
      System.out.print("Select an option by entering its number: ");

      if (!scanner.hasNextInt()) {
        System.out.println("Invalid input.");
        System.out.print("Try again or enter 4 to exit: ");
        scanner.next();
        continue;
      }

      int option = scanner.nextInt();
      switch (option) {
        case 1: {
          System.out.println("Your current balance is: " + getLocalizedNumber(balance));
          break;
        }
        case 2: {
          System.out.print("Enter the amount to deposit: ");
          while (true) {
            if (scanner.hasNextLong()) {
              long value = scanner.nextLong();
              if (value > 0) {
                balance += value;
                successfulTransactions++;
                System.out.println("Deposit successful. Your new balance is: " + getLocalizedNumber(balance));
                break;
              }
            } else {
              scanner.next();
            }

            System.out.println("Invalid input.");
            System.out.print("Enter a positive number to deposit: ");
          }
          break;
        }
        case 3: {
          System.out.print("Enter the amount to withdraw: ");
          while (true) {
            if (scanner.hasNextLong()) {
              long value = scanner.nextLong();
              if (value > 0 && value <= balance) {
                balance -= value;
                successfulTransactions++;
                System.out.println("Withdrawal successful. Your new balance is: " + getLocalizedNumber(balance));
                break;
              }
            } else {
              scanner.next();
            }

            System.out.println("Invalid input.");
            System.out.print(
              "Enter a positive number less than or equal to your balance (" + getLocalizedNumber(balance) + ") to withdraw: "
            );
          }
          break;
        }
        case 4: {
          System.out.println("You balance is: " + getLocalizedNumber(balance));
          System.out.println("You had " + getSuccessfulTransactionsCount(successfulTransactions) + ".");
          System.out.println("Exiting the program...");
          scanner.close();
          return;
        }
        default: {
          System.out.println("Invalid option.");
          break;
        }
      }
    }
  }

  public static String getSuccessfulTransactionsCount(int transactionsCount) {
    return transactionsCount + " successful " + (transactionsCount > 1 ? " transactions" : "transaction");
  }

  public static String getLocalizedNumber(double price) {
    return formatNumber(price) + (price > 1 ? " Tomans" : " Toman");
  }

  public static String formatNumber(double number) {
    return String.format(Locale.US, "%,.1f", number);
  }
}
