package assignments;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class yaya extends JFrame {
    private JTextField nameField;
    private JButton addButton, deleteButton, updateButton;

    public yaya() {
        setTitle("User Management");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");

        add(nameLabel);
        add(nameField);
        add(addButton);
        add(deleteButton);
        add(updateButton);

        // Event Handlers
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
    }

    private void addUser() {
        String name = nameField.getText();
        if (!name.isEmpty()) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO users (name) VALUES (?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "User added successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding user.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name field is empty.");
        }
    }

    private void deleteUser() {
        String name = nameField.getText();
        if (!name.isEmpty()) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM users WHERE name = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No user found with that name.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting user.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name field is empty.");
        }
    }

    private void updateUser() {
        String name = nameField.getText();
        if (!name.isEmpty()) {
            String newName = JOptionPane.showInputDialog(this, "Enter new name:");
            if (newName != null && !newName.isEmpty()) {
                try (Connection conn = DatabaseConnection.getConnection()) {
                    String sql = "UPDATE users SET name = ? WHERE name = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, newName);
                    statement.setString(2, name);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "User updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "No user found with that name.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error updating user.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name field is empty.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            yaya app = new yaya();
            app.setVisible(true);
        });
    }
}

class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static final String USER = "root"; // Change this to your MySQL username
    private static final String PASSWORD = ""; // Change this to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
