import javax.swing.*;
import java.awt.*;

public class Ordini extends JFrame {
    public Ordini() {
        setTitle("Magazzino Oralux");
        setSize(900, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        // Label - Ordini
        JLabel ordiniLabel = new JLabel("Ordini");
        ordiniLabel.setFont(new Font("Courier", Font.BOLD, 20));
        ordiniLabel.setBounds(400, 10, 150, 30);
        mainPanel.add(ordiniLabel);

        // Buttons
        JButton nuovoOrdineButton = new JButton("Nuovo Ordine");
        nuovoOrdineButton.setBounds(10, 50, 150, 30);
        mainPanel.add(nuovoOrdineButton);

        // Labels - N° Ordine and Data
        JLabel nOrdineLabel = new JLabel("N° Ordine");
        nOrdineLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        nOrdineLabel.setBounds(180, 50, 60, 15);
        mainPanel.add(nOrdineLabel);

        JTextField nOrdineTextbox = new JTextField();
        nOrdineTextbox.setBounds(180, 70, 100, 20);
        mainPanel.add(nOrdineTextbox);

        JLabel dataLabel = new JLabel("Data");
        dataLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        dataLabel.setBounds(290, 50, 60, 15);
        mainPanel.add(dataLabel);

        JTextField dataTextbox = new JTextField();
        dataTextbox.setBounds(290, 70, 150, 20);
        mainPanel.add(dataTextbox);

        // Labels - Fornitori
        JLabel fornitoriLabel = new JLabel("Fornitori");
        fornitoriLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        fornitoriLabel.setBounds(400, 50, 60, 15);
        mainPanel.add(fornitoriLabel);

        JComboBox<String> fornitoriCombobox = new JComboBox<>();
        fornitoriCombobox.setBounds(400, 70, 370, 20);
        mainPanel.add(fornitoriCombobox);

        // Labels - Consegna Dal and Consegna Al
        JLabel consegnaDalLabel = new JLabel("Consegna Dal");
        consegnaDalLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        consegnaDalLabel.setBounds(10, 100, 80, 15);
        mainPanel.add(consegnaDalLabel);

        JTextField consegnaDalTextbox = new JTextField();
        consegnaDalTextbox.setBounds(10, 120, 150, 20);
        mainPanel.add(consegnaDalTextbox);

        JLabel consegnaAlLabel = new JLabel("Consegna Al");
        consegnaAlLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        consegnaAlLabel.setBounds(180, 100, 80, 15);
        mainPanel.add(consegnaAlLabel);

        JTextField consegnaAlTextbox = new JTextField();
        consegnaAlTextbox.setBounds(180, 120, 150, 20);
        mainPanel.add(consegnaAlTextbox);

        // Buttons - Nuova Riga and Elimina Riga
        JButton nuovaRigaButton = new JButton("Nuova Riga");
        nuovaRigaButton.setBounds(270, 100, 150, 30);
        mainPanel.add(nuovaRigaButton);

        JButton eliminaRigaButton = new JButton("Elimina Riga");
        eliminaRigaButton.setBounds(560, 100, 150, 30);
        mainPanel.add(eliminaRigaButton);

        // Table
        JTable table = new JTable(new String[14][7], new String[]{"Quantità", "Codice", "Descrizione", "G.Cad", "Tot_Peso", "Prezzo_Un", "Tot_Riga"});
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 150, 880, 240);
        mainPanel.add(tableScrollPane);

        // Buttons - Stampa, <, and >
        JButton stampaButton = new JButton("Stampa");
        stampaButton.setBounds(10, 500, 150, 30);
        mainPanel.add(stampaButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(285, 500, 50, 30);
        mainPanel.add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(340, 500, 50, 30);
        mainPanel.add(avantiButton);

        // Labels - Totale Peso and Totale Ordine Euro
        JLabel totalePesoLabel = new JLabel("Totale Peso");
        totalePesoLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        totalePesoLabel.setBounds(500, 500, 80, 15);
        mainPanel.add(totalePesoLabel);

        JTextField totalePesoTextbox = new JTextField();
        totalePesoTextbox.setBounds(500, 520, 150, 20);
        mainPanel.add(totalePesoTextbox);

        JLabel totaleOrdineEuroLabel = new JLabel("Totale Ordine Euro");
        totaleOrdineEuroLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        totaleOrdineEuroLabel.setBounds(660, 500, 120, 15);
        mainPanel.add(totaleOrdineEuroLabel);

        JTextField totaleOrdineEuroTextbox = new JTextField();
        totaleOrdineEuroTextbox.setBounds(660, 520, 150, 20);
        mainPanel.add(totaleOrdineEuroTextbox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Ordini gui = new Ordini();
            gui.setVisible(true);
        });
    }
}
