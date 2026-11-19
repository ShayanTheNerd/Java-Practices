public class Main {
  public static void main(String[] args) {
    MealCard saraMealCard = new MealCard("Sara", 5);
    MealCard rezaMealCard = new MealCard("Reza", 2);

    saraMealCard.buyMeals(3); // ✅, buys 3/5, remaining: 2/5
    saraMealCard.buyMeals(4); // ❌, not enough balance, remaining: 2/5
    saraMealCard.addMeals(9); // ❌, cannot add 9 meals, would exceed max balance of 10
    saraMealCard.addMeals(8); // ✅, adds 8 meals, new balance: 10/10
    saraMealCard.buyMeals(10); // ✅, buys 10/10, remaining: 0/10

    System.out.println("================================");
    saraMealCard.printStatus();
    System.out.println("================================");
    rezaMealCard.printStatus();
  }
}

class MealCard {
  final int MIN_BALANCE = 0;
  final int MAX_BALANCE = 10;

  String ownerName;
  int balance;
  int totalMealsBought;

  public MealCard(String ownerName, int initialBalance) {
    this.ownerName = ownerName;
    this.setBalance(initialBalance);
    this.totalMealsBought = 0;
  }

  int getBalance() {
    return this.balance;
  }
  void setBalance(int initialBalance) {
    if (initialBalance >= this.MIN_BALANCE && initialBalance <= this.MAX_BALANCE) {
      this.balance = initialBalance;
    } else {
      System.err.println("❌ Balance must be between " + this.MIN_BALANCE + " and " + this.MAX_BALANCE + ".");
    }
  }

  boolean buyMeals(int count) {
    if (count <= 0) {
      System.err.println("❌ Invalid meal count. Enter an integer between 1 and " + this.balance + ".");
      return false;
    } else if (count > this.balance) {
      System.err.println("❌ Insufficient balance. You can't buy more than " + this.balance + " meals.");
      return false;
    } else {
      System.out.println("✅ " + this.ownerName + " bought " + count + "/" + this.balance + " meals.");
      this.balance -= count;
      this.totalMealsBought += count;
      return true;
    }
  }

  boolean addMeals(int count) {
    int newBalance = this.balance + count;
    if (count > 0 && newBalance <= this.MAX_BALANCE) {
      System.out.println(
        "✅ " + this.ownerName + " added " + count + " meals. New balance: " + newBalance + "/" + this.MAX_BALANCE
      );
      this.setBalance(newBalance);
      return true;
    } else {
      System.err.println("❌ Cannot add " + count + " meals because new balance (" + newBalance + ") would exceed " + this.MAX_BALANCE + ".");
      return false;
    }
  }

  void printStatus() {
    System.out.println("Owner: " + this.ownerName);
    System.out.println("Total meals bought: " + this.totalMealsBought);
    System.out.println("Remaining meals (balance): " + this.balance + "/" + this.MAX_BALANCE);
  }
}
