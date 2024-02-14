public class FurnizorPersoanaJuridica extends Persoana{
    private String nrRegOrd;
    private String codFiscal;
    public FurnizorPersoanaJuridica(String nume, String adresaSauSediu, String zona, String nrTelefon, String contBancar, String nrRegOrd, String codFiscal) {
        super(nume,adresaSauSediu,zona,nrTelefon,contBancar);
        this.nrRegOrd = nrRegOrd;
        this.codFiscal = codFiscal;
    }

    public String getNrRegOrd() {
        return nrRegOrd;
    }

    public void setNrRegOrd(String nrRegOrd) {
        this.nrRegOrd = nrRegOrd;
    }

    public String getCodFiscal() {
        return codFiscal;
    }

    public void setCodFiscal(String codFiscal) {
        this.codFiscal = codFiscal;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresaSauSediu() {
        return adresaSauSediu;
    }

    public void setAdresaSauSediu(String adresaSauSediu) {
        this.adresaSauSediu = adresaSauSediu;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContBancar() {
        return contBancar;
    }

    public void setContBancar(String contBancar) {
        this.contBancar = contBancar;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }
    public String getInfoPJ(){
        return getNume() + "|"+getAdresaSauSediu()+"|"+getZona()+"|"+ getNrTelefon()+ "|"+ getContBancar()+ "|"+
                getNrRegOrd()+ "|"+ getCodFiscal();
    }
}
