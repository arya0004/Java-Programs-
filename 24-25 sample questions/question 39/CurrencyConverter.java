import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JComboBox<String> sourceCurrency;
    private JComboBox<String> targetCurrency;
    private JLabel resultLabel;

    // Exchange rates (example rates)
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);
    }

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Amount field
        amountField = new JTextField();
        amountField.setToolTipText("Enter amount to convert");
        add(new JLabel("Amount:"));
        add(amountField);

        // Source currency selection
        sourceCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        add(new JLabel("Select Source Currency:"));
        add(sourceCurrency);

        // Target currency selection
        targetCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        add(new JLabel("Select Target Currency:"));
        add(targetCurrency);

        // Convert button
        JButton convertButton = new JButton("Convert");
        add(convertButton);

        // Result label
        resultLabel = new JLabel("Converted Amount: ");
        add(resultLabel);

        // Action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String source = (String) sourceCurrency.getSelectedItem();
            String target = (String) targetCurrency.getSelectedItem();

            if (source == null || target == null) {
                JOptionPane.showMessageDialog(this, "Please select both currencies.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double sourceRate = exchangeRates.get(source);
            double targetRate = exchangeRates.get(target);
            double convertedAmount = (amount / sourceRate) * targetRate;

            resultLabel.setText(String.format("Converted Amount: %.2f %s", convertedAmount, target));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter converter = new CurrencyConverter();
            converter.setVisible(true);
        });
    }
}
