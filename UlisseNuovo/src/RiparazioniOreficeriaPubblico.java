import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiparazioniOreficeriaPubblico extends JFrame {

    public RiparazioniOreficeriaPubblico() {
        initUI();
    }

    private void initUI() {
        setSize(1170, 700);
        setTitle("Riparazioni Oreficeria Privati");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel listinoPrezziOreficeriaPrivatiLabel = new JLabel("Lista Riparazioni Oreficeria Privati");
        listinoPrezziOreficeriaPrivatiLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        listinoPrezziOreficeriaPrivatiLabel.setBounds(30, 8, 500, 30);
        add(listinoPrezziOreficeriaPrivatiLabel);

        JButton stampaListinoButton = new JButton("Stampa Listino");
        stampaListinoButton.setPreferredSize(new Dimension(150, 40));
        stampaListinoButton.setBounds(900, 8, 150, 40);
        add(stampaListinoButton);

        JButton inizioButton = new JButton("|<");
        inizioButton.setPreferredSize(new Dimension(60, 40));
        inizioButton.setBounds(30, 60, 60, 40);
        add(inizioButton);

        JButton indietroButton = new JButton("<");
        indietroButton.setPreferredSize(new Dimension(60, 40));
        indietroButton.setBounds(85, 60, 60, 40);
        add(indietroButton);

        JButton avantiButton = new JButton(">");
        avantiButton.setPreferredSize(new Dimension(60, 40));
        avantiButton.setBounds(140, 60, 60, 40);
        add(avantiButton);

        JButton fineButton = new JButton(">|");
        fineButton.setPreferredSize(new Dimension(60, 40));
        fineButton.setBounds(195, 60, 60, 40);
        add(fineButton);

        JButton aggiungiRigaButton = new JButton("AR");
        aggiungiRigaButton.setPreferredSize(new Dimension(60, 40));
        aggiungiRigaButton.setBounds(270, 60, 60, 40);
        add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("ER");
        eliminaRigaButton.setPreferredSize(new Dimension(60, 40));
        eliminaRigaButton.setBounds(325, 60, 60, 40);
        add(eliminaRigaButton);

        JButton salvaRigaButton = new JButton("SR");
        salvaRigaButton.setPreferredSize(new Dimension(60, 40));
        salvaRigaButton.setBounds(380, 60, 60, 40);
        add(salvaRigaButton);

        JButton abbandonaRigaButton = new JButton("ABR");
        abbandonaRigaButton.setPreferredSize(new Dimension(60, 40));
        abbandonaRigaButton.setBounds(435, 60, 60, 40);
        add(abbandonaRigaButton);

        JButton filtraRowsetButton = new JButton("FR");
        filtraRowsetButton.setPreferredSize(new Dimension(60, 40));
        filtraRowsetButton.setBounds(490, 60, 60, 40);
        add(filtraRowsetButton);

        JButton trovaRigaButton = new JButton("TR");
        trovaRigaButton.setPreferredSize(new Dimension(60, 40));
        trovaRigaButton.setBounds(545, 60, 60, 40);
        add(trovaRigaButton);

        JButton ordinePerCodiceButton = new JButton("Ordine per codice");
        ordinePerCodiceButton.setPreferredSize(new Dimension(150, 40));
        ordinePerCodiceButton.setBounds(650, 60, 150, 40);
        add(ordinePerCodiceButton);

        JButton ordineNaturaleButton = new JButton("Ordine naturale");
        ordineNaturaleButton.setPreferredSize(new Dimension(150, 40));
        ordineNaturaleButton.setBounds(770, 60, 150, 40);
        add(ordineNaturaleButton);

        JButton aggiornaButton = new JButton("Aggiorna");
        aggiornaButton.setPreferredSize(new Dimension(150, 40));
        aggiornaButton.setBounds(890, 60, 150, 40);
        add(aggiornaButton);

        JButton stampaButton = new JButton("Stampa");
        stampaButton.setPreferredSize(new Dimension(150, 40));
        stampaButton.setBounds(1010, 60, 150, 40);
        add(stampaButton);

        JPanel tabellaFrame = new JPanel();
        tabellaFrame.setLayout(new BorderLayout());
        tabellaFrame.setBounds(30, 120, 1100, 500);
        add(tabellaFrame);

        JScrollPane scrollPane = new JScrollPane();
        tabellaFrame.add(scrollPane);

        JTable tabella = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Codice", "Descrizione", "Prezzo"}
                ));

                tabella.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tabella.getColumnModel().getColumn(0).setPreferredWidth(100);
                tabella.getColumnModel().getColumn(1).setPreferredWidth(890);
                tabella.getColumnModel().getColumn(2).setPreferredWidth(100);

                scrollPane.setViewportView(tabella);
            }

            public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                	RiparazioniOreficeriaPubblico ex = new RiparazioniOreficeriaPubblico();
                    ex.setVisible(true);
                });
            }
        }
