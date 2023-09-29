import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabellaPunti extends JFrame {

    private JSpinner puntiAcquistoSpinner;
    private JSpinner valorePuntiSpinner;
    private JButton salvaButton;

    public TabellaPunti() {
        initUI();
    }

    private void initUI() {
        setSize(380, 200);
        setTitle("Tabella Punti");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel puntiAcquistoLabel = new JLabel("Punti Acquisto");
        puntiAcquistoLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        puntiAcquistoLabel.setBounds(30, 30, 100, 20);
        add(puntiAcquistoLabel);

        SpinnerModel puntiAcquistoModel = new SpinnerNumberModel(0, 0, 100, 1);
        puntiAcquistoSpinner = new JSpinner(puntiAcquistoModel);
        puntiAcquistoSpinner.setBounds(30, 60, 100, 30);
        add(puntiAcquistoSpinner);

        JLabel valorePuntiLabel = new JLabel("Valore punti");
        valorePuntiLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        valorePuntiLabel.setBounds(200, 30, 100, 20);
        add(valorePuntiLabel);

        SpinnerModel valorePuntiModel = new SpinnerNumberModel(0, 0, 100, 1);
        valorePuntiSpinner = new JSpinner(valorePuntiModel);
        valorePuntiSpinner.setBounds(200, 60, 100, 30);
        add(valorePuntiSpinner);

        salvaButton = new JButton("Salva");
        salvaButton.setBounds(130, 100, 100, 30);
        add(salvaButton);

        // ActionListener for the button
        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int puntiAcquistoValue = (int) puntiAcquistoSpinner.getValue();
                int valorePuntiValue = (int) valorePuntiSpinner.getValue();

                // Perform the desired action with the entered values
                // For example, you can save the values to a file or database
                System.out.println("Punti Acquisto: " + puntiAcquistoValue);
                System.out.println("Valore punti: " + valorePuntiValue);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TabellaPunti ex = new TabellaPunti();
            ex.setVisible(true);
        });
    }
}
