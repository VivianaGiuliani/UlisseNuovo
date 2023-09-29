import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListinoOralux extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public ListinoOralux() {
        initializeUI();
        populateTable();
    }

    private void initializeUI() {
        this.setSize(1120, 600);
        this.setTitle("Listino Oralux");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Label
        JLabel listinoArgenteriaLabel = new JLabel("Listino Oralux");
        listinoArgenteriaLabel.setFont(new Font("Courier", Font.BOLD, 15));
        listinoArgenteriaLabel.setBounds(10, 10, 200, 30);
        this.add(listinoArgenteriaLabel);

        // Buttons
        JButton stampaListinoButton = new JButton("Stampa Listino");
        stampaListinoButton.setBounds(190, 8, 140, 40);
        this.add(stampaListinoButton);

        JButton aumentaListinoButton = new JButton("Aumenta Listino");
        aumentaListinoButton.setBounds(310, 8, 140, 40);
        this.add(aumentaListinoButton);

        // Textbox
        JTextField aumentaListinoTextBox = new JTextField();
        aumentaListinoTextBox.setBounds(430, 10, 100, 30);
        this.add(aumentaListinoTextBox);

        JButton inizioButton = new JButton("|<");
        inizioButton.setBounds(530, 8, 60, 40);
        this.add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(585, 8, 60, 40);
        this.add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(640, 8, 60, 40);
        this.add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setBounds(695, 8, 60, 40);
        this.add(fineButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setBounds(770, 8, 60, 40);
        this.add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setBounds(825, 8, 60, 40);
        this.add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setBounds(880, 8, 60, 40);
        this.add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setBounds(935, 8, 60, 40);
        this.add(abbandonaRigaButton);

        JButton filtraRowsetButton = new JButton("FR");
        filtraRowsetButton.setBounds(990, 8, 60, 40);
        this.add(filtraRowsetButton);

        JButton trovaRigaButton = new JButton("TR");
        trovaRigaButton.setBounds(1045, 8, 60, 40);
        this.add(trovaRigaButton);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"Barcode", "Cod_Art", "Nome_Art", "Vendita"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(30, 60, 1060, 500);
        this.add(tableScrollPane);

        this.setVisible(true);
    }

    private void populateTable() {
        // Here, you can add data to the table from your data source.
        // You can use tableModel.addRow(Vector) or tableModel.addRow(Object[])
        // to add rows to the table.
        // Example:
        tableModel.addRow(new Object[]{"Barcode1", "Cod_Art1", "Nome_Art1", "Vendita1"});
        tableModel.addRow(new Object[]{"Barcode2", "Cod_Art2", "Nome_Art2", "Vendita2"});
        // Add more rows as needed...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListinoOralux();
        });
    }
}
