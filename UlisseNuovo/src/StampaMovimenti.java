import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StampaMovimenti extends JFrame {

    private JCheckBox carichiCheckbox;
    private JCheckBox venditeCheckbox;
    private JTextField textField;
    private JButton stampaButton;

    public StampaMovimenti() {
        initUI();
    }

    private void initUI() {
        setSize(450, 120);
        setTitle("Stampa Movimenti");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        carichiCheckbox = new JCheckBox("Carichi");
        carichiCheckbox.setBounds(20, 30, 100, 20);
        add(carichiCheckbox);

        venditeCheckbox = new JCheckBox("Vendite");
        venditeCheckbox.setBounds(20, 60, 100, 20);
        add(venditeCheckbox);

        textField = new JTextField();
        textField.setBounds(100, 40, 100, 30);
        add(textField);

        stampaButton = new JButton("Stampa");
        stampaButton.setBounds(200, 40, 100, 30);
        add(stampaButton);

        // ActionListener for the button
        stampaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the selected checkbox values
                boolean carichiSelected = carichiCheckbox.isSelected();
                boolean venditeSelected = venditeCheckbox.isSelected();

                // Retrieve the text from the text field
                String textValue = textField.getText();

                // Perform the desired action with the selected values and text
                // For example, you can print the selected values and text to console
                System.out.println("Carichi: " + carichiSelected);
                System.out.println("Vendite: " + venditeSelected);
                System.out.println("Text Value: " + textValue);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StampaMovimenti ex = new StampaMovimenti();
            ex.setVisible(true);
        });
    }
}
