import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorAritmatika extends JFrame implements ActionListener {
    JTextField text1, text2;
    JLabel labelEquals, labelHasil;
    JButton btnTambah, btnKurang, btnKali, btnBagi, btnModulus;

    public KalkulatorAritmatika() {
        setTitle("Kalkulator Aritmatika");
        setSize(400, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); 

        text1 = new JTextField();
        text1.setBounds(20, 20, 100, 30);
        add(text1);

        text2 = new JTextField();
        text2.setBounds(130, 20, 100, 30);
        add(text2);

        labelEquals = new JLabel("=");
        labelEquals.setBounds(240, 20, 20, 30);
        add(labelEquals);

        labelHasil = new JLabel("Hasil");
        labelHasil.setFont(new Font("Arial", Font.BOLD, 14));
        labelHasil.setBounds(270, 20, 100, 30);
        add(labelHasil);

        btnTambah = new JButton("+");
        btnTambah.setBounds(60, 70, 260, 30);
        btnTambah.addActionListener(this);
        add(btnTambah);

        btnKurang = new JButton("-");
        btnKurang.setBounds(60, 110, 260, 30);
        btnKurang.addActionListener(this);
        add(btnKurang);

        btnKali = new JButton("*");
        btnKali.setBounds(60, 150, 260, 30);
        btnKali.addActionListener(this);
        add(btnKali);

        btnBagi = new JButton("/");
        btnBagi.setBounds(60, 190, 260, 30);
        btnBagi.addActionListener(this);
        add(btnBagi);

        btnModulus = new JButton("Modulus");
        btnModulus.setBounds(60, 230, 260, 30);
        btnModulus.addActionListener(this);
        add(btnModulus);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            double hasil = 0;

            if (e.getSource() == btnTambah) {
                hasil = num1 + num2;
            } else if (e.getSource() == btnKurang) {
                hasil = num1 - num2;
            } else if (e.getSource() == btnKali) {
                hasil = num1 * num2;
            } else if (e.getSource() == btnBagi) {
                if (num2 == 0) {
                    labelHasil.setText("∞");
                    return;
                }
                hasil = num1 / num2;
            } else if (e.getSource() == btnModulus) {
                hasil = num1 % num2;
            }

            labelHasil.setText(String.valueOf(hasil));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new KalkulatorAritmatika();
    }
}
