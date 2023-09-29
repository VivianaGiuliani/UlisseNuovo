import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class Fornitori extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public Fornitori() {
        initializeUI();
        populateTable();
    }

    private void initializeUI() {
        this.setSize(990, 600);
        this.setTitle("Fornitori");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Label
        JLabel tabellaFornitoriLabel = new JLabel("Tabella Fornitori");
        tabellaFornitoriLabel.setFont(new Font("Courier", Font.BOLD, 20));
        tabellaFornitoriLabel.setBounds(170, 20, 250, 30);
        this.add(tabellaFornitoriLabel);

        // Buttons
        JButton aggiungiRigaButton = new JButton("Aggiungi riga");
        aggiungiRigaButton.setBounds(10, 70, 110, 40);
        this.add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("Elimina riga");
        eliminaRigaButton.setBounds(125, 70, 110, 40);
        this.add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("Salva riga");
        salvaRigaButton.setBounds(240, 70, 110, 40);
        this.add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("Abbandona");
        abbandonaRigaButton.setBounds(355, 70, 110, 40);
        this.add(abbandonaRigaButton);

        JButton filtraRowsetRigaButton = new JButton("Filtra rowset");
        filtraRowsetRigaButton.setBounds(470, 70, 110, 40);
        this.add(filtraRowsetRigaButton);

        JButton stampaRigaButton = new JButton("Stampa");
        stampaRigaButton.setBounds(11, 120, 569, 40);
        this.add(stampaRigaButton);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"CFOR", "Nome"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 180, 569, 260);
        this.add(tableScrollPane);

        // Buttons
        JButton ordinamentoButton = new JButton("Ordinamento");
        ordinamentoButton.setBounds(11, 450, 569, 40);
        this.add(ordinamentoButton);

        JButton cforButton = new JButton("C.For");
        cforButton.setBounds(125, 510, 110, 40);
        this.add(cforButton);

        JButton nomeButton = new JButton("Nome");
        nomeButton.setBounds(240, 510, 110, 40);
        this.add(nomeButton);

        JButton naturaleButton = new JButton("Naturale");
        naturaleButton.setBounds(355, 510, 110, 40);
        this.add(naturaleButton);

        this.setVisible(true);
    }

    private void populateTable() {
        // Here, you can add data to the table from your data source.
        // You can use tableModel.addRow(Vector) or tableModel.addRow(Object[])
        // to add rows to the table.
        // Example:
        tableModel.addRow(new Object[]{"CFOR1", "Nome1"});
        tableModel.addRow(new Object[]{"CFOR2", "Nome2"});
        tableModel.addRow(new Object[]{"CFOR3", "Nome3"});
        // Add more rows as needed...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Fornitori();
        });
    }
}
