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
/**
 * An enumeration of constants to represent the status
 * of each cell.
 */
public enum CellStatus {
   GIVEN,         // clue, no need to guess
   TO_GUESS,      // need to guess - not attempted yet
   CORRECT_GUESS, // need to guess - correct guess
   WRONG_GUESS    // need to guess - wrong guess
      // The puzzle is solved if none of the cells have 
      //  status of TO_GUESS or WRONG_GUESS
}