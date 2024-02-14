import org.apache.poi.xwpf.usermodel.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
public class FereastraPrimireMarfaPersoaneJuridice extends JFrame {
   private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
   private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    private JButton b1,b2,b3,b4;
    private JComboBox cb;
    private JTable tb;
    private ListaColete listaColete;
    private Ascultator ascultator;

    public FereastraPrimireMarfaPersoaneJuridice(){
        super("Primirea Marfii Persoane Juridice");
        l1=new JLabel();
        l6=new JLabel();

        l2=new JLabel("Nume:");
        l3=new JLabel("Sediul:");
        l4=new JLabel("Cont Bancar:");
        l5=new JLabel("Numar Colete:");
        l7=new JLabel("Cod de Inregistrare Fiscala:");
        l8=new JLabel("Nr.ord.reg.com.");
        l9=new JLabel("Judetul:");
        l10=new JLabel("Nr. Telefon:");
        String[] listaJudete={"Bucuresti Sectorul 1","Bucuresti Sectorul 2","Bucuresti Sectorul 3","Bucuresti Sectorul 4","Bucuresti Sectorul 5","Bucuresti Sectorul 6","Alba",
        "Arad","Arges","Bacău","Bihor","Bistriţa-Năsăud","Botoşani","Braşov","Brăila","Buzău","Caraş-Severin","Călăraşi","Cluj","Constanţa","Covasna","Dâmboviţa","Dolj",
        "Galaţi","Giurgiu","Gorj","Harghita","Hunedoara","Ialomiţa","Iaşi","Ilfov","Maramureş","Mehedinţi","Mureş","Neamţ","Olt","Prahova","Satu Mare","Sălaj","Sibiu","Suceava",
        "Teleorman","Timiş","Tulcea","Vâlcea","Vaslui","Vrancea"};
        String[] continutColet={"Imbracaminte","Incaltaminte","Electronice","Electrocasnice","Bunuri perisabile","Bunuri fragile","Documente","Materiale promo","Unelte","Pomi"};
        listaColete = ListaColete.getInstance();
        cb=new JComboBox<>(listaJudete);
        tf1=new JTextField(20);
        tf2=new JTextField("RO ",20);
        tf3=new JTextField(20);
        tf4=new JTextField(20);
        tf5=new JTextField(20);
        tf6=new JTextField(20);
        tf7=new JTextField(20);
        b1=new JButton("Nota Intrare Receptie");
        b2=new JButton("Salveaza");
        b3=new JButton("Sterge");
        ascultator=new Ascultator();
        b2.addActionListener(ascultator);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randSelectat = tb.getSelectedRow();
                if (randSelectat != -1) {
                    DefaultTableModel model = (DefaultTableModel) tb.getModel();
                    model.removeRow(randSelectat);
                    listaColete.getColet().removeIf(colet -> colet.getNumar() == randSelectat + 1);
                    renumeroteazaPachete();
                    actualizeazaNumarPachete();
                } else {
                    JOptionPane.showMessageDialog(null, "Selectează o linie pentru a o șterge.", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        String column[]={"Numar pachet","Destinatie"};
        tb= new JTable(5,7);
        JTableHeader header = tb.getTableHeader();
        header.getColumnModel().getColumn(0).setHeaderValue("Pachet Numar");
        header.getColumnModel().getColumn(1).setHeaderValue("Destinatie");
        header.getColumnModel().getColumn(2).setHeaderValue("Prioritate");
        header.getColumnModel().getColumn(3).setHeaderValue("Valoare declarata (LEI)");
        header.getColumnModel().getColumn(4).setHeaderValue("Greutate (GRAME)");
        header.getColumnModel().getColumn(5).setHeaderValue("Continut colet");
        header.getColumnModel().getColumn(6).setHeaderValue("Expeditor");

        Colet.StareColet[] prioritateOptions= Colet.StareColet.values();
        String[] prioritateDescriptions=new String[prioritateOptions.length];
        for(int i=0;i<prioritateDescriptions.length;i++){
            prioritateDescriptions[i]=prioritateOptions[i].getDescriere();
        }
        DefaultCellEditor prioritateEditor=new DefaultCellEditor(new JComboBox<>(prioritateDescriptions));
        tb.getColumnModel().getColumn(2).setCellEditor(prioritateEditor);
        DefaultCellEditor zona=new DefaultCellEditor(new JComboBox<>(listaJudete));
        tb.getColumnModel().getColumn(1).setCellEditor(zona);
        DefaultCellEditor continut=new DefaultCellEditor(new JComboBox<>(continutColet));
        tb.getColumnModel().getColumn(5).setCellEditor(continut);
        tb.getColumnModel().getColumn(3).setCellRenderer(new PersistentColorEditor());
        tb.getColumnModel().getColumn(4).setCellRenderer(new PersistentColorEditor());

        tf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tf1.getText();
                DefaultTableModel model = (DefaultTableModel) tb.getModel();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    model.setValueAt(input, i, 6);
                }
            }
        });


        JPanel p=new JPanel(new GridLayout(4,2));
        p.add(l2);p.add(tf1);
        p.add(l9);p.add(cb);
        p.add(l8);p.add(tf3);
        p.add(l3);p.add(tf4);
        p.add(l7);p.add(tf2);
        p.add(l10);p.add(tf7);
        p.add(l4);p.add(tf6);
        p.add(l5);p.add(tf5);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Introduceti datele furnizorului"));
        tf3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=tf3.getText();
                if(input.length()<10||input.length()>13){
                    JOptionPane.showMessageDialog(null,"Nu ati introdus corecta datele!","Information",JOptionPane.INFORMATION_MESSAGE);
                    tf3.setText(" ");
                }
            }
        });
        tf2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(tf2.getText().length()!=11){
                JOptionPane.showMessageDialog(null,"Nu ati introdus corecta datele!","Information",JOptionPane.INFORMATION_MESSAGE);
                tf2.setText(" ");
            }
            }
        });
        tf5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numarPachete=Integer.parseInt(tf5.getText());
                generareRanduri(numarPachete,"P.J.");
            }
        });
        tf6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=tf6.getText();
                try{
                    verificaContBancar(input);
                    String formatat=formateazaCodBancar(input);
                    String transfMaj=formatat.toUpperCase();
                    tf6.setText(transfMaj);
                }catch(StringIndexOutOfBoundsException exept){
                    JOptionPane.showMessageDialog(null,"Reintroduceti numarul contului!");
                    tf6.setText("");
                }
            }
        });
        tf7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=tf7.getText();
                String nrFormatat=formateazaNrTel(input);
                tf7.setText(nrFormatat);
                if(nrFormatat==null){
                    JOptionPane.showMessageDialog(null,"Nu ati introdus corect numarul de telefon!","Information",JOptionPane.INFORMATION_MESSAGE);
                    tf7.setText(" ");
                }
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File nirFile = new File("notaIntrareReceptie.docx");
                if (!nirFile.exists()) {
                    try {
                        if (!nirFile.createNewFile())
                            JOptionPane.showMessageDialog(null, "Fisierul NIR nu a putut fi creat");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        XWPFDocument document = new XWPFDocument();
                        XWPFParagraph headerParagraph = document.createParagraph();
                        XWPFRun headerRun = headerParagraph.createRun();
                        headerRun.setText("S.C.Firma de curierat S.R.L.");
                        headerRun.addBreak();
                        headerRun.setText("Nr. ord.registru com: J40/372/2000");
                        headerRun.addBreak();
                        headerRun.setText("C.I.F.: RO 14399841");
                        headerRun.addBreak();
                        headerRun.setText("Cont: RO26 TREZ 7005 069X XX00 1637");
                        headerRun.addBreak();
                        headerRun.setText("Banca: Trezoreria Municipiului Bucuresti");
                        headerRun.addBreak();
                        headerRun.setText("Sediul: 36 Grivitei, Constanta, 900123");
                        headerRun.addBreak();
                        headerRun.setText("Telefon: +40 721367468");
                        headerRun.addBreak();
                        XWPFParagraph title = document.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun titleRun = title.createRun();
                        titleRun.setText("Nota Intrare Receptie"+" Seria N."+ FileWriterUtil.getNumarNIR());
                        titleRun.setBold(true);
                        titleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
                        titleRun.setFontSize(20);
                        titleRun.addBreak();
                        XWPFTable packagesTable = document.createTable(tb.getRowCount() + 1, tb.getColumnCount());
                        JTableHeader tableHeader = tb.getTableHeader();
                        for (int i = 0; i < tb.getColumnCount(); i++) {
                            String columnHeader = tableHeader.getColumnModel().getColumn(i).getHeaderValue().toString();
                            packagesTable.getRow(0).getCell(i).setText(columnHeader);
                        }
                        for (int i = 0; i < tb.getRowCount(); i++) {
                            for (int j = 0; j < tb.getColumnCount(); j++) {
                                Object cellValue = tb.getValueAt(i, j);
                                packagesTable.getRow(i + 1).getCell(j).setText(cellValue != null ? cellValue.toString() : "");
                            }
                        }
                        XWPFParagraph footer=document.createParagraph();
                        XWPFRun footerRun=footer.createRun();
                        footerRun.addBreak();
                        footerRun.setText("Nume Reprez. Depozit: ");
                        footerRun.addBreak();
                        footerRun.setText("Semnatura: ");
                        footerRun.addBreak();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        footerRun.setText("Data: "+ (dtf.format(now)));
                        FileOutputStream outputStream = new FileOutputStream(nirFile);
                        document.write(outputStream);
                        outputStream.close();
                        Desktop.getDesktop().open(nirFile);
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                try{
                    FileWriterUtil.writeDataFromTable(tb);
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        JPanel p1=new JPanel(new GridLayout(4,1));
         p1.add(l1);p1.add(b1);p1.add(l6);p1.add(b2);

        JScrollPane scroll=new JScrollPane(tb);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel p2=new JPanel();
        JPanel p2b=new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2b.add(b3);
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p2.add(scroll);p2.add(p2b);

        setLayout(new BorderLayout());
        add(p,BorderLayout.WEST);
        add(p1,BorderLayout.EAST);
        add(p2,BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    private class Ascultator implements ActionListener{
        private ListaFurnizori lf;
        Ascultator(){  lf=ListaFurnizori.getInstance();}
        public void actionPerformed(ActionEvent e){
            File f = new File("listaPersoaneJuridice.txt");
            if (e.getSource() == b2) {
                if (!f.exists()) {
                    try {
                        if (!f.createNewFile())
                            JOptionPane.showMessageDialog(null, "Fisierul cu furnizori nu exista!");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    if (!tf1.getText().equals("") && !tf3.getText().equals("") && !tf2.getText().equals("") && !tf6.getText().equals("")&& !tf4.getText().equals("")&& !tf7.getText().equals("")&& !tf5.getText().equals(""))
                        lf.adaugaFurnizorPersJuridica(tf1.getText(), tf4.getText(),(String) cb.getSelectedItem(), tf7.getText(), tf6.getText (), tf3.getText(),tf2.getText());
                    else JOptionPane.showMessageDialog(null,"Completati toate campurile","Information",JOptionPane.INFORMATION_MESSAGE);

                    try {
                        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
                        pw.println(tf1.getText() + "|" + tf4.getText() + "|" + cb.getSelectedItem() + "|" + tf7.getText() + "|"+ tf6.getText() + "|" + tf3.getText()+"|"+ tf2.getText());
                        pw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        }

    private void generareRanduri(int numarPachete,String tip){
        TreeSet<Colet> sortedColete = new TreeSet<>(Comparator.comparingInt(Colet::getNumar));
        sortedColete.addAll(listaColete.getColet());
        listaColete.getColet().clear();
        listaColete.getColet().addAll(sortedColete);

        DefaultTableModel model=(DefaultTableModel) tb.getModel();

        model.setRowCount(0);

        for(int i=1;i<=numarPachete;i++){
            Colet colet=new Colet();
            colet.setNumar(i);
            colet.setZona((String) cb.getSelectedItem());
            colet.setTip(tip);
            listaColete.getColet().add(colet);

            String [] rowData={"Pachet "+tip+" "+ i,"","","","",""};
            model.addRow(rowData);
        }
    }

    private void renumeroteazaPachete() {
        List<Colet> sortedColete = new ArrayList<>(listaColete.getColet());
        Collections.sort(sortedColete, Comparator.comparingInt(Colet::getNumar));
        int numarPachete = 1;
        for (Colet colet : sortedColete) {
            colet.setNumar(numarPachete++);
        }

        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt("Pachet P.J. " + (i + 1), i, 0);
        }
    }
    private void actualizeazaNumarPachete() {
        int numarPachete = tb.getRowCount();
        tf5.setText(String.valueOf(numarPachete));
    }
    public static void verificaContBancar(String contBancar) {
        if(contBancar.length()!=24) JOptionPane.showMessageDialog(null,"Nu ati introdus corect contul bancar","Information",JOptionPane.INFORMATION_MESSAGE);

    }
    private String formateazaCodBancar(String codBancar){
        StringBuilder formattedCodBancar = new StringBuilder(codBancar);
        formattedCodBancar.insert(2, ' ');
        formattedCodBancar.insert(5, ' ');
        formattedCodBancar.insert(10, ' ');
        formattedCodBancar.insert(15, ' ');
        formattedCodBancar.insert(20, ' ');
        formattedCodBancar.insert(25, ' ');
        return formattedCodBancar.toString();
    }
    private String formateazaNrTel(String numarTel){
        if(numarTel.length()==12){
            StringBuilder sb=new StringBuilder(numarTel);
            sb.insert(3,' ');
            sb.insert(7,' ');
            sb.insert(11,' ');
            return sb.toString();
        }else if(numarTel.length()==10){
            StringBuilder sb1=new StringBuilder(numarTel);
            sb1.insert(4,' ');
            sb1.insert(8,' ');
            return sb1.toString();
        }else if(numarTel.length()==9){
            StringBuilder sb2=new StringBuilder(numarTel);
            sb2.insert(3,' ');
            sb2.insert(7,' ');
            return sb2.toString();
        }else return null;
    }

}
