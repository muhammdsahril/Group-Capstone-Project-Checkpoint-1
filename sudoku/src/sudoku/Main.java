package sudoku;

import javax.swing.SwingUtilities;

public class Main {

    /** The entry main() entry method */
    public static void main(String[] args) {
    // [TODO 1] Check "Swing program template" on how to run
    //  the constructor of "SudokuMain"
    // .........
        SwingUtilities.invokeLater(() -> {
            // Membuat instance SudokuMain
            new SudokuMain();
        });
    }
}
