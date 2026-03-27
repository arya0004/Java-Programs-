import java.util.Scanner;

// Custom Exception for Age
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

// Custom Exception for Name
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

// Student Class
public class student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    // Constructor with parameter validation
    public student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age must be between 15 and 21.");
        }
        
        if (!isValidName(name)) { // Use ASCII value check for name validation
            throw new NameNotValidException("Name contains invalid characters. Only letters and spaces are allowed.");
        }
        
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method to validate name using ASCII values
    private static boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c == ' ')) {
                return false; // Invalid if not a letter or space
            }
        }
        return true; // Valid if all characters are letters or spaces
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            
            // Creating Student Object
            student stud = new student(rollNo, name, age, course);
            stud.displayStudentInfo();
            
        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        } finally {
            scanner.close();
        }
    }
}
