import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JRadioButton celsiusToFahrenheit;
    private JRadioButton fahrenheitToCelsius;
    private JButton convertButton;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Input field
        inputField = new JTextField();
        inputField.setToolTipText("Enter temperature value");
        add(new JLabel("Enter Temperature:"));
        add(inputField);

        // Conversion type selection
        JPanel radioPanel = new JPanel();
        celsiusToFahrenheit = new JRadioButton("Celsius to Fahrenheit");
        fahrenheitToCelsius = new JRadioButton("Fahrenheit to Celsius");
        ButtonGroup group = new ButtonGroup();
        group.add(celsiusToFahrenheit);
        group.add(fahrenheitToCelsius);
        radioPanel.add(celsiusToFahrenheit);
        radioPanel.add(fahrenheitToCelsius);
        add(radioPanel);

        // Convert button
        convertButton = new JButton("Convert");
        add(convertButton);

        // Output field
        outputField = new JTextField();
        outputField.setEditable(false);
        add(new JLabel("Converted Temperature:"));
        add(outputField);

        // Action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputTemperature = Double.parseDouble(inputField.getText());
            double convertedTemperature;
            if (celsiusToFahrenheit.isSelected()) {
                convertedTemperature = (inputTemperature * 9 / 5) + 32; // Celsius to Fahrenheit
                outputField.setText(String.format("%.2f °F", convertedTemperature));
            } else if (fahrenheitToCelsius.isSelected()) {
                convertedTemperature = (inputTemperature - 32) * 5 / 9; // Fahrenheit to Celsius
                outputField.setText(String.format("%.2f °C", convertedTemperature));
            } else {
                JOptionPane.showMessageDialog(this, "Please select a conversion type.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid temperature value. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}
