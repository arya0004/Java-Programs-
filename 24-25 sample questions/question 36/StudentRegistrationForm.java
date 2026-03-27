import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm {
    // Create components
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JCheckBox course1CheckBox;
    private JCheckBox course2CheckBox;
    private JCheckBox course3CheckBox;
    private JButton submitButton;

    public StudentRegistrationForm() {
        // Create frame
        frame = new JFrame("Student Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Add name label and field
        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        // Add age label and field
        frame.add(new JLabel("Age:"));
        ageField = new JTextField();
        frame.add(ageField);

        // Add gender label
        frame.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);

        // Add course label
        frame.add(new JLabel("Course:"));
        JPanel coursePanel = new JPanel();
        course1CheckBox = new JCheckBox("Java Programming");
        course2CheckBox = new JCheckBox("Data Structures");
        course3CheckBox = new JCheckBox("Web Development");
        coursePanel.add(course1CheckBox);
        coursePanel.add(course2CheckBox);
        coursePanel.add(course3CheckBox);
        frame.add(coursePanel);

        // Add submit button
        submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // Empty label for layout

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayData();
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }

    private void displayData() {
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        StringBuilder courses = new StringBuilder();

        if (course1CheckBox.isSelected()) {
            courses.append(course1CheckBox.getText()).append(", ");
        }
        if (course2CheckBox.isSelected()) {
            courses.append(course2CheckBox.getText()).append(", ");
        }
        if (course3CheckBox.isSelected()) {
            courses.append(course3CheckBox.getText()).append(", ");
        }

        // Remove trailing comma and space
        if (courses.length() > 0) {
            courses.setLength(courses.length() - 2);
        } else {
            courses.append("None");
        }

        // Display data in a message dialog
        String message = String.format("Name: %s\nAge: %s\nGender: %s\nCourses: %s",
                name, age, gender, courses.toString());
        JOptionPane.showMessageDialog(frame, message, "Registration Data", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm());
    }
}
