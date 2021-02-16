/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package zad2;


public class Purchase {
    String iDTranakcji;
    String nazwisko;
    String imie;
    String da;
    String nazwa;
    double cena;
    int suma;
    double ilosc;

    public Purchase(String di_klient, String nazwisko_imie, String nazwa, double cena, double ilosc) {
        this.iDTranakcji = di_klient;
        this.nazwisko = nazwisko_imie;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public String getiDTranakcji() {
        return iDTranakcji;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNazwa() {
        return nazwa;
    }


    public double getCena() {
        return cena;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setiDTranakcji(String iDTranakcji) {
        this.iDTranakcji = iDTranakcji;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return iDTranakcji + ';' + nazwisko + ';' +nazwa + ';' +cena +
                ";" + ilosc + "\n";
    }
}
