import javax.swing.*;

public class EliminaCloni extends JFrame {

    public EliminaCloni() {
        initializeUI();
    }

    private void initializeUI() {
        // Set up the JFrame
        this.setSize(500, 300);
        this.setTitle("Elimina Cloni");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Create a JButton
        JButton elimina_riga2_button = new JButton("Aggiornamento eseguito");
        elimina_riga2_button.setBounds(130, 90, 240, 120); // Set position and size

        // Add the button to the JFrame
        this.add(elimina_riga2_button);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EliminaCloni();
        });
    }
}
