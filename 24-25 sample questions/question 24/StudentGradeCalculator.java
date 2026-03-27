import java.util.*;

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

class Student {
    String name;
    String id;
    double assignmentScore;
    double quizScore;
    double examScore;

    public Student(String name, String id, double assignmentScore, double quizScore, double examScore) {
        this.name = name;
        this.id = id;
        this.assignmentScore = assignmentScore;
        this.quizScore = quizScore;
        this.examScore = examScore;
    }
}

public class StudentGradeCalculator {
    private static final double ASSIGNMENT_WEIGHT = 0.4;
    private static final double QUIZ_WEIGHT = 0.3;
    private static final double EXAM_WEIGHT = 0.3;

    // Method to calculate final grade
    public double calculateFinalGrade(double assignment, double quiz, double exam) throws InvalidScoreException {
        validateScore(assignment);
        validateScore(quiz);
        validateScore(exam);
        return (assignment * ASSIGNMENT_WEIGHT) + (quiz * QUIZ_WEIGHT) + (exam * EXAM_WEIGHT);
    }

    // Validate score to ensure it's between 0 and 100
    private void validateScore(double score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("Score must be between 0 and 100.");
        }
    }

    // Method to add student grades
    public void addStudent(ArrayList<Student> students, String name, String id, double assignment, double quiz, double exam) {
        try {
            double finalGrade = calculateFinalGrade(assignment, quiz, exam);
            students.add(new Student(name, id, assignment, quiz, exam));
            System.out.println("Student added: " + name + ", Final Grade: " + finalGrade);
        } catch (InvalidScoreException e) {
            System.out.println("Error for student " + name + ": " + e.getMessage());
        }
    }

    // Method to display all student grades
    public void displayGrades(ArrayList<Student> students) {
        System.out.println("\nStudent Grades:");
        for (Student student : students) {
            try {
                double finalGrade = calculateFinalGrade(student.assignmentScore, student.quizScore, student.examScore);
                System.out.println("Name: " + student.name + ", ID: " + student.id + ", Final Grade: " + finalGrade + ", Letter Grade: " + getLetterGrade(finalGrade));
            } catch (InvalidScoreException e) {
                System.out.println("Error calculating grade for student " + student.name + ": " + e.getMessage());
            }
        }
    }

    // Method to get letter grade based on final grade
    public String getLetterGrade(double finalGrade) {
        if (finalGrade >= 90) return "A";
        else if (finalGrade >= 80) return "B";
        else if (finalGrade >= 70) return "C";
        else if (finalGrade >= 60) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeCalculator calculator = new StudentGradeCalculator();
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            System.out.println("Enter student ID:");
            String id = scanner.nextLine();

            System.out.println("Enter assignment score (0-100):");
            double assignmentScore = scanner.nextDouble();

            System.out.println("Enter quiz score (0-100):");
            double quizScore = scanner.nextDouble();

            System.out.println("Enter exam score (0-100):");
            double examScore = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            calculator.addStudent(students, name, id, assignmentScore, quizScore, examScore);
        }

        calculator.displayGrades(students);
        //scanner.close();
    }
}
