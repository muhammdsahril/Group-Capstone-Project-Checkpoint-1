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
import java.util.Random;
import javax.swing.*;

public class GameBoardPanel extends JPanel {
   private static final long serialVersionUID = 1L;

   public static final int CELL_SIZE = 60;
   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;

   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
   private Puzzle puzzle = new Puzzle();

   public GameBoardPanel() {
      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));

      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);
         }
      }

      CellInputListener listener = new CellInputListener();

      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            if(cells[row][col].isEditable()) {
               cells[row][col].addActionListener(listener);
            }
         }
      }

      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
   }

   public void newGame() {
      puzzle.newPuzzle(2);

      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
         }
      }
   }

   public boolean isSolved() {
      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
               return false;
            }
         }
      }
      return true;
   }

   public boolean giveHint() {
      Random rand = new Random();
      for (int attempts = 0; attempts < 100; ++attempts) {
         int row = rand.nextInt(SudokuConstants.GRID_SIZE);
         int col = rand.nextInt(SudokuConstants.GRID_SIZE);

         if (cells[row][col].status == CellStatus.TO_GUESS) {
            cells[row][col].setText(String.valueOf(cells[row][col].number));
            cells[row][col].status = CellStatus.CORRECT_GUESS;
            cells[row][col].paint();
            return true;
         }
      }
      return false;
   }
}
