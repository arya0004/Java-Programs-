import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Display field
        display = new JTextField(25);
        display.setEditable(false);
        add(display);

        // Number buttons
        String[] buttonLabels = {
            "7", "8", "9", 
            "4", "5", "6", 
            "1", "2", "3", 
            "0", ".", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            add(button);
        }

        // Operator buttons
        String[] operatorLabels = {"+", "-", "*", "/", "C"};
        for (String label : operatorLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            add(button);
        }

        setVisible(true);
    }

    // Event Handling
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            // If a number or decimal point is clicked, append it to the display
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            // Clear button
            display.setText("");
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            // Equals button: perform calculation
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result; // Store result for continuous operations
        } else {
            // Operator button (+, -, *, /) is clicked
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
