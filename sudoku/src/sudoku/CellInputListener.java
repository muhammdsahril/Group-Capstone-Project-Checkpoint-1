package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellInputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Cell sourceCell = (Cell)e.getSource();
        
        // Retrieve the int entered
        int numberIn = Integer.parseInt(sourceCell.getText());
        // For debugging
        System.out.println("You entered " + numberIn);

        if(numberIn == sourceCell.number) {
            sourceCell.status = CellStatus.CORRECT_GUESS;
        } else {
            sourceCell.status = CellStatus.WRONG_GUESS;
        }
        sourceCell.paint();

        /*
          * [TODO 6] (later)
          * Check if the player has solved the puzzle after this move,
          *   by calling isSolved(). Put up a congratulation JOptionPane, if so.
        */
    }
}
