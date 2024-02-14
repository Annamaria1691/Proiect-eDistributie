import javax.swing.*;
import java.awt.*;

public class FereastraListaColete extends JFrame {
    private JLabel l1;
    private JTextArea ta;
    private JButton b1,b2;
    private ListaColete lc;

    public FereastraListaColete(){
        super("Informatii colete disponibile");
        l1 = new JLabel("Lista Colete");
        ta = new JTextArea(20, 20);
        b2 = new JButton("Sterge");
        b1=new JButton("Adauga");

        JScrollPane scroll=new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        lc=ListaColete.getInstance();
        ta.setText(lc.getInfoColet());
        ta.setEnabled(false);
        JPanel p=new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(b1);p.add(b2);

        setLayout(new BorderLayout());
        add(l1,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(p,BorderLayout.SOUTH);



        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,500);
    }

}
