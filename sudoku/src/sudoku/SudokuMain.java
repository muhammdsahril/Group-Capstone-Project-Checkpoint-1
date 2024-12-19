/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group #1
 * 1 - 5026231220 - Muhammad Sahril
 * 2 - 5026231207 - Achmad Andi M H
 * 3 - 5026231193 - Jonathan berlianto
*/


package sudoku;
import java.awt.*;
import javax.swing.*;

public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;

    private GameBoardPanel board = new GameBoardPanel();
    private JButton btnNewGame = new JButton("New Game");
    private JButton btnHint = new JButton("Hint");
    private JLabel timerLabel = new JLabel("Time: 00:00", JLabel.CENTER);

    private Timer timer;
    private int timeElapsed;

    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        controlPanel.add(btnNewGame);
        controlPanel.add(btnHint);
        controlPanel.add(timerLabel);

        cp.add(controlPanel, BorderLayout.SOUTH);

        btnNewGame.addActionListener(e -> startNewGame());
        btnHint.addActionListener(e -> giveHint());

        startNewGame();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }

    private void startNewGame() {
        board.newGame();
        timeElapsed = 0;
        updateTimerLabel();
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(1000, e -> {
            timeElapsed++;
            updateTimerLabel();
        });
        timer.start();
    }

    private void giveHint() {
        boolean hintGiven = board.giveHint();
        if (!hintGiven) {
            JOptionPane.showMessageDialog(this, "No more hints available!");
        }
        if (board.isSolved()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Congratulations! You have solved the puzzle!");
        }
    }

    private void updateTimerLabel() {
        int minutes = timeElapsed / 60;
        int seconds = timeElapsed % 60;
        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }
}
