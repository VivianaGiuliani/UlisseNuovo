import javax.swing.*;
import java.awt.*;

public class CostiPulitura extends JFrame {
    public CostiPulitura() {
        setSize(1250, 700);
        setTitle("Costi Pulitura");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel listinoCostoPulituraLabel = new JLabel("Listino Costo Pulitura");
        listinoCostoPulituraLabel.setFont(new Font("Courier", Font.BOLD, 20));
        listinoCostoPulituraLabel.setBounds(30, 8, 300, 30);
        add(listinoCostoPulituraLabel);

        JButton aumentoPulituraButton = new JButton("Aumento pulitura");
        aumentoPulituraButton.setBounds(10, 50, 200, 40);
        add(aumentoPulituraButton);

        JTextArea textbox = new JTextArea();
        textbox.setBounds(170, 52, 100, 40);
        add(textbox);

        JButton inizioButton = new JButton("|<");
        inizioButton.setBounds(280, 50, 60, 40);
        add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setBounds(335, 50, 60, 40);
        add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setBounds(390, 50, 60, 40);
        add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setBounds(445, 50, 60, 40);
        add(fineButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setBounds(515, 50, 60, 40);
        add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setBounds(570, 50, 60, 40);
        add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setBounds(625, 50, 60, 40);
        add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setBounds(680, 50, 60, 40);
        add(abbandonaRigaButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CostiPulitura();
    }
}