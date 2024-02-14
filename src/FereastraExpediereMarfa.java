import javax.swing.*;
import java.awt.*;

public class FereastraExpediereMarfa extends JFrame {
    private JLabel l1,l2,l3,l4,l5,l6;
    private JButton b1,b2,b3,b4,b5;
    private JTextField tf1,tf2,tf3,tf4,tf5;
    private JTextArea ta;
    private JComboBox cb;

    public FereastraExpediereMarfa(){
        super("Expediere noua");
        ListaFurnizori listaFurnizori=ListaFurnizori.getInstance();
        l1=new JLabel("Selecteaza destinatarul: ");//+ cb
        l2=new JLabel("Selecteaza coletul:");
        l3=new JLabel("Pret transport: ");
        l4=new JLabel("Pret total:");
        l5=new JLabel("Transport nr.:");
        l6=new JLabel("Data:");
        ta=new JTextArea(20,30);
        tf1=new JTextField(10);
        tf2=new JTextField(10);
        tf3=new JTextField(10);
        tf4=new JTextField(10);
        tf5=new JTextField(10);
        b1=new JButton("...");
        b2=new JButton("...");
        b3=new JButton("Tipareste foaia de parcurs");
        b4=new JButton("Tipareste Factura");
        b5=new JButton("Sterge");
        cb=new JComboBox<>();



        JPanel p=new JPanel(new GridLayout(6,2,10,10));
        p.add(l1);p.add(cb);
        p.add(l2);p.add(b1);
        p.add(l3);p.add(tf1);
        p.add(l4);p.add(tf2);
        p.add(l5);p.add(b2);
        p.add(l6);p.add(tf3);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Comanda noua"));

        JPanel p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(b5);p1.add(b3);p1.add(b4);

      //  JPanel p2=new JPanel();
       // setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
      //  p2.add(ta);p2.add(p1);

        setLayout(new BorderLayout());
        add(p,BorderLayout.NORTH);
        add(ta,BorderLayout.CENTER);
        add(p1,BorderLayout.SOUTH);


        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }



}
