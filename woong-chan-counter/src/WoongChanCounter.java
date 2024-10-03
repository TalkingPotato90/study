import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WoongChanCounter extends JFrame implements ActionListener {
    private JLabel[] counterLabel;
    private JButton[] nameButton;
    private int[] counters;

    public WoongChanCounter() {
        initializeUI();
    }

    private void initializeUI() {
        counters = new int[4];
        counterLabel = new JLabel[4];
        nameButton = new JButton[4];
        setTitle("웅찬 카운터");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 600);
        setLayout(null);

        String path = "D:\\dev\\src\\woongchanCounter\\src\\";
        String[] imagePaths = {path + "woongchan.png", path + "flushKim.png", path + "thing.png", path + "kimisisi.png"};

        int buttonWidth = 200;
        int buttonHeight = 100;
        int startY = 50;

        for (int i = 0; i < 4; i++) {
            counterLabel[i] = new JLabel("횟수 : " + counters[i]);
            counterLabel[i].setFont(new Font("맑은 고딕", Font.PLAIN, 25));
            nameButton[i] = new JButton();
            nameButton[i].setBounds(50, startY + i * (buttonHeight + 20), buttonWidth, buttonHeight);
            nameButton[i].addActionListener(this);

            ImageIcon icon = new ImageIcon(imagePaths[i]);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            nameButton[i].setIcon(scaledIcon);
            nameButton[i].setText("");

            counterLabel[i].setBounds(300, startY + i * (buttonHeight + 20), 120, 50);

            add(counterLabel[i]);
            add(nameButton[i]);
        }

        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < nameButton.length; i++) {
            if (e.getSource() == nameButton[i]) {
                counters[i]++;
                counterLabel[i].setText("횟수 : " + counters[i]);
            }
        }
    }
}
