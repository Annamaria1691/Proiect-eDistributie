import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaFurnizori {
    private List<FurnizorPersoanaFizica> tf;
    private List<FurnizorPersoanaJuridica> tfj;
    private static ListaFurnizori lc;
    private String linie, linie1;
    private BufferedReader br, br1;


    private ListaFurnizori() {
        tf = new ArrayList<>();
        tfj = new ArrayList<>();
        FurnizorPersoanaFizica f = null;
        FurnizorPersoanaJuridica fj = null;
        File fila = new File("listaPersoaneFizice.txt");
        File fila2 = new File("listaPersoaneJuridice.txt");
        try {
            br = new BufferedReader(new FileReader(fila));
            while ((linie = br.readLine()) != null) {
                String[] s = linie.split("\\|");
                f = new FurnizorPersoanaFizica(s[0], s[1], s[2], s[3], s[4]);
                tf.add(f);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            br1 = new BufferedReader(new FileReader(fila2));
            while ((linie1 = br1.readLine()) != null) {
                String[] s1 = linie1.split("\\|");
                fj = new FurnizorPersoanaJuridica(s1[0], s1[1], s1[2], s1[3], s1[4], s1[5], s1[6]);
                tfj.add(fj);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FurnizorPersoanaFizica> getListaPersoaneFizice() {
        return tf;
    }

    public List<FurnizorPersoanaJuridica> getListaPersoaneJuridice() {
        return tfj;
    }


    public static ListaFurnizori getInstance() {
        if (lc == null) {
            lc = new ListaFurnizori();
        }
        return lc;
    }

    public void adaugaFurnizorPersFizica(String nume, String adresa, String zona, String nrTelefon, String contBancar) {
        boolean b = tf.add(new FurnizorPersoanaFizica(nume, adresa, zona, nrTelefon, contBancar));
        if (b) JOptionPane.showMessageDialog(null, "Persoana a fost adaugata cu succes!", "Information", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Persoana exista deja!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void adaugaFurnizorPersJuridica(String nume, String adresa, String zona, String nrTel, String contBancar, String nrOrdRegCom, String CIF) {
        boolean b1 = tfj.add(new FurnizorPersoanaJuridica(nume, adresa, zona, nrTel, contBancar, nrOrdRegCom, CIF));
        if (b1)
            JOptionPane.showMessageDialog(null, "Firma a fost adaugata cu succes!", "Information", JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null, "Firma exista deja!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizeazaFisierPJ() {
        try (PrintWriter pw1 = new PrintWriter(new FileWriter("listaPersoaneJuridice.txt"))) {
            for (FurnizorPersoanaJuridica furnizorPJ : tfj) {
                String linie1 = furnizorPJ.getInfoPJ();
                pw1.println(linie1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stergeFurnizorPersoanaFizica(int index) {
        if (index >= 0 && index < tf.size()) {
            tf.remove(index);
            actualizeazaFizierPF();
        }
    }
    public void actualizeazaFizierPF() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("listaPersoaneFizice.txt"))) {
            for (FurnizorPersoanaFizica furnizorPF : tf) {
                String line = furnizorPF.getInfoPF();
                pw.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stergeFurnizorPersoanaJuridica(int index) {
        if (index >= 0 && index < tfj.size()){
            tfj.remove(index);
            actualizeazaFisierPJ();
        }
    }
   public String getListaFurnizori() {
        StringBuilder sb = new StringBuilder();

        List<FurnizorPersoanaFizica> listaPF = new ArrayList<>(tf);
        List<FurnizorPersoanaJuridica> listaPJ = new ArrayList<>(tfj);

        listaPF.sort(Comparator.comparing(FurnizorPersoanaFizica::getNume));
        listaPJ.sort(Comparator.comparing(FurnizorPersoanaJuridica::getNume));

        for (FurnizorPersoanaFizica furnizorPF : listaPF) {
            sb.append(furnizorPF.getInfoPF()).append("\n");
        }
        for (FurnizorPersoanaJuridica furnizorPJ : listaPJ) {
            sb.append(furnizorPJ.getInfoPJ()).append("\n");

        }

        return sb.toString();
    }
    public List<String> furnizori(){
        furnizori().add(getListaFurnizori());
        return furnizori();
    }




}

