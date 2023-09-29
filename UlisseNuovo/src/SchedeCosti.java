import javax.swing.*;
import java.awt.*;

public class SchedeCosti extends JFrame {

    public SchedeCosti() {
        initUI();
    }

    private void initUI() {
        setSize(720, 600);
        setTitle("Crea Listini Argenteria");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel schedaCostiLabel = new JLabel("Scheda Costi");
        schedaCostiLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        schedaCostiLabel.setBounds(10, 10, 150, 20);
        add(schedaCostiLabel);

        JButton eseguiButton = new JButton("Elabora");
        eseguiButton.setBounds(180, 10, 100, 30);
        add(eseguiButton);

        JButton inizioButton = new JButton("|<");
        inizioButton.setBounds(330, 10, 50, 30);
        add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(382, 10, 50, 30);
        add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(434, 10, 50, 30);
        add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setBounds(486, 10, 50, 30);
        add(fineButton);

        JButton listinoButton = new JButton("Listino");
        listinoButton.setBounds(180, 52, 100, 30);
        add(listinoButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setBounds(330, 52, 50, 30);
        add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setBounds(382, 52, 50, 30);
        add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setBounds(434, 52, 50, 30);
        add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setBounds(486, 52, 50, 30);
        add(abbandonaRigaButton);

        JButton trovaRigaButton = new JButton("TR");
        trovaRigaButton.setBounds(538, 52, 50, 30);
        add(trovaRigaButton);

        JLabel barcodeLabel = new JLabel("Barcode");
        barcodeLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        barcodeLabel.setBounds(10, 100, 100, 20);
        add(barcodeLabel);

        JTextField barcodeTextBox = new JTextField();
        barcodeTextBox.setBounds(90, 100, 150, 25);
        add(barcodeTextBox);

        // Rest of the labels and text fields are created similarly...

        // Place other labels and text fields as per the design

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SchedeCosti ex = new SchedeCosti();
            ex.setVisible(true);
        });
    }
}
