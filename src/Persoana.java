public  abstract class Persoana {
    public String nume;
    public String adresaSauSediu;
    public String zona;
    public String contBancar;
    public String nrTelefon;

    public Persoana(String nume, String adresaSauSediu, String zona, String nrTelefon, String contBancar) {
        this.nume = nume;
        this.adresaSauSediu = adresaSauSediu;
        this.zona = zona;
        this.contBancar = contBancar;
        this.nrTelefon = nrTelefon;
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
}
