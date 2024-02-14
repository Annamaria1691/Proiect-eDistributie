public class FurnizorPersoanaFizica extends Persoana{
    public FurnizorPersoanaFizica(String nume, String adresaSauSediu, String zona,String nrTelefon, String contBancar) {
        super(nume,adresaSauSediu,zona,nrTelefon,contBancar);
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
    public String getInfoPF(){
        return getNume() + "|"+ getAdresaSauSediu()+ "|"+ getZona()+ "|"+getNrTelefon()
                + "|"+ getContBancar();
    }
    public String getNoOption(){   return "               -";};

}
