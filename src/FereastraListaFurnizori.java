import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FereastraListaFurnizori extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton b1;
    private int id = 0;


    public FereastraListaFurnizori() {
        super("Vizualizare furnizori");
        String[] columnNames = {"Nume", "Adresa", "Judet", "Nr. Telefon", "Cont", "Nr.Inreg.Ord.Com.", "C.I.F.", "Id"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);



        b1 = new JButton("Sterge");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaFurnizori listaFurnizori = ListaFurnizori.getInstance();
                int randSelectat = table.getSelectedRow();
                String tipFurnizor = tableModel.getValueAt(randSelectat, 5).toString();

                if (randSelectat != -1 && tipFurnizor.trim().equals("-")) {
                    listaFurnizori.stergeFurnizorPersoanaFizica(randSelectat);
                    tableModel.removeRow(randSelectat);
                }
                if (randSelectat != -1 && tipFurnizor.startsWith("J")) {
                    int indexFJ=randSelectat- listaFurnizori.getListaPersoaneFizice().size();
                    if(indexFJ>=0 && indexFJ<listaFurnizori.getListaPersoaneJuridice().size()){
                        listaFurnizori.stergeFurnizorPersoanaJuridica(indexFJ);
                        tableModel.removeRow(randSelectat);
                    }


                }

            }

        });
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(b1);


        adaugaFurnizoriLaTabel();
        adaugaId();
        JScrollPane scrollPane = new JScrollPane(table);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);
        Font font = table.getFont();
        Font bold = font.deriveFont(Font.BOLD);
        Font marime = bold.deriveFont(13f);
        table.setFont(marime);
        table.setEnabled(true);

        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
    }

    private void adaugaFurnizoriLaTabel() {
        ListaFurnizori listaFurnizori = ListaFurnizori.getInstance();
        List<FurnizorPersoanaFizica> listaPF = listaFurnizori.getListaPersoaneFizice();
        List<FurnizorPersoanaJuridica> listaPJ = listaFurnizori.getListaPersoaneJuridice();
        Collections.sort(listaPF, Comparator.comparing(FurnizorPersoanaFizica::getNume, String.CASE_INSENSITIVE_ORDER));
        Collections.sort(listaPJ, Comparator.comparing(FurnizorPersoanaJuridica::getNume, String.CASE_INSENSITIVE_ORDER));

        for (FurnizorPersoanaFizica furnizorPF : listaPF) {
            String[] rowData = {
                    furnizorPF.getNume(),
                    furnizorPF.getAdresaSauSediu(),
                    furnizorPF.getZona(),
                    furnizorPF.getNrTelefon(),
                    furnizorPF.getContBancar(),
                    furnizorPF.getNoOption(),
                    furnizorPF.getNoOption(),
                    String.valueOf(adaugaId())
            };
            tableModel.addRow(rowData);
        }

        for (FurnizorPersoanaJuridica furnizorPJ : listaPJ) {
            String[] rowData1 = {
                    furnizorPJ.getNume(),
                    furnizorPJ.getAdresaSauSediu(),
                    furnizorPJ.getZona(),
                    furnizorPJ.getNrTelefon(),
                    furnizorPJ.getContBancar(),
                    furnizorPJ.getNrRegOrd(),
                    furnizorPJ.getCodFiscal(),
                    String.valueOf(adaugaId())
            };
            tableModel.addRow(rowData1);
        }
    }

    public int adaugaId() {
        id++;
        return id;
    }

}





