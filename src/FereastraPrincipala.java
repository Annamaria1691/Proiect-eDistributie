import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraPrincipala extends JFrame {
    private JButton b1, b2, b3, b4,b5,b6;
    private Listener l;


    public FereastraPrincipala() {
        super("Centru de distributie");
        b1 = new JButton("Primirea marfii");
        b2 = new JButton("Expedierea marfii");
        b3 = new JButton("Furnizori");
        b4 = new JButton("Destinatari");
        b5=new JButton("Flota Autoutilitare");
        b6=new JButton("Colete");
        l = new Listener();
        b1.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        b2.addActionListener(l);
        b5.addActionListener(l);
        b6.addActionListener(l);

        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        p.add(b1);
        p.add(b3);
        p.add(b2);
        p.add(b4);
        p.add(b5);
        p.add(b6);


        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 150);
        setVisible(true);
        setResizable(false);
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                String[] expeditor = {"Persoana Fizica", "Persoana Juridica"};
                int alegere = JOptionPane.showOptionDialog(null, "Selectati tipul expeditorului:", "Tipul expeditorului", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, expeditor, expeditor[0]);
                if (alegere == 0) {
                    FereastraPrimireMarfaPersoaneFizice primireMarfaPersoaneFizice = new FereastraPrimireMarfaPersoaneFizice();
                    primireMarfaPersoaneFizice.setVisible(true);
                } else if (alegere == 1) {
                    FereastraPrimireMarfaPersoaneJuridice primireMarfa = new FereastraPrimireMarfaPersoaneJuridice();
                    primireMarfa.setVisible(true);
                }
            }

            if (e.getSource() == b3) {
                FereastraListaFurnizori listaFurnizori = new FereastraListaFurnizori();
               // FereastraListaFurnizori listaFurnizori = new FereastraListaFurnizori();
                listaFurnizori.setVisible(true);
            }
            if (e.getSource() == b4) {
                FereastraDestinatari destinatari = new FereastraDestinatari();
                destinatari.setVisible(true);
            }
            if(e.getSource()==b2){
                FereastraExpediereMarfa expediereMarfa=new FereastraExpediereMarfa();
                expediereMarfa.setVisible(true);
            }
            if(e.getSource()==b5){
                FereastraListaAutoutilitare listaAutoutilitare=new FereastraListaAutoutilitare();
                listaAutoutilitare.setVisible(true);
            }if(e.getSource()==b6){
                FereastraListaColete listaColete=new FereastraListaColete();
                listaColete.setVisible(true);
            }
        }
    }
}

