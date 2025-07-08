import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame implements ActionListener {
    JTextField angka1, angka2, jawaban;
    JButton btnCheck, btnReset;
    JLabel labelHasil;
    int nilai1, nilai2;

    public KuisPenjumlahan() {
        setTitle("Game Kuis Penjumlahan");
        setSize(420, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(null);

        generateSoalBaru();

        angka1 = new JTextField(String.valueOf(nilai1));
        angka1.setBounds(40, 30, 50, 30);
        angka1.setEditable(false);
        angka1.setHorizontalAlignment(JTextField.CENTER);
        add(angka1);

        angka2 = new JTextField(String.valueOf(nilai2));
        angka2.setBounds(110, 30, 50, 30);
        angka2.setEditable(false);
        angka2.setHorizontalAlignment(JTextField.CENTER);
        add(angka2);

        JLabel labelEquals = new JLabel("=");
        labelEquals.setBounds(170, 30, 20, 30);
        add(labelEquals);

        jawaban = new JTextField();
        jawaban.setBounds(200, 30, 70, 30);
        jawaban.setHorizontalAlignment(JTextField.CENTER);
        add(jawaban);

        btnCheck = new JButton("CHECK");
        btnCheck.setBounds(70, 80, 120, 30);
        btnCheck.addActionListener(this);
        add(btnCheck);

        btnReset = new JButton("RESET");
        btnReset.setBounds(210, 80, 120, 30);
        btnReset.addActionListener(this);
        add(btnReset);

        labelHasil = new JLabel("");
        labelHasil.setBounds(60, 130, 300, 30);
        labelHasil.setFont(new Font("Arial", Font.BOLD, 14));
        add(labelHasil);

        setVisible(true);
    }

    private void generateSoalBaru() {
        Random rand = new Random();
        nilai1 = rand.nextInt(10) + 1;
        nilai2 = rand.nextInt(10) + 1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            try {
                int inputJawaban = Integer.parseInt(jawaban.getText());
                int hasilBenar = nilai1 + nilai2;

                if (inputJawaban == hasilBenar) {
                    labelHasil.setText("Selamat Jawaban Anda Benar !!! " + hasilBenar);
                    labelHasil.setForeground(Color.GREEN.darker());
                    getContentPane().setBackground(Color.GREEN.brighter());
                } else {
                    labelHasil.setText("Maaf, Jawaban Anda Salah");
                    labelHasil.setForeground(Color.RED);
                    getContentPane().setBackground(Color.RED.brighter());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReset) {
            generateSoalBaru();

            angka1.setText(String.valueOf(nilai1));
            angka2.setText(String.valueOf(nilai2));

            jawaban.setText("");
            labelHasil.setText("");

            getContentPane().setBackground(null);
        }
    }

    public static void main(String[] args) {
        new KuisPenjumlahan();
    }
}
