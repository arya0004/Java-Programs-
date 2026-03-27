import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {
    private long startTime;
    private boolean running = false;
    private JLabel timeLabel;
    private Timer timer;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Time display label
        timeLabel = new JLabel("Elapsed Time: 0.0 seconds", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel, BorderLayout.CENTER);

        // Control panel with buttons
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Timer to update the elapsed time
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                double seconds = elapsedTime / 1000.0;
                timeLabel.setText(String.format("Elapsed Time: %.1f seconds", seconds));
            }
        });

        // Start button action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    startTime = System.currentTimeMillis();
                    timer.start();
                    running = true;
                }
            }
        });

        // Stop button action
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    timer.stop();
                    running = false;
                }
            }
        });

        // Reset button action
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                running = false;
                timeLabel.setText("Elapsed Time: 0.0 seconds");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.setVisible(true);
        });
    }
}
