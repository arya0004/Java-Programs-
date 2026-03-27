import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageSelector extends JFrame implements ItemListener, ActionListener {
    private JComboBox<String> choice;
    private JList<String> languageList;
    private JLabel selectedLanguageLabel;
    private JButton showSelectedButton;

    // Constructor
    public LanguageSelector() {
        setTitle("Favorite Programming Language Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Choice component (using JComboBox)
        String[] languages = {"Java", "Python", "C++", "JavaScript", "Ruby"};
        choice = new JComboBox<>(languages);
        choice.addItemListener(this);
        add(choice);

        // Label to show selected language from Choice
        selectedLanguageLabel = new JLabel("Selected Language: None");
        add(selectedLanguageLabel);

        // List component (using JList)
        languageList = new JList<>(languages);
        languageList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        languageList.setVisibleRowCount(3);
        JScrollPane listScrollPane = new JScrollPane(languageList);
        listScrollPane.setPreferredSize(new Dimension(150, 80));
        add(listScrollPane);

        // Button to show selected items from the List
        showSelectedButton = new JButton("Show Selected Languages");
        showSelectedButton.addActionListener(this);
        add(showSelectedButton);

        setVisible(true);
    }

    // Event handling for the Choice component
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == choice) {
            String selectedLanguage = (String) choice.getSelectedItem();
            selectedLanguageLabel.setText("Selected Language: " + selectedLanguage);
        }
    }

    // Event handling for the button click to show multiple selections
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showSelectedButton) {
            java.util.List<String> selectedValues = languageList.getSelectedValuesList();
            if (selectedValues.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No languages selected.");
            } else {
                String message = "Selected Languages: " + String.join(", ", selectedValues);
                JOptionPane.showMessageDialog(this, message);
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new LanguageSelector();
    }
}
