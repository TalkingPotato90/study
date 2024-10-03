package ham;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BingoGameGUI extends JFrame {

    private static final int BOARD_SIZE = 5;

    private BingoGame bingoGame;
    private JButton[][] buttons;

    public BingoGameGUI() {
        bingoGame = new BingoGame();

        setTitle("Bingo Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupUI();
    }

    private void setupUI() {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j] = new JButton(Integer.toString(bingoGame.getBoard()[i][j]));
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 18));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!bingoGame.isBingo()) {
                if (!bingoGame.markNumber(bingoGame.getBoard()[row][col])) {
                    JOptionPane.showMessageDialog(null, "Invalid number. Please choose a different number.");
                } else {
                    buttons[row][col].setEnabled(false);
                    if (bingoGame.isBingo()) {
                        JOptionPane.showMessageDialog(null, "Bingo! You won!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "The game is already finished. Please start a new game.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BingoGameGUI bingoGameGUI = new BingoGameGUI();
            bingoGameGUI.setVisible(true);
        });
    }
}

