import javax.swing.*;
import java.awt.*;

public class FereastraDestinatari extends JFrame {
    private JLabel l1;
    private JTextArea ta;
    private JButton b1,b2,b3,b4,b5;

    public FereastraDestinatari() {
        super("Lista destinatari");
        l1 = new JLabel("Lista Destinatari");
        ta = new JTextArea(20, 20);
        b2 = new JButton("Sterge");
        b1=new JButton("Adauga");
        b3=new JButton("Adauga Destinatar Persoana Fizica");
        b4=new JButton("Adauga Destinatar Persoana Juridica");
        b5=new JButton("Editeaza");
        JPanel dreapta=new JPanel(new GridLayout(3,1));
        dreapta.add(b3);dreapta.add(b4);dreapta.add(b5);
        JPanel dreapta1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        dreapta1.add(dreapta);

        JScrollPane scroll=new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel p=new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(b1);p.add(b2);
        JPanel stanga=new JPanel(new BorderLayout());
        stanga.add(l1,BorderLayout.NORTH);
        stanga.add(scroll,BorderLayout.CENTER);
        stanga.add(p,BorderLayout.SOUTH);

        JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,stanga,dreapta1);
        add(splitPane);
        splitPane.setResizeWeight(1.0);//magie!!

        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,500);
    }
}
