import javax.swing.*;
import java.awt.*;

public class CostiTrattamento extends JFrame {

    public CostiTrattamento() {
        setTitle("Costo Trattamenti");
        setSize(1250, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label stampa listino costo Trattamenti
        JLabel listinoCostoTrattamentiLabel = new JLabel("Listino Costo Trattamenti");
        listinoCostoTrattamentiLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        listinoCostoTrattamentiLabel.setBounds(30, 8, 300, 30);
        add(listinoCostoTrattamentiLabel);

        // Button aumento Trattamenti
        JButton aumentoTrattamentiButton = new JButton("Aumento Trattamenti");
        aumentoTrattamentiButton.setBounds(10, 50, 200, 40);
        add(aumentoTrattamentiButton);

        // TextArea
        JTextArea textbox = new JTextArea();
        textbox.setBounds(170, 52, 100, 40);
        add(textbox);

        // HBox for navigation buttons
        JPanel navigationButtons = new JPanel();
        navigationButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        navigationButtons.setBounds(870, 50, 360, 40);

        JButton inizioButton = new JButton("|<");
        JButton indietroButton = new JButton("<");
        JButton avantiButton = new JButton(">");
        JButton fineButton = new JButton(">|");
        JButton aggiungiRigaButton = new JButton("AR");
        JButton eliminaRigaButton = new JButton("ER");
        JButton salvaRigaButton = new JButton("SR");
        JButton abbandonaRigaButton = new JButton("ABR");
        JButton filtraRowsetButton = new JButton("FR");
        JButton trovaRigaButton = new JButton("TR");
        JButton ordinePerCodiceButton = new JButton("Ordine per codice");
        JButton ordineNaturaleButton = new JButton("Ordine naturale");
        JButton stampaButton = new JButton("Stampa");

        navigationButtons.add(inizioButton);
        navigationButtons.add(indietroButton);
        navigationButtons.add(avantiButton);
        navigationButtons.add(fineButton);
        navigationButtons.add(aggiungiRigaButton);
        navigationButtons.add(eliminaRigaButton);
        navigationButtons.add(salvaRigaButton);
        navigationButtons.add(abbandonaRigaButton);
        navigationButtons.add(filtraRowsetButton);
        navigationButtons.add(trovaRigaButton);
        navigationButtons.add(ordinePerCodiceButton);
        navigationButtons.add(ordineNaturaleButton);
        navigationButtons.add(stampaButton);

        add(navigationButtons);

        // Table
        String[] columns = {"Codice", "Descrizione", "Trattamenti"};
        String[][] data = new String[24][3];

        JTable table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1180, 480));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 120, 1180, 480);
        add(scrollPane);

        setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	CostiTrattamento app = new CostiTrattamento();
            app.setVisible(true);
        });
    }
}
