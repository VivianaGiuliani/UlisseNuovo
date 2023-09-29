import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RistampaDistinta extends JFrame {

    private JTextField numeroDistintaTextField;

    public RistampaDistinta() {
        initUI();
    }

    private void initUI() {
        setSize(250, 170);
        setTitle("Ristampa Distinta");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel ristampaDistintaLabel = new JLabel("Ristampa Distinta");
        ristampaDistintaLabel.setFont(new Font("Courier", Font.PLAIN, 16));
        ristampaDistintaLabel.setBounds(10, 10, 150, 20);
        add(ristampaDistintaLabel);

        numeroDistintaTextField = new JTextField();
        numeroDistintaTextField.setBounds(10, 50, 150, 30);
        add(numeroDistintaTextField);

        JButton confermaButton = new JButton("Conferma");
        confermaButton.setBounds(138, 48, 100, 32);
        add(confermaButton);
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDistinta = numeroDistintaTextField.getText();
                // Implement your logic here for the Conferma button action
            }
        });

        JButton stampaDistintaButton = new JButton("Stampa Distinta");
        stampaDistintaButton.setBounds(11, 100, 225, 50);
        add(stampaDistintaButton);
        stampaDistintaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your logic here for the Stampa Distinta button action
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RistampaDistinta ex = new RistampaDistinta();
            ex.setVisible(true);
        });
    }
}
