import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotaliMacrocategorie extends JFrame {

    private JTextField daCatTextField;
    private JTextField aCatTextField;
    private JTable table;

    public TotaliMacrocategorie() {
        initUI();
    }

    private void initUI() {
        setSize(500, 550);
        setTitle("Totali Macrocategorie");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titoloLabel = new JLabel("Totali Macrocategorie");
        titoloLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        titoloLabel.setBounds(10, 10, 200, 20);
        add(titoloLabel);

        JLabel daCatLabel = new JLabel("Da Cat.");
        daCatLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        daCatLabel.setBounds(10, 40, 200, 20);
        add(daCatLabel);

        daCatTextField = new JTextField();
        daCatTextField.setBounds(10, 70, 150, 30);
        add(daCatTextField);

        JLabel aCatLabel = new JLabel("A Cat.");
        aCatLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        aCatLabel.setBounds(180, 40, 200, 20);
        add(aCatLabel);

        aCatTextField = new JTextField();
        aCatTextField.setBounds(180, 70, 150, 30);
        add(aCatTextField);

        JButton elaborazioneButton = new JButton("Elaborazione");
        elaborazioneButton.setBounds(330, 68, 150, 35);
        add(elaborazioneButton);

        // Table
        String[] columns = {"Macro_Cat", "Valore_Tot", "Peso_Tot", "Quant_Tot"};
        Object[][] data = new Object[0][columns.length];
        DefaultTableModel model = new DefaultTableModel(data, columns);

        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 130, 460, 350);
        add(scrollPane);

        // ActionListener for the "Elaborazione" button
        elaborazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String daCatValue = daCatTextField.getText();
                String aCatValue = aCatTextField.getText();

                // Perform the "Elaborazione" action here
                // For now, we will just display a message in the table
                Object[] newRow = {"Category 1", "100", "10", "5"};
                model.addRow(newRow);

                // After processing the data, you can update the table with the results
                // For example, you can fetch data from a database based on the input values
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TotaliMacrocategorie ex = new TotaliMacrocategorie();
            ex.setVisible(true);
        });
    }
}
