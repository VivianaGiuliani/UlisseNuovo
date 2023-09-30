import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParzialeGiornaliero {

    public ParzialeGiornaliero(int totaleScontato) {
    	JFrame window = new JFrame();
        window.setSize(400, 400);
        window.setTitle("Clienti");
        window.setResizable(false);

        JLabel incassoLabel = new JLabel("Incasso di oggi");
        incassoLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        incassoLabel.setBounds(20, 10, 200, 30);
        window.add(incassoLabel);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        JLabel dataLabel = new JLabel(today);
        dataLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        dataLabel.setBounds(50, 40, 150, 30);
        window.add(dataLabel);

        JLabel euroLabel = new JLabel("€");
        euroLabel.setFont(new Font("Courier", Font.PLAIN, 40));
        euroLabel.setBounds(20, 90, 30, 40);
        window.add(euroLabel);

        JLabel incassoSoldiLabel = new JLabel();
        incassoSoldiLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        incassoSoldiLabel.setBounds(160, 105, 50, 30);
        window.add(incassoSoldiLabel);
        incassoSoldiLabel.setText(String.valueOf(totaleScontato));

        JButton chiudiButton = new JButton("Chiudi");
        chiudiButton.setPreferredSize(new Dimension(87, 60));
        chiudiButton.setBounds(20, 170, 200, 60);
        chiudiButton.addActionListener(e -> window.dispose());
        window.add(chiudiButton);
        
        window.setLayout(null);
        window.setVisible(true);
    }
}
