import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display; // Text field to show calculations and results
    private StringBuilder input; // To build the user input string
    private double firstNum; // To store the first number for calculations
    private String operator; // To store the operator for calculations

    public Calculator() {
        input = new StringBuilder();
        
        // Create the frame
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display area
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4)); // 4 rows and 4 columns

        // Create buttons and add action listeners
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER); // Add button panel to the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle button clicks
        switch (command) {
            case "C": // Clear the display
                input.setLength(0); // Clear the input
                display.setText("");
                break;
            case "=": // Perform calculation
                if (input.length() > 0) {
                    double secondNum = Double.parseDouble(input.toString());
                    double result = performCalculation(firstNum, secondNum, operator);
                    display.setText(String.valueOf(result));
                    input.setLength(0); // Clear input after calculation
                }
                break;
            default: // Handle numbers and operators
                if ("+-*/".contains(command)) { // If it's an operator
                    if (input.length() > 0) {
                        firstNum = Double.parseDouble(input.toString());
                        operator = command; // Store operator
                        input.setLength(0); // Clear input for next number
                    }
                } else { // If it's a number
                    input.append(command); // Append to input
                }
                display.setText(input.toString()); // Update display
                break;
        }
    }

    // Method to perform calculations based on operator
    private double performCalculation(double firstNum, double secondNum, String operator) {
        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                if (secondNum != 0) {
                    return firstNum / secondNum;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
