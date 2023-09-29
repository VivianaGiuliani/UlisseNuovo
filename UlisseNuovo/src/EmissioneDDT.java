import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmissioneDDT extends JFrame {

    private JTextField ddtNTextField;
    private JTextField fattNTextField;
    private JTextField dataTextField;
    private JComboBox<String> destinatarioComboBox;

    public EmissioneDDT() {
        initUI();
    }

    private void initUI() {
        setSize(910, 900);
        setTitle("Emissione DDT");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Rest of the GUI components can be added similarly

        JLabel ddtFattureLabel = new JLabel("DDT e Fatture");
        ddtFattureLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        ddtFattureLabel.setBounds(340, 12, 200, 20);
        add(ddtFattureLabel);

        JLabel ddtNLabel = new JLabel("DDT N°");
        ddtNLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        ddtNLabel.setBounds(340, 55, 200, 20);
        add(ddtNLabel);

        ddtNTextField = new JTextField();
        ddtNTextField.setBounds(340, 80, 150, 30);
        add(ddtNTextField);

        JLabel fattNLabel = new JLabel("Fatt. N°");
        fattNLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        fattNLabel.setBounds(430, 55, 200, 20);
        add(fattNLabel);

        fattNTextField = new JTextField();
        fattNTextField.setBounds(430, 80, 150, 30);
        add(fattNTextField);

        JLabel dataLabel = new JLabel("Data");
        dataLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        dataLabel.setBounds(530, 55, 200, 20);
        add(dataLabel);

        dataTextField = new JTextField();
        dataTextField.setBounds(530, 80, 150, 30);
        add(dataTextField);

        JLabel destinatarioLabel = new JLabel("Destinatario");
        destinatarioLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        destinatarioLabel.setBounds(610, 55, 200, 20);
        add(destinatarioLabel);

        destinatarioComboBox = new JComboBox<>();
        destinatarioComboBox.setBounds(610, 80, 150, 30);
        add(destinatarioComboBox);

        // Rest of the GUI components can be added similarly

        JButton listinoArgenteriaButton = new JButton("Listino argenteria");
        listinoArgenteriaButton.setBounds(10, 10, 120, 35);
        add(listinoArgenteriaButton);

        JButton listinoOraluxButton = new JButton("Listino oralux");
        listinoOraluxButton.setBounds(140, 10, 120, 35);
        add(listinoOraluxButton);

        // Rest of the buttons, labels, and text boxes can be added similarly

        // ActionListener for the "Genera listino" button
        listinoArgenteriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the "Genera listino" action here
            }
        });

        // Rest of the ActionListeners for the buttons can be added similarly

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmissioneDDT ex = new EmissioneDDT();
            ex.setVisible(true);
        });
    }
}
