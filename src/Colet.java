import java.util.Objects;

public class Colet implements Comparable<Colet> {
    private String nume;
    private int numar;
    private double greutate;
    private String zona;
    private double valoareDeclarata;
    private  StareColet stare;
    private String tip;
    private String continut;
    private String expeditor;




    public Colet(int numar, String zona, String tip, double valoareDeclarata, double greutate, String continut,String expeditor) {
        this.numar = numar;
        this.zona = zona;
        this.tip = tip;
        this.valoareDeclarata = valoareDeclarata;
        this.greutate = greutate;
        this.continut = continut;
        this.expeditor=expeditor;
    }

    public Colet(){}

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

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    public enum StareColet{
        LIVRARE_CU_PRIOITATE("Livrare cu prioritate"),

        LIVRARE_STANDARD("Livrare standard");
        private final String descriere;
        StareColet(String descriere){
            this.descriere=descriere;
        }

        public String getDescriere() {
            return descriere;
        }
    }
    public int compareTo(Colet c){
        return Integer.compare(this.numar,c.numar);
    }
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() !=o.getClass()) return false;
        Colet colet=(Colet) o;
        return numar==colet.numar && Objects.equals(zona,colet.zona);
    }
    public int hashCode(){
        return Objects.hash(numar,zona);
    }
    public double getValoareDeclarata() {
        return valoareDeclarata;
    }

    public void setPret(double valoareDeclarata) {
        this.valoareDeclarata = valoareDeclarata;
    }

    public StareColet getStare() {
        return stare;
    }

    public void setStare(StareColet stare) {
        this.stare = stare;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getInfoColet(){
        return getNumar() + " "+ getZona()+ " "+ getTip()+ " "+
                getValoareDeclarata()+ " "+ getGreutate()+" "+getContinut()+" "+getExpeditor();
    }
}
