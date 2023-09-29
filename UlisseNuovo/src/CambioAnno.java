import javax.swing.*;
import java.awt.*;

public class CambioAnno {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(300, 200);
        window.setTitle("Magazzino Oralux");
        window.setResizable(false);

        JLabel cambio_anno_label = new JLabel("Cambio Anno");
        cambio_anno_label.setFont(new Font("Courier", Font.PLAIN, 15));
        cambio_anno_label.setBounds(80, 10, 200, 30);
        window.add(cambio_anno_label);

        JTextArea anno_textbox = new JTextArea();
        anno_textbox.setBounds(70, 52, 160, 40);
        window.add(anno_textbox);

        JButton esegui_button = new JButton("Esegui");
        esegui_button.setBounds(70, 100, 160, 40);
        window.add(esegui_button);

        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}