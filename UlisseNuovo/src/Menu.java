import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Ulisse");
        setSize(1400, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        // Button labels organized in rows and a column
        String[][] buttonLabels = {
                {"Distinte", "Etichette", "Inventario"},
                {"Clienti", "Fornitori", "Articoli", "Tab.Punti"},
                {"Saldi Categ.", "Saldi Macrocat", "Totale incisioni", "Totale magazzino", "Scadenze"},
                {"Elimina cloni", "Stampa art.", "Ordina art.", "Azzeramento", "Stampa mov.", "Ristampa etich.", "Argenteria", "Elimina cloni", "Elimina privati"},
                {"St.t.Nuova", "Costi pulitura", "Costi trattamento"},
                {"Rip.arg.pubblico", "Rip.arg.negozi", "Rip.cons.neg", "Rip.oref.pubblico", "Rip.oref.negozi"},
                {"Anagrafica aziende", "Emissione DDT", "Crea listini arg.", "Schede costi", "Listino Argenteria", "Listino Oralux", "Magazzino Oralux", "Ordinamento costi", "Ordini"},
                {"Cambia anno", "Pulizia Archivi"}
        };

        int x_pos = 30;
        int y_pos = 80;
        int buttonWidth = 150;
        int buttonHeight = 50;

        // Create and place buttons
        for (int i = 0; i < buttonLabels.length; i++) {
            for (int j = 0; j < buttonLabels[i].length; j++) {
                JButton button = new JButton(buttonLabels[i][j]);
                button.setBounds(x_pos, y_pos, buttonWidth, buttonHeight);
                mainPanel.add(button);
                x_pos += 150;
            }
            y_pos += 50;
            x_pos = 30;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Menu gui = new Menu();
            gui.setVisible(true);
        });
    }
}
