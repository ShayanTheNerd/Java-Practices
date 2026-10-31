import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean areNotificationsEnabled = true;
    final String[] settings = {
      "Enable Notifications",
      "Disable Notifications",
      "Notification Status",
      "Reset to Default Settings"
    };

    System.out.println("NOTIFICATION SETTINGS");
    for (int index = 0; index < settings.length; index++) {
      System.out.println((index + 1) + ". " + settings[index]);
    }
    System.out.print("Select an option by entering its number: ");

    Scanner scanner = new Scanner(System.in);
    while(true) {
      if (!scanner.hasNextInt()) {
        System.out.println("Invalid input.");
        System.out.print("Try again or enter 0 to exit: ");
        scanner.next();
        continue;
      }

      int option = scanner.nextInt();
      switch (option) {
        case 0: {
          System.out.println("Exiting the program...");
          scanner.close();
          return;
        }
        case 1: {
          areNotificationsEnabled = true;
          System.out.println("Notifications have been enabled.");
          break;
        }
        case 2: {
          areNotificationsEnabled = false;
          System.out.println("Notifications have been disabled.");
          break;
        }
        case 3: {
          System.out.println("Notification status: " + (areNotificationsEnabled ? "Enabled" : "Disabled"));
          break;
        }
        case 4: {
          areNotificationsEnabled = true;
          System.out.println("Settings have been reset to default. Notifications are enabled.");
          break;
        }
        default: {
          System.out.println("Invalid option.");
          break;
        }
      }

      System.out.print("Select another option or enter 0 to exit: ");
    }
  }
}
