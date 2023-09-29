import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MagazzinoOralux extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public MagazzinoOralux() {
        initializeUI();
        populateTable();
    }

    private void initializeUI() {
        this.setSize(1120, 600);
        this.setTitle("Magazzino Oralux");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Label
        JLabel magazzinoArgenteriaLabel = new JLabel("Magazzino Oralux");
        magazzinoArgenteriaLabel.setFont(new Font("Courier", Font.BOLD, 15));
        magazzinoArgenteriaLabel.setBounds(10, 10, 200, 30);
        this.add(magazzinoArgenteriaLabel);

        // Buttons
        JButton calcolaTotaleButton = new JButton("Calcola Totale");
        calcolaTotaleButton.setBounds(10, 50, 140, 40);
        this.add(calcolaTotaleButton);

        // Textbox
        JTextField calcolaTotaleTextBox = new JTextField();
        calcolaTotaleTextBox.setBounds(130, 52, 200, 30);
        this.add(calcolaTotaleTextBox);

        JButton stampaButton = new JButton("Stampa");
        stampaButton.setBounds(300, 50, 140, 40);
        this.add(stampaButton);

        JButton inizioButton = new JButton("|<");
        inizioButton.setBounds(530, 50, 60, 40);
        this.add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(585, 50, 60, 40);
        this.add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(640, 50, 60, 40);
        this.add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setBounds(695, 50, 60, 40);
        this.add(fineButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setBounds(770, 50, 60, 40);
        this.add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setBounds(825, 50, 60, 40);
        this.add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setBounds(880, 50, 60, 40);
        this.add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setBounds(935, 50, 60, 40);
        this.add(abbandonaRigaButton);

        JButton filtraRowsetButton = new JButton("FR");
        filtraRowsetButton.setBounds(990, 50, 60, 40);
        this.add(filtraRowsetButton);

        JButton trovaRigaButton = new JButton("TR");
        trovaRigaButton.setBounds(1045, 50, 60, 40);
        this.add(trovaRigaButton);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"Quantità", "Barcode", "Cod_Art", "Nome_Art"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(30, 110, 1060, 480);
        this.add(tableScrollPane);

        this.setVisible(true);
    }

    private void populateTable() {
        // Here, you can add data to the table from your data source.
        // You can use tableModel.addRow(Vector) or tableModel.addRow(Object[])
        // to add rows to the table.
        // Example:
        tableModel.addRow(new Object[]{"10", "Barcode1", "Cod_Art1", "Nome_Art1"});
        tableModel.addRow(new Object[]{"15", "Barcode2", "Cod_Art2", "Nome_Art2"});
        // Add more rows as needed...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MagazzinoOralux();
        });
    }
}
