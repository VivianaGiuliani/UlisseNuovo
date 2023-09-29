import javax.swing.*;
import java.awt.*;

public class CreaListiniArgenteria extends JFrame {

    public CreaListiniArgenteria() {
        setTitle("Crea Listini Argenteria");
        setSize(400, 190);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label creazione e stampa listini clienti
        JLabel creazioneEStampaListiniClientiLabel = new JLabel("Creazione e stampa listini clienti");
        creazioneEStampaListiniClientiLabel.setFont(new Font("Courier", Font.PLAIN, 10));
        creazioneEStampaListiniClientiLabel.setBounds(60, 10, 300, 15);
        add(creazioneEStampaListiniClientiLabel);

        // Label cliente
        JLabel clienteLabel = new JLabel("Cliente");
        clienteLabel.setFont(new Font("Courier", Font.PLAIN, 9));
        clienteLabel.setBounds(10, 30, 100, 15);
        add(clienteLabel);

        // Combobox cliente
        JComboBox<String> clienteCombobox = new JComboBox<>();
        clienteCombobox.setBounds(10, 50, 260, 25);
        add(clienteCombobox);

        // Label %Ric.
        JLabel ricLabel = new JLabel("%Ric.");
        ricLabel.setFont(new Font("Courier", Font.PLAIN, 9));
        ricLabel.setBounds(290, 30, 100, 15);
        add(ricLabel);

        // Textbox %Ric.
        JTextField ricTextbox = new JTextField();
        ricTextbox.setBounds(290, 50, 90, 25);
        add(ricTextbox);

        // Button esegui
        JButton eseguiButton = new JButton("Esegui");
        eseguiButton.setBounds(10, 80, 370, 40);
        add(eseguiButton);

        setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	CreaListiniArgenteria app = new CreaListiniArgenteria();
            app.setVisible(true);
        });
    }
}

