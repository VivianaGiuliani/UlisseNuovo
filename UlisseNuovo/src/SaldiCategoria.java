import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class SaldiCategoria extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public SaldiCategoria() {
        initUI();
    }

    private void initUI() {
        setSize(800, 600);
        setTitle("Saldi Categoria");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton aggiornaButton = new JButton("Aggiorna");
        aggiornaButton.setBounds(10, 20, 200, 30);
        add(aggiornaButton);

        JButton saldiCategoriaButton = new JButton("Stampa saldi categoria");
        saldiCategoriaButton.setBounds(250, 20, 200, 30);
        add(saldiCategoriaButton);

        JLabel infoLabel = new JLabel("Premere aggiorna per avviare l'elaborazione");
        infoLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        infoLabel.setBounds(10, 80, 400, 20);
        add(infoLabel);

        model = new DefaultTableModel();
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 130, 780, 430);
        add(scrollPane);

        // Add columns to the table
        model.addColumn("Tipologia");
        model.addColumn("Nome");
        model.addColumn("Valore");
        model.addColumn("Peso");
        model.addColumn("Quantità");
        model.addColumn("Min_Giac");
        model.addColumn("Da ordinare");

        // Your data should be added to the table using the model.addRow() method

        // Example data (replace this with your data)
        Vector<String> row1 = new Vector<>();
        row1.add("Categoria1");
        row1.add("Prodotto1");
        row1.add("100");
        row1.add("0.5");
        row1.add("10");
        row1.add("5");
        row1.add("Yes");
        model.addRow(row1);

        Vector<String> row2 = new Vector<>();
        row2.add("Categoria2");
        row2.add("Prodotto2");
        row2.add("200");
        row2.add("0.8");
        row2.add("20");
        row2.add("10");
        row2.add("No");
        model.addRow(row2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SaldiCategoria ex = new SaldiCategoria();
            ex.setVisible(true);
        });
    }
}
