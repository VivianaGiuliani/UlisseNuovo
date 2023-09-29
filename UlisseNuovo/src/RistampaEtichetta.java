import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RistampaEtichetta extends JFrame {

    public RistampaEtichetta() {
        initUI();
    }

    private void initUI() {
        setSize(300, 120);
        setTitle("Stampa Articoli");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton generaEtichetteManButton = new JButton("Genera etichette manualmente");
        generaEtichetteManButton.setBounds(10, 10, 280, 30);
        add(generaEtichetteManButton);
        generaEtichetteManButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your logic here for "Genera etichette manualmente" button action
            }
        });

        JButton generaEtichetteGiacButton = new JButton("Genera etichette per giacenza");
        generaEtichetteGiacButton.setBounds(10, 60, 280, 30);
        add(generaEtichetteGiacButton);
        generaEtichetteGiacButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your logic here for "Genera etichette per giacenza" button action
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RistampaEtichetta ex = new RistampaEtichetta();
            ex.setVisible(true);
        });
    }
}
