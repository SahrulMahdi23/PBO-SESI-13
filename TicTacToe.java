import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    private final JButton[][] buttons = new JButton[3][3];
    private final JLabel statusLabel;
    private final JButton resetButton;

    private boolean isXTurn = true;
    private boolean gameOver = false;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel untuk papan permainan
        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        Font buttonFont = new Font("Arial", Font.BOLD, 36);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(buttonFont);
                buttons[i][j].setBackground(Color.DARK_GRAY);
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].addActionListener(this);
                gamePanel.add(buttons[i][j]);
            }
        }

        // Label status di bagian atas
        statusLabel = new JLabel("Turn: X", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.LIGHT_GRAY);
        statusLabel.setPreferredSize(new Dimension(400, 40));

        // Tombol reset di bagian bawah
        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.setPreferredSize(new Dimension(400, 40));
        resetButton.addActionListener(e -> resetGame());

        add(statusLabel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // agar muncul di tengah layar
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        JButton clicked = (JButton) e.getSource();

        if (!clicked.getText().isEmpty()) return;

        if (isXTurn) {
            clicked.setText("X");
            clicked.setForeground(Color.CYAN);
        } else {
            clicked.setText("O");
            clicked.setForeground(Color.ORANGE);
        }

        if (checkWin()) {
            gameOver = true;
            statusLabel.setText("Winner: " + (isXTurn ? "X" : "O"));
            statusLabel.setBackground(Color.GREEN);
        } else if (checkDraw()) {
            gameOver = true;
            statusLabel.setText("Draw!");
            statusLabel.setBackground(Color.YELLOW);
        } else {
            isXTurn = !isXTurn;
            statusLabel.setText("Turn: " + (isXTurn ? "X" : "O"));
        }
    }

    private boolean checkWin() {
        String symbol = isXTurn ? "X" : "O";

        // Cek baris dan kolom
        for (int i = 0; i < 3; i++) {
            if (symbol.equals(buttons[i][0].getText()) &&
                symbol.equals(buttons[i][1].getText()) &&
                symbol.equals(buttons[i][2].getText())) return true;

            if (symbol.equals(buttons[0][i].getText()) &&
                symbol.equals(buttons[1][i].getText()) &&
                symbol.equals(buttons[2][i].getText())) return true;
        }

        // Cek diagonal
        if (symbol.equals(buttons[0][0].getText()) &&
            symbol.equals(buttons[1][1].getText()) &&
            symbol.equals(buttons[2][2].getText())) return true;

        if (symbol.equals(buttons[0][2].getText()) &&
            symbol.equals(buttons[1][1].getText()) &&
            symbol.equals(buttons[2][0].getText())) return true;

        return false;
    }

    private boolean checkDraw() {
        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                if (btn.getText().isEmpty()) return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                btn.setText("");
                btn.setForeground(Color.WHITE);
            }
        }

        isXTurn = true;
        gameOver = false;
        statusLabel.setText("Turn: X");
        statusLabel.setBackground(Color.LIGHT_GRAY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
