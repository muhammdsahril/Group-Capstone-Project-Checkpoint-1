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
