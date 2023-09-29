import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotaleIncisioni extends JFrame {

    private JTextField daDataTextField;
    private JTextField aDataTextField;
    private JButton calcolaButton;

    public TotaleIncisioni() {
        initUI();
    }

    private void initUI() {
        setSize(800, 300);
        setTitle("Totale Incisioni");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titoloLabel = new JLabel("Totale Incisioni");
        titoloLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        titoloLabel.setBounds(10, 10, 200, 20);
        add(titoloLabel);

        JLabel daDataLabel = new JLabel("Da Data");
        daDataLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        daDataLabel.setBounds(10, 40, 100, 20);
        add(daDataLabel);

        daDataTextField = new JTextField();
        daDataTextField.setBounds(10, 70, 150, 30);
        add(daDataTextField);

        JLabel aDataLabel = new JLabel("A Data");
        aDataLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        aDataLabel.setBounds(180, 40, 100, 20);
        add(aDataLabel);

        aDataTextField = new JTextField();
        aDataTextField.setBounds(180, 70, 150, 30);
        add(aDataTextField);

        calcolaButton = new JButton("Calcola");
        calcolaButton.setBounds(330, 68, 100, 35);
        add(calcolaButton);

        JLabel totaleLabel = new JLabel("Totale");
        totaleLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totaleLabel.setBounds(620, 40, 100, 20);
        add(totaleLabel);

        // ActionListener for the button
        calcolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String daData = daDataTextField.getText();
                String aData = aDataTextField.getText();

                // Perform the calculation based on the date range
                // For example, you can fetch data from a database and calculate the total

                // For now, we will just show a dialog with the entered dates
                JOptionPane.showMessageDialog(null, "Da Data: " + daData + "\nA Data: " + aData);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TotaleIncisioni ex = new TotaleIncisioni();
            ex.setVisible(true);
        });
    }
}
