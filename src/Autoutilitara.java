public class Autoutilitara implements Comparable<Autoutilitara>{
        private String nume="Transport";
        private int numar;
        private int gabarit=1300;

        private StareAutoutilitara stare;

    public Autoutilitara (String nume, int numar, int gabarit) {
        this.nume = nume;
        this.numar = numar;
        this.gabarit = gabarit;

    }
    public Autoutilitara(int numar){
        this.numar=numar;
        this.stare=StareAutoutilitara.LIBERA;
    }
    public Autoutilitara(){}
    public enum StareAutoutilitara{
        LIBERA,
        OCUPATA
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public int getGabarit() {
        return gabarit;
    }

    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    public StareAutoutilitara getStare() {
        if(stare==null){
            return StareAutoutilitara.LIBERA;
        }else return StareAutoutilitara.OCUPATA;
    }

    public void setStare(StareAutoutilitara stare) {
        this.stare = stare;
    }
    public int compareTo(Autoutilitara a){
        return Integer.compare(this.numar,a.numar);
    }
}
