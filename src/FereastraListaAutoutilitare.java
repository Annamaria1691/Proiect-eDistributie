import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.TreeSet;

public class FereastraListaAutoutilitare extends JFrame {
    JPanel p;
    public FereastraListaAutoutilitare(){
        super("Informatii");
        p=new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Disponibilitate Autoutilitare"));
        add(p);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,200);
        afisareInformatiiAutoutilitara();
    }
    private void afisareInformatiiAutoutilitara(){
        ListaAutoutilitare listaAutoutilitare= ListaAutoutilitare.getInstance();
        TreeSet<Autoutilitara>autoutilitare=listaAutoutilitare.getAutoutilitara();

        Object[][] data=new Object[autoutilitare.size()][4];
        int rand=0;
        for(Autoutilitara a:autoutilitare){
            if(rand>=6) break;
            data[rand][0]=a.getNume();
            data[rand][1]=a.getNumar();
            data[rand][2]=a.getGabarit();
            data[rand][3]=a.getStare();
            rand++;
        }
        String [] numeColoane={"Nume","Numar","Gabarit(in kg)","Stare"};
        DefaultTableModel tableModel=new DefaultTableModel(data,numeColoane);
        JTable tabel=new JTable(tableModel);
        JScrollPane scrollPane=new JScrollPane(tabel);
        p.add(scrollPane,BorderLayout.CENTER);

    }


}
