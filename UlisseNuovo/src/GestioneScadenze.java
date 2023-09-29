import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class GestioneScadenze extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public GestioneScadenze() {
        initializeUI();
        populateTable();
    }

    private void initializeUI() {
        this.setSize(1220, 680);
        this.setTitle("Gestione Scadenze");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Buttons
        JButton anagraficheButton = new JButton("Anagrafiche");
        anagraficheButton.setBounds(10, 10, 110, 40);
        this.add(anagraficheButton);

        JLabel gestioneScadenzeLabel = new JLabel("Gestione Scadenze");
        gestioneScadenzeLabel.setFont(new Font("Courier", Font.BOLD, 25));
        gestioneScadenzeLabel.setBounds(140, 10, 250, 30);
        this.add(gestioneScadenzeLabel);

        JButton inizioButton = new JButton("|<");
        inizioButton.setBounds(500, 10, 60, 40);
        this.add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(555, 10, 60, 40);
        this.add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(610, 10, 60, 40);
        this.add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setBounds(665, 10, 60, 40);
        this.add(fineButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setBounds(755, 10, 60, 40);
        this.add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setBounds(810, 10, 60, 40);
        this.add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setBounds(865, 10, 60, 40);
        this.add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setBounds(920, 10, 60, 40);
        this.add(abbandonaRigaButton);

        JButton filtraRowsetButton = new JButton("FR");
        filtraRowsetButton.setBounds(975, 10, 60, 40);
        this.add(filtraRowsetButton);

        JButton trovaRigaButton = new JButton("TR");
        trovaRigaButton.setBounds(1030, 10, 60, 40);
        this.add(trovaRigaButton);

        JButton rateButton = new JButton("Rate");
        rateButton.setBounds(1100, 10, 110, 40);
        this.add(rateButton);

        // Labels and Fields
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        nomeLabel.setBounds(10, 60, 50, 20);
        this.add(nomeLabel);

        JComboBox<String> nomeComboBox = new JComboBox<>();
        nomeComboBox.setBounds(10, 80, 600, 20);
        this.add(nomeComboBox);

        JLabel docNumLabel = new JLabel("Doc.Num.");
        docNumLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        docNumLabel.setBounds(455, 60, 60, 20);
        this.add(docNumLabel);

        JTextField docNumTextField = new JTextField();
        docNumTextField.setBounds(455, 80, 70, 20);
        this.add(docNumTextField);

        JLabel dataDocLabel = new JLabel("Data Doc.");
        dataDocLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        dataDocLabel.setBounds(540, 60, 60, 20);
        this.add(dataDocLabel);

        JTextField dataDocTextField = new JTextField();
        dataDocTextField.setBounds(540, 80, 70, 20);
        this.add(dataDocTextField);

        JLabel imponibileLabel = new JLabel("Imponibile");
        imponibileLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        imponibileLabel.setBounds(625, 60, 60, 20);
        this.add(imponibileLabel);

        JTextField imponibileTextField = new JTextField();
        imponibileTextField.setBounds(625, 80, 80, 20);
        this.add(imponibileTextField);

        JLabel ivaLabel = new JLabel("IVA");
        ivaLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        ivaLabel.setBounds(725, 60, 40, 20);
        this.add(ivaLabel);

        JTextField ivaTextField = new JTextField();
        ivaTextField.setBounds(725, 80, 60, 20);
        this.add(ivaTextField);

        JLabel totaleRataLabel = new JLabel("Totale Rata");
        totaleRataLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        totaleRataLabel.setBounds(810, 60, 80, 20);
        this.add(totaleRataLabel);

        JTextField totaleRataTextField = new JTextField();
        totaleRataTextField.setBounds(810, 80, 100, 20);
        this.add(totaleRataTextField);

        JLabel bancaLabel = new JLabel("Banca");
        bancaLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        bancaLabel.setBounds(925, 60, 40, 20);
        this.add(bancaLabel);

        JComboBox<String> bancaComboBox = new JComboBox<>();
        bancaComboBox.setBounds(925, 80, 100, 20);
        this.add(bancaComboBox);

        JLabel scadenzaLabel = new JLabel("Scadenza");
        scadenzaLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        scadenzaLabel.setBounds(1008, 60, 60, 20);
        this.add(scadenzaLabel);

        JTextField scadenzaTextField = new JTextField();
        scadenzaTextField.setBounds(1008, 80, 100, 20);
        this.add(scadenzaTextField);

        JLabel rataNumLabel = new JLabel("Rata Num.");
        rataNumLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        rataNumLabel.setBounds(1125, 60, 60, 20);
        this.add(rataNumLabel);

        JComboBox<String> rataNumComboBox = new JComboBox<>();
        rataNumComboBox.setBounds(1125, 80, 60, 20);
        this.add(rataNumComboBox);

        JButton aggiungiRiga2Button = new JButton("Aggiungi riga");
        aggiungiRiga2Button.setBounds(10, 110, 600, 40);
        this.add(aggiungiRiga2Button);

        JButton eliminaRiga2Button = new JButton("Elimina riga");
        eliminaRiga2Button.setBounds(620, 110, 570, 40);
        this.add(eliminaRiga2Button);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"Sel.", "Categoria", "Nome", "Num_Doc", "Data_Doc", "Imponibile",
                "IVA", "Totale", "Cod_Banca", "Data_Scad", "Num_Rata"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 160, 1180, 480);
        this.add(tableScrollPane);

        this.setVisible(true);
    }

    private void populateTable() {
        // Here, you can add data to the table from your data source.
        // You can use tableModel.addRow(Vector) or tableModel.addRow(Object[])
        // to add rows to the table.
        // Example:
        tableModel.addRow(new Object[]{"Sel.", "Cat1", "Nome1", "NumDoc1", "DataDoc1", "Imp1", "IVA1", "Tot1", "CB1", "DataScad1", "Rata1"});
        tableModel.addRow(new Object[]{"Sel.", "Cat2", "Nome2", "NumDoc2", "DataDoc2", "Imp2", "IVA2", "Tot2", "CB2", "DataScad2", "Rata2"});
        // Add more rows as needed...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestioneScadenze();
        });
    }
}
