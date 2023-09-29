import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParzialeGiornaliero extends JFrame {

    public ParzialeGiornaliero() {
        initUI();
    }

    private void initUI() {
        setSize(250, 250);
        setTitle("Parziale Giornaliero");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel incassoLabel = new JLabel("Incasso di oggi");
        incassoLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        incassoLabel.setBounds(20, 10, 200, 30);
        add(incassoLabel);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        JLabel dataLabel = new JLabel(today);
        dataLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        dataLabel.setBounds(50, 40, 150, 30);
        add(dataLabel);

        JLabel euroLabel = new JLabel("€");
        euroLabel.setFont(new Font("Courier", Font.PLAIN, 40));
        euroLabel.setBounds(20, 90, 30, 40);
        add(euroLabel);

        JLabel incassoSoldiLabel = new JLabel("0");
        incassoSoldiLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        incassoSoldiLabel.setBounds(160, 105, 50, 30);
        add(incassoSoldiLabel);

        JButton chiudiButton = new JButton("Chiudi");
        chiudiButton.setPreferredSize(new Dimension(87, 60));
        chiudiButton.setBounds(20, 170, 200, 60);
        chiudiButton.addActionListener(e -> System.exit(0));
        add(chiudiButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParzialeGiornaliero ex = new ParzialeGiornaliero();
            ex.setVisible(true);
        });
    }
}
