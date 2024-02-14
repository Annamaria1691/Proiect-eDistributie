import javax.swing.*;
import java.util.TreeSet;

public class ListaColete {
    private TreeSet<Colet> tc;
    private static ListaColete lc;

    private ListaColete() {
        tc = new TreeSet<>();
        setNumarColete("");
    }

    private void setNumarColete(String zona) {
        String[] listaJudete = {"Bucuresti Sectorul 1", "Bucuresti Sectorul 2", "Bucuresti Sectorul 3", "Bucuresti Sectorul 4", "Bucuresti Sectorul 5", "Bucuresti Sectorul 6", "Alba", "Arad", "Arges", "Bacău", "Bihor", "Bistriţa-Năsăud", "Botoşani", "Braşov", "Brăila", "Buzău", "Caraş-Severin", "Călăraşi", "Cluj", "Constanţa", "Covasna", "Dâmboviţa", "Dolj", "Galaţi", "Giurgiu", "Gorj", "Harghita", "Hunedoara", "Ialomiţa", "Iaşi", "Ilfov", "Maramureş", "Mehedinţi", "Mureş", "Neamţ", "Olt", "Prahova", "Satu Mare", "Sălaj", "Sibiu", "Suceava", "Teleorman", "Timiş", "Tulcea", "Vâlcea", "Vaslui", "Vrancea"};
        for (int i = 1; i < 500; i++) {
            Colet c = new Colet();
            c.setNumar(i);
            c.setZona(zona);
            tc.add(c);
            if (c.getGreutate() > 150) {
                JOptionPane.showMessageDialog(null, "Greutatea coletului cu numărul " + c.getNumar() + " depășește 150kg.");
            }
        }
    }
    public TreeSet<Colet> getColet() {
        return tc;
    }
    public String getInfoColet(){
        StringBuffer rez=new StringBuffer();
        for(Colet f:tc)rez.append(f.getInfoColet()+ "\n");
        return rez.toString();
    }

    public static ListaColete getInstance(){
        if(lc==null){
            lc=new ListaColete();
        }
        return lc;
    }
    public void adaugaColet(int numar, String zona,String tip,double valoareDeclarata, double greutate, String continut, String expeditor){
        boolean b=tc.add(new Colet(numar,zona,tip,valoareDeclarata,greutate,continut,expeditor));
        if(b) JOptionPane.showMessageDialog(null,"Coletul a fost adaugat!","Information",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null,"Coletul exista deja!","Information",JOptionPane.INFORMATION_MESSAGE);
    }



}

