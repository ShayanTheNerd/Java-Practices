import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int studentsCount;
    System.out.print("Enter the number of students: ");
    while (true) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        if (value > 0) {
          studentsCount = value;
          break;
        }
      } else {
        scanner.next();
      }

      System.out.println("Invalid input.");
      System.out.print("Enter a positive integer: ");
    }
    System.out.println("There are " + getStudentsCount(studentsCount) + ".");

    double[] studentScores = new double[studentsCount];
    System.out.println("Enter the score of each student (0–20): ");
    for (int index = 0; index < studentScores.length; index++) {
      System.out.print("The score of student " + (index + 1) + ": ");
      while (true) {
        if (scanner.hasNextDouble()) {
          double value = scanner.nextDouble();
          if (value >= 0 && value <= 20) {
            studentScores[index] = roundToTenths(value);
            break;
          }
        } else {
          scanner.next();
        }

        System.out.println("Invalid input.");
        System.out.print("Enter a score between 0 and 20 for student " + (index + 1) + ": ");
      }
    }

    scanner.close();

    System.out.println("Average score: " + getAverageScore(studentScores));
    System.out.println("Highest score: " + getHighestScore(studentScores));
    System.out.println("Lowest score: " + getLowestScore(studentScores));
    System.out.println("Number of passed students: " + getPassedStudentsCount(studentScores));
    System.out.println("Number of failed students: " + getFailedStudentsCount(studentScores));
  }

  public static String getStudentsCount(int count) {
    return count + (count > 1 ? " students" : " student");
  }

  public static double roundToTenths(double number) {
    return Math.round(number * 10.0) / 10.0;
  }

  public static double getAverageScore(double[] scores) {
    double sum = 0;
    for (double score : scores) {
      sum += score;
    }
    return roundToTenths(sum / scores.length);
  }

  public static double getHighestScore(double[] scores) {
    double highest = scores[0];
    for (double score : scores) {
      if (score > highest) {
        highest = score;
      }
    }
    return roundToTenths(highest);
  }

  public static double getLowestScore(double[] scores) {
    double lowest = scores[0];
    for (double score : scores) {
      if (score < lowest) {
        lowest = score;
      }
    }
    return roundToTenths(lowest);
  }

  public static int getPassedStudentsCount(double[] scores) {
    int count = 0;
    for (double score : scores) {
      if (score >= 10) {
        count++;
      }
    }
    return count;
  }

  public static int getFailedStudentsCount(double[] scores) {
    int count = 0;
    for (double score : scores) {
      if (score < 10) {
        count++;
      }
    }
    return count;
  }
}
