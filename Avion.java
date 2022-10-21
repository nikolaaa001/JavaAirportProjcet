package projekat;
public class Avion {
    private String oznakaAviona, klasa; //klasa kao privatni, vojni, putnicki, teretni
    int brojPutnika, brojOsoblja;
    double tezinaPrtljaga, tezinaTereta;

    public Avion(String oznakaAviona, String klasa, int brojPutnika, int brojOsoblja, double tezinaPrtljaga, double tezinaTereta) {
        this.oznakaAviona = oznakaAviona;
        this.klasa = klasa;
        this.brojPutnika = brojPutnika;
        this.brojOsoblja = brojOsoblja;
        this.tezinaPrtljaga = tezinaPrtljaga;
        this.tezinaTereta = tezinaTereta;
    }

    public String getOznakaAviona() {
        return oznakaAviona;
    }

    public void setOznakaAviona(String oznakaAviona) {
        this.oznakaAviona = oznakaAviona;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public int getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(int brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public int getBrojOsoblja() {
        return brojOsoblja;
    }

    public void setBrojOsoblja(int brojOsoblja) {
        this.brojOsoblja = brojOsoblja;
    }

    public double getTezinaPrtljaga() {
        return tezinaPrtljaga;
    }

    public void setTezinaPrtljaga(double tezinaPrtljaga) {
        this.tezinaPrtljaga = tezinaPrtljaga;
    }

    public double getTezinaTereta() {
        return tezinaTereta;
    }

    public void setTezinaTereta(double tezinaTereta) {
        this.tezinaTereta = tezinaTereta;
    }
    
    @Override
    public String toString() {
        return "Avion: oznakaAviona=" + oznakaAviona + ", klasa=" + klasa + ", brojPutnika=" + brojPutnika + ", brojOsoblja= " +brojOsoblja+ 
                ", tezinaTereta=" +tezinaTereta + ", tezinaPrtljaga= "+tezinaPrtljaga;
    }
    
    
    
}
