// import java.util.ArrayList;
// import java.util.InputMismatchException;
// import java.util.Scanner;

// public class StudentGrades {
//     public static void main(String[] args) {
//         ArrayList<Double> grades = new ArrayList<>();
//         Scanner scanner = new Scanner(System.in);
//         boolean continueInput = true;

//         while (continueInput) {
//             try {
//                 System.out.print("Enter a grade (0-100) or -1 to finish: ");
//                 double grade = scanner.nextDouble();

//                 // Check if the user wants to stop entering grades
//                 if (grade == -1) {
//                     continueInput = false;
//                 } else if (grade < 0 || grade > 100) {
//                     System.out.println("Invalid grade. Please enter a value between 0 and 100.");
//                 } else {
//                     grades.add(grade);
//                 }
//             } catch (InputMismatchException e) {
//                 System.out.println("Invalid input. Please enter a numeric value.");
//                 scanner.next(); // Clear the invalid input
//             }
//         }

//         if (!grades.isEmpty()) {
//             double sum = 0;
//             double highest = grades.get(0);
//             double lowest = grades.get(0);

//             for (double grade : grades) {
//                 sum += grade;
//                 if (grade > highest) {
//                     highest = grade;
//                 }
//                 if (grade < lowest) {
//                     lowest = grade;
//                 }
//             }

//             double average = sum / grades.size();
//             System.out.printf("Average Grade: %.2f%n", average);
//             System.out.printf("Highest Grade: %.2f%n", highest);
//             System.out.printf("Lowest Grade: %.2f%n", lowest);
//         } else {
//             System.out.println("No grades entered.");
//         }

//         scanner.close();
//     }
// }
import java.util.*;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            // try {
                System.out.print("Enter the student's name (or type 'exit' to finish): ");
                String name = scanner.next();

                // Check if the user wants to stop entering students
                if (name.equalsIgnoreCase("exit")) {
                    continueInput = false;
                    break; // Exit the loop
                }

                System.out.print("Enter the grade for " + name + " (0-100): ");
                double grade = scanner.nextDouble();

                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                } else {
                    students.add(new Student(name, grade));
                }
        //     } catch (InputMismatchException e) {
        //         System.out.println("Invalid input. Please enter numeric values for grades.");
        //         scanner.next(); // Clear the invalid input
        //     }
        }

        if (!students.isEmpty()) {
            double sum = 0;
            double highest = students.get(0).grade;
            double lowest = students.get(0).grade;
            String highestStudent = students.get(0).name;
            String lowestStudent = students.get(0).name;

            for (Student student : students) {
                sum += student.grade;
                if (student.grade > highest) {
                    highest = student.grade;
                    highestStudent = student.name;
                }
                if (student.grade < lowest) {
                    lowest = student.grade;
                    lowestStudent = student.name;
                }
            }

            double average = sum / students.size();
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.printf("Highest Grade: %.2f by %s%n", highest, highestStudent);
            System.out.printf("Lowest Grade: %.2f by %s%n", lowest, lowestStudent);
        } else {
            System.out.println("No grades entered.");
        }

        scanner.close();
    }
}
