import javax.swing.*;
import java.awt.*;

public class StampaArticoli extends JFrame {

    public StampaArticoli() {
        initUI();
    }

    private void initUI() {
        setSize(500, 200);
        setTitle("Stampa Articoli");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel stampaMacrocategorieLabel = new JLabel("Stampa articoli per macrocategorie");
        stampaMacrocategorieLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        stampaMacrocategorieLabel.setBounds(30, 8, 300, 20);
        add(stampaMacrocategorieLabel);

        JLabel daLabel = new JLabel("Da");
        daLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        daLabel.setBounds(40, 35, 50, 20);
        add(daLabel);

        JTextField daTextbox = new JTextField();
        daTextbox.setBounds(40, 65, 100, 25);
        add(daTextbox);

        JLabel aLabel = new JLabel("A");
        aLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        aLabel.setBounds(150, 35, 50, 20);
        add(aLabel);

        JTextField aTextbox = new JTextField();
        aTextbox.setBounds(150, 65, 100, 25);
        add(aTextbox);

        JButton stampaButton = new JButton("Stampa");
        stampaButton.setBounds(280, 62, 150, 30);
        add(stampaButton);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StampaArticoli ex = new StampaArticoli();
            ex.setVisible(true);
        });
    }
}
