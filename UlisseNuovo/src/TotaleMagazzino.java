import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotaleMagazzino extends JFrame {

    private JTextField totGiacFissoTextField;
    private JTextField totGiacVarTextField;
    private JTextField totGiacTextField;
    private JTextField totCostoFissoTextField;
    private JTextField totCostoVarTextField;
    private JTextField totCostoTextField;

    public TotaleMagazzino() {
        initUI();
    }

    private void initUI() {
        setSize(500, 400);
        setTitle("Totale Magazzino");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titoloLabel = new JLabel("Totale Magazzino");
        titoloLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        titoloLabel.setBounds(150, 10, 200, 20);
        add(titoloLabel);

        JLabel totGiacFissoLabel = new JLabel("Totale Giacenza Fisso");
        totGiacFissoLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totGiacFissoLabel.setBounds(10, 50, 200, 20);
        add(totGiacFissoLabel);

        totGiacFissoTextField = new JTextField();
        totGiacFissoTextField.setBounds(300, 50, 150, 30);
        add(totGiacFissoTextField);

        JLabel totGiacVarLabel = new JLabel("Totale Giacenza Variabile");
        totGiacVarLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totGiacVarLabel.setBounds(10, 90, 200, 20);
        add(totGiacVarLabel);

        totGiacVarTextField = new JTextField();
        totGiacVarTextField.setBounds(300, 90, 150, 30);
        add(totGiacVarTextField);

        JLabel totGiacLabel = new JLabel("Totale Giacenza");
        totGiacLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totGiacLabel.setBounds(10, 130, 200, 20);
        add(totGiacLabel);

        totGiacTextField = new JTextField();
        totGiacTextField.setBounds(300, 130, 150, 30);
        add(totGiacTextField);

        JLabel totCostoFissoLabel = new JLabel("Totale Costo Fisso");
        totCostoFissoLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totCostoFissoLabel.setBounds(10, 170, 200, 20);
        add(totCostoFissoLabel);

        totCostoFissoTextField = new JTextField();
        totCostoFissoTextField.setBounds(300, 170, 150, 30);
        add(totCostoFissoTextField);

        JLabel totCostoVarLabel = new JLabel("Totale Costo Variabile");
        totCostoVarLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totCostoVarLabel.setBounds(10, 210, 200, 20);
        add(totCostoVarLabel);

        totCostoVarTextField = new JTextField();
        totCostoVarTextField.setBounds(300, 210, 150, 30);
        add(totCostoVarTextField);

        JLabel totCostoLabel = new JLabel("Totale Costo");
        totCostoLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        totCostoLabel.setBounds(10, 250, 200, 20);
        add(totCostoLabel);

        totCostoTextField = new JTextField();
        totCostoTextField.setBounds(300, 250, 150, 30);
        add(totCostoTextField);

        JButton aggiornaButton = new JButton("Aggiorna");
        aggiornaButton.setBounds(10, 300, 150, 35);
        add(aggiornaButton);

        JButton stampaSaldiButton = new JButton("Stampa Saldi");
        stampaSaldiButton.setBounds(170, 300, 150, 35);
        add(stampaSaldiButton);

        JButton stampaDettaglioButton = new JButton("Stampa Dettaglio");
        stampaDettaglioButton.setBounds(330, 300, 150, 35);
        add(stampaDettaglioButton);

        // ActionListener for the "Aggiorna" button
        aggiornaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the update operation for the warehouse totals
                // For example, you can fetch data from a database and update the text fields

                // For now, we will just show a dialog with a message
                JOptionPane.showMessageDialog(null, "Totale Magazzino Aggiornato!");
            }
        });

        // ActionListener for the "Stampa Saldi" button
        stampaSaldiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the operation to print the warehouse balances
                // For now, we will just show a dialog with a message
                JOptionPane.showMessageDialog(null, "Stampa Saldi");
            }
        });

        // ActionListener for the "Stampa Dettaglio" button
        stampaDettaglioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the operation to print the warehouse details
                // For now, we will just show a dialog with a message
                JOptionPane.showMessageDialog(null, "Stampa Dettaglio");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TotaleMagazzino ex = new TotaleMagazzino();
            ex.setVisible(true);
        });
    }
}
